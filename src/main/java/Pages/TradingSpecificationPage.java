package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TradingSpecificationPage extends ParentPage {


    private SelenideElement allTablesWrapper = $(By.xpath("//div[@class='all-tables-wrapper']"));
    private ElementsCollection switcherButtons = $$(By.xpath("//div[@id='instruments']/div"));
    private ArrayList buttonsName = new ArrayList(Arrays.asList("Forex", "Commodities", "Indices", "Stocks"));







    public boolean isTableVisible(){
        if(getAllTablesWrapper().isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public void doesTheTableWork(){
        //need click on body after header test, because the menu overlaps the buttons
        $(By.xpath("//body")).click();
        getSwitcherButtons().shouldHaveSize(buttonsName.size());

        for (int i = 0; i < getSwitcherButtons().size(); i++) {
            getSwitcherButtons().get(i)
                    .shouldHave(Condition.attribute("class", "select__tab select__tab-active"))
                    .shouldHave(Condition.text(buttonsName.get(i).toString()));
            logger.info("Button " + buttonsName.get(i).toString() + " isWork and active");
            if(i!=3) {
                getSwitcherButtons().get(i + 1).click();
            }
        }
    }


    public SelenideElement getAllTablesWrapper() {
        return allTablesWrapper;
    }

    public ElementsCollection getSwitcherButtons() {
        return switcherButtons;
    }
}
