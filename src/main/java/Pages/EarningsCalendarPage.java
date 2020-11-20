package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EarningsCalendarPage extends ParentPage {


    private SelenideElement sectionTable = $(By.xpath("//section[@class='table-trading']"));



    public boolean isTableVisible(){
        if(getSectionTable().isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public SelenideElement getSectionTable() {
        return sectionTable;
    }
}
