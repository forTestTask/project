package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TradingHoursPage extends ParentPage {


    public String attributeValue;
    private SelenideElement tradingHoursTable = $(By.xpath("//div[@class='table-trading__wrapper']"));
    private SelenideElement tableSections = $(By.id("trading-category-select"));
    private ElementsCollection dataTable = $$(By.xpath("//div[@class='table-wrapper']/*"));


    public boolean isTableVisible() {
        if (getTradingHoursTable().isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }


    public void doesTheTableWork() {
        for (int i = 0; i < 9 ; i++) {   //9 - count select elements
            getDataTable().get(i).shouldHave(Condition.cssClass("uk-active"));
            tableSections.selectOption(i+1);
            logger.info("Table #" + i + " visible");
        }
    }


    public SelenideElement getTradingHoursTable() {
        return tradingHoursTable;
    }

    public ElementsCollection getDataTable() {
        return dataTable;
    }
}
