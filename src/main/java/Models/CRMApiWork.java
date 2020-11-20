package Models;


import org.apache.commons.codec.Charsets;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRMApiWork {
//    private String id;
//    private Map languages;
//    private String logonUrlUM;
//    private String logonUrlMM;
//    private String leadURL;
//    private String marketingInfoURL;

    private String loginUrl;
    private String[] dataList;
    private String leadsURL;
    private String requestBody;
    private Cookie cookie;
    private JSONArray countries;
    private Map actualData;




    public CRMApiWork() {
        loginUrl = "any_links";
        leadsURL = "any_links";





        actualData = new HashMap();


        String countryPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\country.json";
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(countryPath)));
        } catch (IOException e) {
            System.out.println("We have a problem with JSON");
            System.out.println(e.getMessage());
        }
        countries = new JSONArray(content);

        dataList = new String[] {
                "adData",
                "utmCampaign",
                "utmMedium",
                "utmSource",
                "utmTerm",
                "landingPage",
                "businessUnit",
                "utmContent",
                "adServer",
                "domainName",
                "firstName",
                "lastName",
                "countryCode",
                "language",
                "trackingLinkId"
        };





//        languages = new HashMap();
//        languages.put("36","Unknown");
//        languages.put("37","Arabic");
//        languages.put("39","Russian");
//        languages.put("40","Spanish");
//        languages.put("1108","ChineseBad");
//        languages.put("2557","Poland");
//        languages.put("2598","not use");
//        languages.put("2652","Germany");
//        languages.put("2708","Czech");
//        languages.put("2709","Italian");
//        languages.put("3001618","Chinese");
        }




        public void clearData()
        {
            actualData.clear();
        }




    public void loginApache() throws IOException {

        CookieStore httpCookieStore = new BasicCookieStore();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);
        HttpClient client =builder.build();
        HttpPost post = new HttpPost(loginUrl);
        post.setHeader("User-Agent", "Mozilla/5.0");
        post.setHeader("Accept-Language", "en-US,en;q=0.5");

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("login","aleksandrva"));
        urlParameters.add(new BasicNameValuePair("password",System.getenv("vasinskiy")));


        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response =  client.execute(post);

        if(response.getStatusLine().getStatusCode() >=300)
        {
            System.out.println("____________________________LOG BEGIN______________________________________________________");

            System.out.println("Response code: " + response.getStatusLine());


            System.out.println(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));

        }
        else {
            cookie = httpCookieStore.getCookies().get(0);
        }
    }

    public Map getActualData(String email, String firstName, String lastName) throws IOException {

        requestBody ="{\n" +
                "\"paging\":{\n" +
                "\"from\":0,\n" +
                "\"to\":50,\n" +
                "\"sorting\":[\n" +
                "]\n" +
                "},\n" +
                "\"filtering\":{\n" +
                "\"filters\":[\n" +
                "{\n" +
                "\"type\":\"String\",\n" +
                "\"condition\":\"equalsTo\",\n" +
                "\"value\":\"&1\",\n" +
                "\"column\":\"email\"\n" +
                "},\n" +
                "{\n" +
                "\"type\":\"String\",\n" +
                "\"condition\":\"equalsTo\",\n" +
                "\"value\":\"&2\",\n" +
                "\"column\":\"firstName\"\n" +
                "},\n" +
                "{\n" +
                "\"type\":\"String\",\n" +
                "\"condition\":\"equalsTo\",\n" +
                "\"value\":\"&3\",\n" +
                "\"column\":\"lastName\"\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "}\n";


        requestBody = requestBody.replaceAll("&1",email);
        requestBody = requestBody.replaceAll("&2",firstName);
        requestBody = requestBody.replaceAll("&3",lastName);

        CookieStore httpCookieStore = new BasicCookieStore();
        httpCookieStore.addCookie(cookie);
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);
        HttpClient client =builder.build();

        StringEntity requestEntity = new StringEntity(
                requestBody,
                ContentType.APPLICATION_JSON);
        HttpPost post = new HttpPost(leadsURL);
        post.addHeader("User-Agent", "Mozilla/5.0");
        post.addHeader("Accept-Language", "en-US,en;q=0.5");
        post.setEntity(requestEntity);

        HttpResponse response = client.execute(post);

        HttpEntity entity = response.getEntity();
        Header encodingHeader = entity.getContentEncoding();

// you need to know the encoding to parse correctly
        Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 :
                Charsets.toCharset(encodingHeader.getValue());

// use org.apache.http.util.EntityUtils to read json as string
        String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

        if(response.getStatusLine().getStatusCode() >=300)
        {
            for(String key : dataList)
            {
                actualData.put(key, "CRM not responding");
            }
            return actualData;
        }

        JSONObject responseJSON = new JSONObject(json);

        JSONArray clientData = responseJSON.getJSONArray("rows");

        for(String key : dataList)
        {
            try {
                if(!key.equals("countryCode")) {
                    actualData.put(key, clientData.getJSONObject(0).get(key).toString());
                }else {
                    actualData.put(key,getCountryCodeBName(clientData.getJSONObject(0).get("country").toString()));
                }
            }
            catch (Exception e)
            {
                actualData.put(key,"null");
            }
        }

        return actualData;
    }

    private String getCountryCodeBName(String name) throws IOException, ParseException {
        for(int i = 0; i < countries.length(); i++)
        {
            if(countries.getJSONObject(i).get("name").toString().equals(name))
            {
                return countries.getJSONObject(i).get("countryCode").toString();
            }
        }
        return "Error";
    }


    public boolean emailCheck(String email , String domain) throws IOException {

        requestBody ="{\n" +
                "\"paging\":{\n" +
                "\"from\":0,\n" +
                "\"to\":50,\n" +
                "\"sorting\":[\n" +
                "]\n" +
                "},\n" +
                "\"filtering\":{\n" +
                "\"filters\":[\n" +
                "{\n" +
                "\"type\":\"String\",\n" +
                "\"condition\":\"equalsTo\",\n" +
                "\"value\":\"&1\",\n" +
                "\"column\":\"email\"\n" +
                "},\n" +
                "{\n" +
                "\"type\":\"Enum\",\n" +
                "\"condition\":\"equalsTo\",\n" +
                "\"value\":\"&2\",\n" +
                "\"column\":\"domainName\"\n" +
                "}" +
                "]\n" +
                "}\n" +
                "}\n";


        requestBody = requestBody.replaceAll("&1",email);

        if(domain.equals("umarkets"))
        {
            requestBody = requestBody.replaceAll("&2","1090");
        }
        else{
            requestBody = requestBody.replaceAll("&2","1091");
        }

        CookieStore httpCookieStore = new BasicCookieStore();
        httpCookieStore.addCookie(cookie);
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);
        HttpClient client =builder.build();

        StringEntity requestEntity = new StringEntity(
                requestBody,
                ContentType.APPLICATION_JSON);
        HttpPost post = new HttpPost(leadsURL);
        post.addHeader("User-Agent", "Mozilla/5.0");
        post.addHeader("Accept-Language", "en-US,en;q=0.5");
        post.setEntity(requestEntity);

        HttpResponse response = client.execute(post);

        HttpEntity entity = response.getEntity();
        Header encodingHeader = entity.getContentEncoding();

// you need to know the encoding to parse correctly
        Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 :
                Charsets.toCharset(encodingHeader.getValue());

// use org.apache.http.util.EntityUtils to read json as string
        String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

        JSONObject responseJSON = new JSONObject(json);


      if(responseJSON.get("count").toString().equals("0"))
      {
          return true;
      }

      return false;



    }


}


