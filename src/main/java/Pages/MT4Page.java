package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MT4Page extends ParentPage {

    private ElementsCollection images = $$(By.xpath("//div[@class='metatrader4']//img"));
    private SelenideElement downloadLink = $(By.xpath("//a[@class='button__main-text']"));
    private SelenideElement openOnlineTerminalLink = $(By.xpath("//a[@class='metatrader4__stock__button']"));


    public ElementsCollection getImages() {
        return images;
    }

    public SelenideElement getDownloadLink() {
        return downloadLink;
    }

    public SelenideElement getOpenOnlineTerminalLink() {
        return openOnlineTerminalLink;
    }

    public boolean isImagesDisplayed(){
        try {
            for (int i = 0; i < getImages().size() ; i++) {
                getImages().get(i).shouldBe(Condition.visible);
            }
            return true;
        }catch (AssertionError ex){
            logger.info("Error in check images MT4", ex);
            return false;
        }
    }

}
