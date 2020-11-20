package Regression;

import Pages.AccountTypesPage;
import Parent.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AccountsTypesTest extends BaseTest {

    AccountTypesPage accountTypesPage;

    @BeforeClass
    public void install() {
        accountTypesPage = new AccountTypesPage();
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
        accountTypesPage.hoverNavHeaderMenuStatus();
        logger.info("Header and links in sections correct");
    }

    /**
     * Check logo
     */
    @Test()
    public void check_Logo() {
        accountTypesPage.logoStatus();
        logger.info("Logo isDisplayed");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BODY TESTS//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Main block on page should be visible
     */
    @Test
    public void check_accountTypesBlock(){
        accountTypesPage.isAccountTypesBlock();
    }

    /**
     * If test server France:
     *  buttons Open Account should be clickable
     *  If test server Moscow:
     *   buttons Open Account should not be clickable
     */
    @Test
    public void check_openAccountButtons(){
        Assert.assertTrue(accountTypesPage.isOpenAccountButtonClickable());
        logger.info("Buttons is correct");
    }

    /**
     * Check switch_button is work
     */
    @Test
    public void check_switchButton(){
        accountTypesPage.isSwitchButtonWork();
        logger.info("Switcher work fine");
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////FOOTER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * checking for footer block
     */
    @Test()
    public void check_footer_block() {
        Assert.assertTrue(accountTypesPage.footerBlockStatus());
        logger.info("Footer block isDisplayed");
    }

    /**
     * checking links in footer text
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_text() {
        accountTypesPage.urlsInFooterTextStatus();
        logger.info("Links are correct");
    }

    /**
     * checking links in footer nav Menu
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_nav_menu() {
        accountTypesPage.urlsInFooterNavMenuStatus();
        logger.info("Links are correct");
    }

    /**
     * checking images in footer
     * Should be visible and size = 5
     */
    @Test()
    public void check_images_in_footer() {
        Assert.assertEquals(accountTypesPage.imagesFooterStatus(), 5);
        logger.info("Images are correct");
    }

    /**
     * checking search filed
     * Should be visible
     */
    @Test()
    public void check_search_field_in_footer() {
        Assert.assertTrue(accountTypesPage.searchFieldStatus());
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
