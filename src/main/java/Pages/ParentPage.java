package Pages;

import Pages.Elements.Footer;
import Pages.Elements.Header;
import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.sleep;

public class ParentPage {

    protected Logger logger = LogManager.getLogger();
    public ArrayList <String>siteLinks;

    Footer footer;
    Header header;

    public ParentPage() {
        footer = new Footer();
        header = new Header();
        siteLinks = new ArrayList();
    }

    public void setLinks_in_Menu() {
        siteLinks.add("bla_bla");
    }

    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////HEADER SECTION//////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////

    public void hoverNavHeaderMenuStatus() {
        int count = 0;
        setLinks_in_Menu();
        header.setupLinkList();
        for (int i = 0; i < header.getNavMenuHeaderList().size(); i++) {
            sleep(1000);
            header.getNavMenuHeaderList().get(i).hover();
            header.getSub_navMenuHeaderList().get(i).shouldBe(Condition.visible);
            for (int j = 0; j < header.getAllLinks().get(i).size(); j++) {
                header.getAllLinks().get(i).get(j).shouldBe(Condition.visible).shouldHave(Condition.attribute("href", siteLinks.get(count++)));
                logger.info("Link #" + header.getAllLinks().get(i).get(j).getAttribute("href") + " checked");
            }
        }
    }

    public boolean logoStatus() {
        return header.getLogo_img().isDisplayed();
    }


    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////FOOTER SECTION//////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////
    public boolean footerBlockStatus() {
        return footer.getFooterBlock().isDisplayed();
    }

    public void urlsInFooterTextStatus() {
        footer.setLinks_in_text();
        for (int i = 0; i < footer.getUrls_in_footer_text().size(); i++) {
            footer.getUrls_in_footer_text().get(i).shouldBe(Condition.visible).shouldHave(Condition.attribute("href", footer.links_in_text.get(i).toString()));
            logger.info("URL " + footer.getUrls_in_footer_text().get(i) + " correct");
        }
    }


    public void urlsInFooterNavMenuStatus() {
        setLinks_in_Menu();
        for (int i = 0; i < footer.getUrls_in_footer_navMenu().size(); i++) {
            footer.getUrls_in_footer_navMenu().get(i).shouldBe(Condition.visible).shouldHave(Condition.attribute("href", siteLinks.get(i)));
            logger.info("URL " + footer.getUrls_in_footer_navMenu().get(i) + " correct");
        }
    }

    public int imagesFooterStatus() {

        for (int i = 0; i < footer.getImages().size(); i++) {
            footer.getImages().get(i).shouldBe(Condition.visible);
        }
        logger.info("Size = " + footer.getImages().size());
        return footer.getImages().size();
    }

    public boolean searchFieldStatus() {
        return footer.getSearchField().isDisplayed();

    }


}
