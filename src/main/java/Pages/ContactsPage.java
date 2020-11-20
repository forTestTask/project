package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ContactsPage extends ParentPage {


    private SelenideElement image = $(By.xpath("//div[@class='wp-block-image']//img"));
    private SelenideElement contactForm = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']"));
    private ElementsCollection telephoneAndEmail = $$(By.xpath("//div[@class='contacts__info']//a"));
    private SelenideElement firstNameField = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']/div[1]"));
    private SelenideElement lastNameField = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']/div[2]"));
    private SelenideElement emailField = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']/div[3]"));
    private SelenideElement phoneField = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']/div[5]"));
    private SelenideElement subjectField = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']/div[6]"));
    private SelenideElement textField = $(By.xpath("//form[@class='contacts__form inner-form _valid-form']/div[6]"));
    private SelenideElement submitButton = $(By.xpath("//button[@class='btn contacts__send']"));



    public boolean isFormVisible(){
        if(getContactForm().isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public void imageVisibleAndHaveCorrcetLink(){
        getImage()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("src", "bla_bla"));
    }

    public void isTelephoneAndEmailCorrect(){
            getTelephoneAndEmail().get(0).shouldHave(Condition.text("+357 22 008 100"));
            getTelephoneAndEmail().get(1).shouldHave(Condition.text("info@gwglobalfx.com"));

    }

    public void checkValidation(){
        executeJavaScript("window.scrollBy(0,1200)");
        getSubmitButton().waitUntil(Condition.visible, 5000).click();
        getFirstNameField().shouldHave(Condition.cssClass("error"));
        getLastNameField().shouldHave(Condition.cssClass("error"));
        getEmailField().shouldHave(Condition.cssClass("error"));
        getPhoneField().shouldHave(Condition.cssClass("error"));
        getSubjectField().shouldHave(Condition.cssClass("error"));
        getTextField().shouldHave(Condition.cssClass("error"));
    }


    public SelenideElement getImage() {
        return image;
    }

    public ElementsCollection getTelephoneAndEmail() {
        return telephoneAndEmail;
    }

    public SelenideElement getContactForm() {
        return contactForm;
    }

    public SelenideElement getFirstNameField() {
        return firstNameField;
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

    public SelenideElement getSubjectField() {
        return subjectField;
    }

    public SelenideElement getTextField() {
        return textField;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }
}
