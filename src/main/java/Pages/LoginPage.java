package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement loginButtonMainPage = $(By.xpath("//div[@class='controls']//a[@href='/authorization/']"));
    private SelenideElement titleText = $(By.xpath("//div[@class='auth__title page-title']"));
    private SelenideElement emailField = $(By.xpath("//input[@name='email']"));
    private SelenideElement passwordField = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginButton = $(By.xpath("//button[@class='btn auth__send']"));



    public SelenideElement getLoginButtonMainPage() {
        return loginButtonMainPage;
    }


    public SelenideElement getTitleText() {
        return titleText;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public MyAccount clickLoginButton() {
        loginButton.click();
        return page(MyAccount.class);
    }
}
