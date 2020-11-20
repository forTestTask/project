package Pages.Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Footer {

    private SelenideElement footerBlock = $(By.xpath("//footer"));
    private ElementsCollection urls_in_footer_text = $$(By.xpath("//a[@class='footer-warning__link']"));
    private ElementsCollection urls_in_footer_navMenu = $$(By.xpath("//a[contains(@class , 'footer__nav-link') and not (contains(@href, '#'))]"));
    private ElementsCollection images = $$(By.xpath("//footer//img[@class='payment-img mob-logo']"));
    public ArrayList links_in_text = new ArrayList();
    public ArrayList links_in_nav_menu = new ArrayList();
    private SelenideElement searchField = $(By.xpath("//*[@class='footer-search-form']//*[@class='search__field _valid-input']"));


    public void setLinks_in_text(){
        links_in_text.add("bla_bla");
        links_in_text.add("bla_bla");
        links_in_text.add("bla_bla");
    }





    public SelenideElement getFooterBlock() {
        return footerBlock;
    }


    public ElementsCollection getUrls_in_footer_text() {
        return urls_in_footer_text;
    }

    public ElementsCollection getUrls_in_footer_navMenu() {
        return urls_in_footer_navMenu;
    }

    public ElementsCollection getImages() {
        return images;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }
}
