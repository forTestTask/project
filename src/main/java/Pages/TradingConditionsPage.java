package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TradingConditionsPage extends ParentPage {


    private SelenideElement tradingConditionTable = $(By.xpath("//div[@class='trading-conditions__container']"));





    public boolean isTableVisible(){
        if(getTradingConditionTable().isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public SelenideElement getTradingConditionTable() {
        return tradingConditionTable;
    }
}
