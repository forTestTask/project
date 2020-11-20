package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class DepositsAndWithdrawalsPage extends ParentPage {


    private SelenideElement tableTradingWrapper = $(By.xpath("//div[@class='table-trading__wrapper']"));



    public SelenideElement getTableTradingWrapper() {
        return tableTradingWrapper;
    }

    public boolean isTableVisible(){
        if(getTableTradingWrapper().isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
