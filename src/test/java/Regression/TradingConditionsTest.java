package Regression;

import Pages.DepositsAndWithdrawalsPage;
import Pages.TradingConditionsPage;
import Parent.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TradingConditionsTest extends BaseTest {

    TradingConditionsPage tradingConditionsPage;

    @BeforeClass
    public void install() {
        tradingConditionsPage = new TradingConditionsPage();
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
    @Test(description = "Check hover and links in nav menu")
    public void check_hover_and_links_nav_Menu() {
        tradingConditionsPage.hoverNavHeaderMenuStatus();
        logger.info("Header and links in sections correct");
    }

    /**
     * Check logo
     */
    @Test(description = "Check logo")
    public void check_Logo() {
        tradingConditionsPage.logoStatus();
        logger.info("Logo isDisplayed");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BODY TESTS//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Check table is visible or not
     */
    @Test (description = "Check table is visible or not")
    public void check_table(){
        Assert.assertTrue(tradingConditionsPage.isTableVisible());
        logger.info("Table isDisplayed");
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////FOOTER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * checking for footer block
     */
    @Test()
    public void check_footer_block() {
        Assert.assertTrue(tradingConditionsPage.footerBlockStatus());
        logger.info("Footer block isDisplayed");
    }

    /**
     * checking links in footer text
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_text() {
        tradingConditionsPage.urlsInFooterTextStatus();
        logger.info("Links are correct");
    }

    /**
     * checking links in footer nav Menu
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_nav_menu() {
        tradingConditionsPage.urlsInFooterNavMenuStatus();
        logger.info("Links are correct");
    }

    /**
     * checking images in footer
     * Should be visible and size = 5
     */
    @Test()
    public void check_images_in_footer() {
        Assert.assertEquals(tradingConditionsPage.imagesFooterStatus(), 5);
        logger.info("Images are correct");
    }

    /**
     * checking search filed
     * Should be visible
     */
    @Test()
    public void check_search_field_in_footer() {
        Assert.assertTrue(tradingConditionsPage.searchFieldStatus());
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
