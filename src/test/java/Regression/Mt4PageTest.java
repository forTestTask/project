package Regression;

import Pages.MT4Page;
import Parent.BaseTest;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Mt4PageTest extends BaseTest {

    MT4Page mt4Page;

    @BeforeClass
    public void install() {
        mt4Page = new MT4Page();
        open("bla_bla");
        logger.info("///////////////////START LOG///////////////////");
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////HEADER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Check hover and links in nav menu
     */
    @Test()
    public void check_hover_and_links_nav_Menu() {
        mt4Page.hoverNavHeaderMenuStatus();
        logger.info("Header and links in sections correct");
    }

    /**
     * Check logo
     */
    @Test()
    public void check_Logo() {
        mt4Page.logoStatus();
        logger.info("Logo isDisplayed");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BODY TESTS//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Check images is Visible and images count should be 2
     */
    @Test
    public void check_images_MT4(){
       Assert.assertTrue(mt4Page.isImagesDisplayed());
        logger.info("Images is Displayed");
        mt4Page.getImages().shouldHaveSize(2);
        logger.info("Number of pictures is correct");
    }

    /**
     * Check download button
     * should be visible and correct url
     */
    @Test
    public void check_download_mt4_button(){
        mt4Page.getDownloadLink()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("href", "bla_bla"));
        logger.info("Download link is visile and have correct url");
    }

    /**
     * Check  button
     * should be visible and correct url
     */
    @Test
    public void check_online_version_button(){
        mt4Page.getOpenOnlineTerminalLink()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("href", "bla_bla"));
        logger.info("Download link is visile and have correct url");
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////FOOTER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * checking for footer block
     */
    @Test()
    public void check_footer_block() {
        Assert.assertTrue(mt4Page.footerBlockStatus());
        logger.info("Footer block isDisplayed");
    }

    /**
     * checking links in footer text
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_text() {
        mt4Page.urlsInFooterTextStatus();
        logger.info("Links are correct");
    }

    /**
     * checking links in footer nav Menu
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_nav_menu() {
        mt4Page.urlsInFooterNavMenuStatus();
        logger.info("Links are correct");
    }

    /**
     * checking images in footer
     * Should be visible and size = 5
     */
    @Test()
    public void check_images_in_footer() {
        Assert.assertEquals(mt4Page.imagesFooterStatus(), 5);
        logger.info("Images are correct");
    }

    /**
     * checking search filed
     * Should be visible
     */
    @Test()
    public void check_search_field_in_footer() {
        Assert.assertTrue(mt4Page.searchFieldStatus());
        logger.info("Search field is Displayed");
    }


    /**
     * Clear method that clear all temp arrays or lists after complete test method
     */
    @AfterMethod()
    public void clear(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.info(result.getThrowable());
        }
        logger.info("///////////////////END LOG///////////////////");
        logger.info("\n");
    }


}
