package Pages;

import Models.Utilities;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class MailRandomizer {
    private Utilities utilities = new Utilities();
    public String email;
    private SelenideElement logout = $(By.xpath("//span[@id='selenium_logout_button']"));
    private ElementsCollection listTitleOfEmails = $$(By.xpath("//span[@data-bind = 'text: subjectForDisplay()']"));
    public ArrayList<String> mailList = new ArrayList<>();
    public String verificationCode = "";
    private SelenideElement verificationCodeText = $(By.xpath("//p/strong"));
    private SelenideElement refreshMailBox = $(By.xpath("//span[@class='item checkmail command enable']"));
    private SelenideElement emailTitle = $(By.xpath("//div[contains(@class, 'item dragHandle')]//span[@data-bind='text: subjectForDisplay()']"));



    public String putApiKeyAndGetEmail(int apikey){
        if(executeJavaScript("return document.readyState").equals("complete")) {
            $(By.xpath("//input[@name='apikey']")).waitUntil(Condition.visible,10000 ).val(String.valueOf(apikey)).pressEnter();
            mailList.add(email = $(By.xpath("//input[@type = 'text']")).getAttribute("value"));
            return email;
        }
        return null;
    }

    public void loginMailBox() {
        open("bla_bla");
        clearBrowserCookies();
        $(By.xpath("//input[@id='selenium_login_email']")).setValue(email);
        $(By.xpath("//input[@id='selenium_login_password']")).setValue("p@ssw0rd777");
        $("button[type=submit]").click();
        $(By.xpath("//span[@data-bind='text: mailLinkText']")).waitUntil(Condition.text(email), 20000);
    }

    public boolean takeVerificationCode() {
        int counter =2;
        sleep(1000);
        for (int j = 1; j < 5; j++) {
            ElementsCollection mailers = $$(By.xpath("//div[contains(@class, 'item dragHandle')]"));
            if (mailers.size() > 0) {

                for (int i = 0; i < mailers.size(); i++) {
                    SelenideElement mailerTitle = $(By.xpath("//div[contains(@class, 'item dragHandle')]["+ (i+1) +"]//span[@data-bind='text: subjectForDisplay()']"));
                    if(mailerTitle.getText().equals("Verification Code")){
                        mailers.get(i).click();
                        try {
                            verificationCode = getVerificationCodeText().waitUntil(Condition.visible, 3000).getText();
                            System.out.println("Code is FOUND");
                            return true;
                        } catch (AssertionError ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("Wrong mailer");
                            System.out.println("Check next mailer");
                        }
                    }
                }
                System.out.println("Code not found in mailers. Wait 5 sec and refresh mailbox");
                sleep(5000);
                getRefreshMailBox().click();
                System.out.println("Try #" + counter++);
            }
        }
        System.out.println("After 5 attempts, link not found");
        return false;

    }


    public SelenideElement getVerificationCodeText() {
        return verificationCodeText;
    }

    public SelenideElement getRefreshMailBox() {
        return refreshMailBox;
    }
}
