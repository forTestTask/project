package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement registrationButton = $(By.xpath("//div[@class='container header__container']//a[@href='/register/']"));
    private SelenideElement firstNameFiels = $(By.xpath("//input[@name='firstName']"));
    private SelenideElement lastNameField = $(By.xpath("//input[@name='lastName']"));
    private SelenideElement emailField = $(By.xpath("//input[@name='email']"));
    private SelenideElement phoneField = $(By.xpath("//input[@name='phone']"));
    private SelenideElement passwordField = $(By.xpath("//input[@id='_pass']"));
    private SelenideElement openAccountButton = $(By.xpath("//button[@class='btn register__send']"));
    private SelenideElement acceptCookieButton = $(By.xpath("//div[@id='cookieButton']"));
    private SelenideElement popUP = $(By.xpath("//div[@class='forbidden-popup__inner-wrapper ']"));
    private SelenideElement popUPButton = $(By.xpath("//a[@class='forbidden-popup__button btn']"));
    private ElementsCollection checkboxes = $$(By.xpath("//div[@class='register__checkboxes']/div/input"));


    public void pointCheckBoxes() {
        for (int i = 0; i < getCheckboxes().size() - 1; i++) {
            getCheckboxes().get(i).click();
        }
    }



    public void deleteFooter(){
        executeJavaScript("document.getElementsByClassName('text-optimization')[0].remove()");
    }


    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }

    public SelenideElement getFirstNameFiels() {
        return firstNameFiels;
    }

    public SelenideElement getLastNameField() {
        return lastNameField;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getPhoneField() {
        return phoneField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public EmailVerificationPage clickOpenAccountButton() {
        executeJavaScript("window.scrollBy(0,500)");
        openAccountButton.click();
        return page(EmailVerificationPage.class);
    }

    public ElementsCollection getCheckboxes() {
        return checkboxes;
    }

    public SelenideElement getAcceptCookieButton() {
        return acceptCookieButton;
    }

    public SelenideElement getPopUP() {
        return popUP;
    }

    public SelenideElement getPopUPButton() {
        return popUPButton;
    }
}
