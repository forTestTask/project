package Functional;

import Pages.*;
import Parent.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationAndLoginTest extends BaseTest {


    public int count = 0;

    @BeforeGroups("User Registration Testing")
    public void createTitleToTestRegistration() {
        list.add("User Registration Testing");
    }

    @BeforeGroups("User Authorization Testing")
    public void createTitleToTestAuthorization() {
        list.add("User Authorization Testing");
    }


    @Test (dataProvider = "registration", groups = "User Registration Testing")
    public void registration(String url, String lang) throws Exception {
        logger.info("///////////////////START LOG REGISTRATION///////////////////");
        reportData.put("URL", url);
        reportData.put("language", lang);
        reportData.put("Additional Info", "");
        clearBrowserCookies();



        try {
            crmApiWork.loginApache();
        } catch (Exception ex) {
            logger.debug("Error :", ex);
            utilities.screenshot(WebDriverRunner.getWebDriver(), utilities.getPathByURL(url), "loginApache");
            throw (ex);
        }

        open(utilities.getMailUrl());
        logger.info("Open = " + utilities.getMailUrl());

        if(!WebDriverRunner.getWebDriver().getCurrentUrl().contains("bla_bla")){
            open(utilities.getMailUrl());
        }
        do {
            mailRandomizer.putApiKeyAndGetEmail(utilities.getApiKey());
        } while (!crmApiWork.emailCheck(mailRandomizer.email, utilities.getDomainName()));
        logger.info("Get email for test = " + mailRandomizer.email);


        RegistrationPage registrationPage = open(url, RegistrationPage.class);
        /**
         * Проверка страны окружения
         * Если Укр - кнопка регистрации должна быть заблокирована
         * Если France - разблокирована
         */

        if(System.getenv("server").contains("Moscow")){
            try {
                logger.info("Start test on Moscow");
                long startTimeTest = System.currentTimeMillis();
                registrationPage.getRegistrationButton().shouldHave(Condition.attribute("class", "auth-block__link auth-block__reg disabled-btn__register"));
                logger.info(registrationPage.getRegistrationButton().getAttribute("class"));
                reportData.put("Status", "Passed");
                logger.info("Test PASSED");
                reportData.put("Testing time (s)", utilities.testTime(startTimeTest));
            }catch (AssertionError ex){
                logger.error("Error: ", ex);
                reportData.put("Additional Info", "Error while testing buttons");
                Assert.fail("Error while testing buttons");
            }

        }else {
            logger.info("Start test on France");
            utilities.addCookie();
            long startTimeTest = System.currentTimeMillis();

            registrationPage.getRegistrationButton().shouldHave(Condition.attribute("class", "auth-block__link auth-block__reg")).click();

            logger.info("Fill first registration page");
            utilities.expectedData.put("firstName", registrationPage.getFirstNameFiels().val(utilities.randomName()));
            utilities.expectedData.put("lastName", registrationPage.getLastNameField().val(utilities.randomName()));
            utilities.expectedData.put("email", registrationPage.getEmailField().val(mailRandomizer.email));
            registrationPage.getPhoneField().val(utilities.getRandomPhone());
            registrationPage.getPasswordField().val(utilities.getFirstPass());
            registrationPage.pointCheckBoxes();

            EmailVerificationPage emailVerificationPage = registrationPage.clickOpenAccountButton();
            logger.info("First page completed successfully");

            emailVerificationPage.getTitleH1().shouldHave(Condition.text("Email Verification"));

            /**
             * Возвращаемс на почту и берем код подтверждения
             */
            utilities.openNewTab();

            mailRandomizer.loginMailBox();
            mailRandomizer.takeVerificationCode();
            logger.info("Take verification code = " + mailRandomizer.verificationCode);
            utilities.closeTab();
            emailVerificationPage.getCodeField().val(mailRandomizer.verificationCode);
            emailVerificationPage.getContinueButton().click();
            emailVerificationPage.getSuccessText()
                    .waitUntil(Condition.visible,5000)
                    .shouldHave(Condition.text("The email address confirmed"));
            logger.info("The email address confirmed");
            AuthenticationPage authenticationPage = emailVerificationPage.clickContinueWhenSuccessButton();
            registrationPage.deleteFooter();
            sleep(1000);

            //General Information
            logger.info("Fill General Information");
            authenticationPage.pickGender();
            authenticationPage.getDateOfBirth().val("05.05.1990");
            authenticationPage.getPlaceOfBirth().val("Ukraine");
            authenticationPage.pickCitizenShip();


            //Passport/ID
            authenticationPage.getPassportNumber().val("123213");
            authenticationPage.getNationalID().val("234234");

            //Address
            authenticationPage.getAddressLine1().val("Street");
            authenticationPage.getAddressLine2().val("Karla Marla");
            authenticationPage.getCity().val("Dnepr");
            authenticationPage.getPostalCode().val("49666");
            authenticationPage.pickCountryOfResindence();

            //TIN
            authenticationPage.pickTaxOfResindent();
            authenticationPage.getTaxIdentificationNumber().val("234234");

            //PEP
            authenticationPage.getNot_a_PEP_Checkbox().click();
            authenticationPage.getI_am_not_a_US_reportable_person_Checkbox().click();
            authenticationPage.getContinueButton().click();
            sleep(1000);

            /**
             * Economic Profile PAGE
             */
            logger.info("Fill Economic Profile PAGE");
            //What's the purpose for applying for a Trading Account?
            authenticationPage.getTradingForexCheckBox().click();

            //What is the nature of the transactions on your Trading Account?
            authenticationPage.getSpeculationCheckBox().click();

            //Employment Status:
            authenticationPage.getEmployedRadioButton().click();

            //Occupation
            authenticationPage.pickOccupation();

            //CompanyName
            authenticationPage.getCompanyNameField().val("TestCompany");

            //Your Source of Income:
            authenticationPage.getSavingsRadioButton().click();

            //Your Net Annual Income:
            authenticationPage.pickFirstPriceRangeButton();

            //Net Wealth:
            authenticationPage.pickSecondPriceRangeButton();

            //Anticipated Annual Investment Amount:
            authenticationPage.pickThirdPriceRangeButton();

            //The expected way of depositing funds to the account:
            authenticationPage.pickFirstBankAccountButton();

            //The expected way of funds withdrawal:
            authenticationPage.pickSecondBankAccountButton();
            authenticationPage.getSaveAndContinueButton().click();
            sleep(1000);


            /**
             * Trading Experience PAGE
             */
            logger.info("Fill Trading Experience PAGE");

            //The Level of your Education:
            authenticationPage.getSecondaryDegreeButton().click();

            //Do you have relevant professional experience that has provided you with a good understanding
            // of trading and the risks involved in CFDs, Foreign Exchange Derivatives or Spread Betting?
            authenticationPage.getWorkedForButton().click();

            //Do you have a relevant professional or academic qualification that would provide you
            // with a good understanding of the risks involved in trading leveraged and derivative products?
            authenticationPage.pickYesFirstButton();

            //Have you attended any educational seminars or training courses on CFDs, Foreign Exchange Derivatives or Spread Betting?
            authenticationPage.pickYesSecondButton();
            authenticationPage.getSaveAndContinueFourButton().click();
            $(By.xpath("//form[@class='register step_five-two']//h3")).waitUntil(Condition.text("Your Trading Experience"),2000);
            sleep(1000);


            /**
             * Trading Experience Second PAge
             */
            logger.info("Fill Trading Experience Second PAge");

            //Leveraged Products (Forex & CFDs)
            authenticationPage.pickLessThanButton();

            //Equities (Stocks & ETFs)
            authenticationPage.pickLessThanSecondButton();

            //During the last three years, have you made forty trades in one twelve-month period where you made your own trading decisions?
            authenticationPage.pickYesThirdButton();

            //How are the majority of your trades in CFDs, Foreign Exchange Derivates or Spread Betting undertaken?
            authenticationPage.getMakeMyOwnButton().click();
            authenticationPage.getSaveAndContinueFiveButton().click();
            $(By.xpath("//form[@class='register step_five-three']//h3")).waitUntil(Condition.text("Your Trading Knowledge and Understanding of Risk Assessment"),2000);
            sleep(1000);

            /**
             * Trading Experience Third PAge
             */
            logger.info("Fill Trading Experience Third PAge");
            //When trading CFDs with leverage of 300 would small change to the value of the underlying financial instrument result in a disproportionately large movement in your gain or loss?
            authenticationPage.pickYesFoursButton();

            //If you have a buy position in a CFD and the current price is below your buy price, would you make or lose money?
            authenticationPage.getMake().click();

            //What would be the required margin for 1 Lot (100,000 GBP/USD), if your margin is 1% (leverage 1:100)
            authenticationPage.getE1000Button().click();

            //What type of closing order can you choose to help limit losses when trading?
            authenticationPage.getStopLossButton().click();

            //If you trade £1 per point of the FTSE @7000 what would the notional value of the following trade be?
            authenticationPage.getE700Button().click();
            authenticationPage.getSaveAndContinueSixButton().click();
            logger.info("All pages are complete");
            sleep(1000);

            //waitPopup
            logger.info("Waiting popUp");
            authenticationPage.getQuizResultPopUP().waitUntil(Condition.visible, 2000);
            authenticationPage.getQiuzAgreeButton().click();
            authenticationPage.getInfoSubmittedText().waitUntil(Condition.visible, 1000).shouldHave(Condition.text("Your info has been submitted!"));
            logger.info("Your info has been submitted!");
            try {
                MyAccount myAccount = authenticationPage.getDepositeButton();
                switchTo().frame(0);
                myAccount.getSignOutButton().waitUntil(Condition.visible, 10000);
                logger.info("We in My acoount");
                reportData.put("Status", "Passed");
            }catch (AssertionError ex){
                logger.error("Error while logging after registration", ex);
                reportData.put("Additional Info", "Error while logging after registration");
                Assert.fail("Error while logging after registration");
            }





            /**
             * Проверка в CRM
             */


            /**
             *
             */
            logger.info("REGISTRATION TEST FINISHED");
            reportData.put("Testing time (s)", utilities.testTime(startTimeTest));

        }
    }

    @Test (dataProvider = "authorization", priority = 1, groups = "User Authorization Testing")
    public void authorization(String url, String lang){
        logger.info("///////////////////START LOG AUTHORIZATION///////////////////");
        clearBrowserCookies();
        count = 0;
        reportData.put("URL", url);
        reportData.put("language", lang);
        reportData.put("Additional Info", "");
        reportData.put("apiStatus", "-");

        LoginPage loginPage = open(url, LoginPage.class);
        utilities.addCookie();
        long startTimeTest = System.currentTimeMillis();

        if(System.getenv("server").contains("Moscow")){
            logger.info("Start test on Moscow");
            try {
                loginPage.getLoginButtonMainPage().shouldHave(Condition.attribute("class", "auth-block__link auth-block__login auth_button-login disabled-btn__register"));
                logger.info(loginPage.getLoginButtonMainPage().getAttribute("class"));
                reportData.put("Status", "Passed");
                logger.info("Test PASSED");
                reportData.put("Testing time (s)", utilities.testTime(startTimeTest));
            }catch (AssertionError ex){
                logger.error("Error in My Acc", ex);
                reportData.put("Additional Info", "Error in My Acc");
                Assert.fail("Error in My Acc");
            }

        }else {
            try {
                logger.info("Start test on France");
                loginPage.getLoginButtonMainPage().shouldHave(Condition.attribute("class", "auth-block__link auth-block__login auth_button-login")).click();
                loginPage.getTitleText().waitUntil(Condition.visible, 5000).shouldHave(Condition.text("Login"));
//                switchTo().frame(0);
                loginPage.getEmailField().val(mailRandomizer.mailList.get(count));
                loginPage.getPasswordField().val("1q2w3e4r");
                MyAccount myAccount = loginPage.clickLoginButton();
                switchTo().frame(0);
                myAccount.getSignOutButton().waitUntil(Condition.visible, 10000);
                logger.info("We in My acoount");


                reportData.put("Status", "Passed");
                logger.info("TEST PASSED");
                reportData.put("Testing time (s)", utilities.testTime(startTimeTest));
            }catch (AssertionError ex){
                logger.error("Error in My Acc", ex);
                reportData.put("Additional Info", "Error in My Acc");
                Assert.fail("Error in My Acc");
            }

        }
        count++;

        reportData.put("Testing time (s)", utilities.testTime(startTimeTest));

    }


    @AfterGroups("User Registration Testing")
    public void clearCounter1() {
        count = 0;
    }
    @AfterGroups("User Authorization Testing")
    public void clearCounter2() {
        count = 0;
    }

    @AfterGroups("Reset Password Testing")
    public void clearCounter3() {
        count = 0;
    }

    @AfterMethod()
    public void clear(ITestResult result) {
        logger.info("///////////////////END LOG///////////////////");
        logger.info("\n");

        if (result.getStatus() == ITestResult.FAILURE) {
            reportData.put("Status", "False");


//            if (reportData.get("apiStatus") == null) {
//                reportData.put("apiStatus", "False");
//            }
            if (reportData.get("Additional Info") == null) {
                reportData.put("Additional Info", "Something went wrong");
            }
            if (reportData.get("Testing time (s)") == null) {
                reportData.put("Testing time (s)", "False");
            }
        }
        logger.info(reportData);
        list.add(utilities.lineToCSV(reportData));
        super.clear();
    }

    @AfterTest
    public void tearDown() {
        csvFileWriter.writeCsvFile("Report.csv", list);
    }

}
