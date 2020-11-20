package Pages.Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private SelenideElement logo_img = $(By.xpath("//a[@class='header__logo']/img"));
    private ElementsCollection navMenuHeaderList = $$(By.xpath("//ul[@class='header__nav-list']/li"));
    private ElementsCollection sub_navMenuHeaderList = $$(By.xpath("//ul[@class='header__subnav-list']"));
    private ElementsCollection linksInPlatformBlock = $$(By.xpath("//li[@id='menu-item-16']//li/a"));
    private ElementsCollection linksInForTradersBlock = $$(By.xpath("//li[@id='menu-item-240']//li/a"));
    private ElementsCollection linksInEducationBlock = $$(By.xpath("//li[@id='menu-item-18']//li/a"));
    private ElementsCollection linksInAboutUsBlock = $$(By.xpath("//li[@id='menu-item-19']//li/a"));
    private ElementsCollection linksInDocumentationBlock = $$(By.xpath("//li[@id='menu-item-20']//li/a"));
    private ArrayList<ElementsCollection> allLinks = new ArrayList<>();


    public void setupLinkList(){
        allLinks.add(linksInPlatformBlock);
        allLinks.add(linksInForTradersBlock);
        allLinks.add(linksInEducationBlock);
        allLinks.add(linksInAboutUsBlock);
        allLinks.add(linksInDocumentationBlock);
    }

    public SelenideElement getLogo_img() {
        return logo_img;
    }


    public ElementsCollection getNavMenuHeaderList() {
        return navMenuHeaderList;
    }

    public ElementsCollection getSub_navMenuHeaderList() {
        return sub_navMenuHeaderList;
    }


    public ArrayList<ElementsCollection> getAllLinks() {
        return allLinks;
    }
}
