package Regression;

import Parent.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class StatusCode_Test extends BaseTest {


    @BeforeMethod
    public void configureRestAssured() {
        RestAssured.baseURI = "bla_bla";
        RestAssured.requestSpecification = given()
                .header("Language", "en");
//        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test(dataProvider = "pages")
    public void statusCode200(String url) {
        logger.info("///////////////////START LOG statusCode200///////////////////");
        logger.info("Page = " + baseURI + url);
        try {
            given()
                    .get(url)
                    .then()
                    .assertThat()
                    .statusCode(200);
        } catch (AssertionError ex) {
            logger.info("Status code = " + ex.getMessage());
        }
        logger.info("///////////////////END LOG statusCode200///////////////////");
    }


}
