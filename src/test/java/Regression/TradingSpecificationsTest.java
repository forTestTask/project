package Regression;

import Pages.TradingConditionsPage;
import Pages.TradingSpecificationPage;
import Parent.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TradingSpecificationsTest extends BaseTest {

    TradingSpecificationPage tradingSpecificationPage;

    @BeforeClass
    public void install() {
        tradingSpecificationPage = new TradingSpecificationPage();
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
        tradingSpecificationPage.hoverNavHeaderMenuStatus();
        logger.info("Header and links in sections correct");
    }

    /**
     * Check logo
     */
    @Test()
    public void check_Logo() {
        tradingSpecificationPage.logoStatus();
        logger.info("Logo isDisplayed");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BODY TESTS//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Check table is Visible or not
     */
    @Test
    public void check_table(){
        Assert.assertTrue(tradingSpecificationPage.isTableVisible());
        logger.info("Table isDisplayed");
    }


    /**
     * Check does table work (switchers)
     */
    @Test
    public void check_work_table(){
        tradingSpecificationPage.doesTheTableWork();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////FOOTER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * checking for footer block
     */
    @Test()
    public void check_footer_block() {
        Assert.assertTrue(tradingSpecificationPage.footerBlockStatus());
        logger.info("Footer block isDisplayed");
    }

    /**
     * checking links in footer text
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_text() {
        tradingSpecificationPage.urlsInFooterTextStatus();
        logger.info("Links are correct");
    }

    /**
     * checking links in footer nav Menu
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_nav_menu() {
        tradingSpecificationPage.urlsInFooterNavMenuStatus();
        logger.info("Links are correct");
    }

    /**
     * checking images in footer
     * Should be visible and size = 5
     */
    @Test()
    public void check_images_in_footer() {
        Assert.assertEquals(tradingSpecificationPage.imagesFooterStatus(), 5);
        logger.info("Images are correct");
    }

    /**
     * checking search filed
     * Should be visible
     */
    @Test()
    public void check_search_field_in_footer() {
        Assert.assertTrue(tradingSpecificationPage.searchFieldStatus());
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
