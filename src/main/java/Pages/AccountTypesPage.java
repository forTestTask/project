package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AccountTypesPage extends ParentPage {

    private SelenideElement accountTypesBlock = $(By.xpath("//div[@class='about-types-block']"));
    private ElementsCollection openAccountButtons = $$(By.xpath("//div[@class='about-types-block']//a"));
    private SelenideElement switchButton = $(By.xpath("//label[@class='switch']"));
    private SelenideElement usdText = $(By.xpath("//div[@class='about-types-block__switch']/div[1]"));
    private SelenideElement eurText = $(By.xpath("//div[@class='about-types-block__switch']/div[3]"));


    public void isSwitchButtonWork() {
        getUsdText().shouldHave(Condition.attribute("class", "switch-usd active"));
        getSwitchButton().click();
        getEurText().shouldHave(Condition.attribute("class", "switch-eur active"));
    }

    public void isAccountTypesBlock() {
        getAccountTypesBlock().shouldBe(Condition.visible);
    }

    public boolean isOpenAccountButtonClickable() {
        String server = System.getenv("server");
        logger.info("Server is " + server);
        switch (server) {
            case "Moscow":
                if (checkOnMoscow()){
                    return true;
                }
                break;
            case "France":
                if (checkOnFrance()){
                    return true;
                }
                break;
            default:
                if (checkOnMoscow()){
                    return true;
                }
                break;
        }
        return false;
    }

    //TODO
    /*
        Unite checkOnMoscow and checkOnFrance in 1 method
     */

    public boolean checkOnMoscow() {
        for (int i = 0; i < getOpenAccountButtons().size(); i++) {
            String attributeValue = getOpenAccountButtons().get(i).getAttribute("class");
            System.out.println("attributeValue = " + attributeValue);
            if (attributeValue.equals("auth-block__link auth-block__reg disabled-btn__register")) {
                logger.info("button #" + i + " is disable");
            } else {
                logger.error("Button have another class \n" + attributeValue + " not equals " + "auth-block__link auth-block__reg disabled-btn__register");
                return false;
            }
        }
        return true;

    }

    public boolean checkOnFrance() {
        logger.info("Check on France");
        for (int i = 0; i < getOpenAccountButtons().size(); i++) {
            String attributeValue = getOpenAccountButtons().get(i).getAttribute("class");
            System.out.println("attributeValue = " + attributeValue);
            if (attributeValue.equals("auth-block__link auth-block__reg")) {
                logger.info("button #" + i + " is enable");
            } else {
                logger.error("Button have another class \n" + attributeValue + " not equals " + "auth-block__link auth-block__reg");
                return false;
            }
        }
        return true;
    }


    public SelenideElement getAccountTypesBlock() {
        return accountTypesBlock;
    }

    public ElementsCollection getOpenAccountButtons() {
        return openAccountButtons;
    }

    public SelenideElement getSwitchButton() {
        return switchButton;
    }

    public SelenideElement getUsdText() {
        return usdText;
    }

    public SelenideElement getEurText() {
        return eurText;
    }
}
