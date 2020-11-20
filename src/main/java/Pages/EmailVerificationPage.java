package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class EmailVerificationPage {

    private SelenideElement titleH1 = $(By.xpath("//h1"));
    private SelenideElement codeField = $(By.xpath("//input[@name='code']"));
    private SelenideElement continueButton = $(By.xpath("//button[@class='btn auth__send']"));
    private SelenideElement successText = $(By.xpath("//div[@class='ev__text-success']/p"));
    private SelenideElement continueWhenSuccessButton = $(By.xpath("//a[@class='btn btn-success-verification auth__send']"));



    public SelenideElement getTitleH1() {
        return titleH1;
    }

    public SelenideElement getCodeField() {
        return codeField;
    }

    public SelenideElement getContinueButton() {
        return continueButton;
    }

    public SelenideElement getSuccessText() {
        return successText;
    }

    public AuthenticationPage clickContinueWhenSuccessButton() {
        continueWhenSuccessButton.click();
        return page(AuthenticationPage.class);
    }
}
