package Regression;

import Pages.EconomicCalendarPage;
import Pages.TradingHoursPage;
import Parent.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TradingHoursTest extends BaseTest {

    TradingHoursPage tradingHoursPage;

    @BeforeClass
    public void install() {
        tradingHoursPage = new TradingHoursPage();
        open("bla_bla");
        logger.info("///////////////////START LOG///////////////////");
        logger.info("Open = " + "bla_bla");
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////HEADER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Check hover and links in nav menu
     */
    @Test()
    public void check_hover_and_links_nav_Menu() {
        tradingHoursPage.hoverNavHeaderMenuStatus();
        logger.info("Header and links in sections correct");
    }

    /**
     * Check logo
     */
    @Test()
    public void check_Logo() {
        tradingHoursPage.logoStatus();
        logger.info("Logo isDisplayed");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BODY TESTS//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Check table is visible or not
     */
    @Test
    public void check_table(){
        Assert.assertTrue(tradingHoursPage.isTableVisible());
        logger.info("Table isDisplayed");
    }

    /**
     * Check does table work (switchers)
     */
    @Test
    public void check_table_work(){
        tradingHoursPage.doesTheTableWork();
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////FOOTER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * checking for footer block
     */
    @Test()
    public void check_footer_block() {
        Assert.assertTrue(tradingHoursPage.footerBlockStatus());
        logger.info("Footer block isDisplayed");
    }

    /**
     * checking links in footer text
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_text() {
        tradingHoursPage.urlsInFooterTextStatus();
        logger.info("Links are correct");
    }

    /**
     * checking links in footer nav Menu
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_nav_menu() {
        tradingHoursPage.urlsInFooterNavMenuStatus();
        logger.info("Links are correct");
    }

    /**
     * checking images in footer
     * Should be visible and size = 5
     */
    @Test()
    public void check_images_in_footer() {
        Assert.assertEquals(tradingHoursPage.imagesFooterStatus(), 5);
        logger.info("Images are correct");
    }

    /**
     * checking search filed
     * Should be visible
     */
    @Test()
    public void check_search_field_in_footer() {
        Assert.assertTrue(tradingHoursPage.searchFieldStatus());
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
