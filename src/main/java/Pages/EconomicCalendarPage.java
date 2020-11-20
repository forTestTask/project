package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EconomicCalendarPage extends ParentPage {


    private SelenideElement economicCalendarTable = $(By.xpath("//div[@id='ec-date-range-close']"));



    public boolean isTableVisible(){
        if(getEconomicCalendarTable().isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public SelenideElement getEconomicCalendarTable() {
        return economicCalendarTable;
    }
}
