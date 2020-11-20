package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyAccount {

    private SelenideElement signOutButton = $(By.xpath("//*[text()='Sign Out']"));

    public SelenideElement getSignOutButton() {
        return signOutButton;
    }
}
