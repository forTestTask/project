package Models;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class Utilities {

    private final String mailUrl;
    private final int apiKey;
    public Map expectedData;
    private String domainName = "bla_bla";
    public String[][] registrationUrlLost;
    public String[][] authorizationUrlList;
    public String[] pagesList;
    private SimpleDateFormat df2 = new SimpleDateFormat("m:ss:SSS");
    private static final int PHONE_NUMBER_LENGTH = 13;
    private String firstPass;
    private String secondPass;


    public Utilities() {
        mailUrl = "bla_bla";
        apiKey = 43673432;
        expectedData = new HashMap();
        firstPass = "1q2w3e4r";
        secondPass = "2w3e4r5t";

    }


    public int getApiKey() {
        return apiKey;
    }

    public void openNewTab(){
        executeJavaScript("window.open()");
        switchTo().window(1);
    }


    public void closeTab() {
            switchTo().window(1);
            WebDriverRunner.getWebDriver().close();
            switchTo().window(0);

    }

    /**
     * Method takes a screenshot
     *
     * @param driver Webdriver
     * @param name   screenshot name
     * @param step   step or flow
     * @throws Exception Exception
     */
    public void screenshot(WebDriver driver, String name, String step) throws Exception {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "\\src\\main\\resources\\";
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + path + name + "_" + step + ".png"));
    }

    public String getPathByURL(String url) {
        String[] subURL = url.split("/");
        return subURL[3];
    }

    public String getMailUrl() {
        return mailUrl;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setRegistrationLinks() {
        registrationUrlLost = new String[][]{
                {"bla_bla", "English"},
        };
    }
    public void setAuthorizationLinks() {
        authorizationUrlList = new String[][]{
                {"bla_bla", "English"},
        };
    }

    public void setPagesList() {
        pagesList = new String[]{
                "",
                "mt4/",
                "mt4-web-terminal/",
                "clients-categorisation/",
                "become-a-professional-client/",
                "deposits-and-withdrawals/",
//                "trading-specifications/",
                "economic-calendar/",
                "trading-hours/",
                "earnings-calendar/",
                "commodities/",
                "indices/",
                "forex/",
                "contacts/",
                "documents/terms-and-conditions/",
                "documents/privacy-policy/",
                "documents/risk-disclosure-statement/",
                "documents/",
        };
    }

    public String randomName() {
        return "test"+ RandomStringUtils.randomAlphabetic(6);
    }

    public String getRandomPhone() {
        String s = "123456789";
        StringBuilder phoneNumber = new StringBuilder();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return phoneNumber.toString();
    }

    public String lineToCSV(Map reportData){
        String linetoCSV;
        linetoCSV = reportData.get("URL").toString() + "," +
                reportData.get("language").toString() + "," +
                reportData.get("Status").toString() + "," +
                reportData.get("Testing time (s)").toString() + "," +
                reportData.get("Additional Info").toString();

//                reportData.get("apiStatus").toString();


        return  linetoCSV;
    }
    /**
     * Add cookie for some countries with Notification on registration page
     */
    public void addCookie(){
        Cookie ck = new Cookie("cookiePolicy", "yes");
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
        refresh();
    }


    public String testTime(Long startTime){
        return df2.format(System.currentTimeMillis()-startTime);
    }

    public String getFirstPass() {
        return firstPass;
    }

    public String getSecondPass() {
        return secondPass;
    }
}
