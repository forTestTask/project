package Regression;

import Pages.ContactsPage;
import Pages.EarningsCalendarPage;
import Parent.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ContactsTest extends BaseTest {

    ContactsPage contactsPage;

    @BeforeClass
    public void install() {
        contactsPage = new ContactsPage();
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
        contactsPage.hoverNavHeaderMenuStatus();
        logger.info("Header and links in sections correct");
    }

    /**
     * Check logo
     */
    @Test()
    public void check_Logo() {
        contactsPage.logoStatus();
        logger.info("Logo isDisplayed");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BODY TESTS//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * check image
     * should be visible and have correct link
     */
    @Test
    public void check_image(){
        contactsPage.imageVisibleAndHaveCorrcetLink();
    }

    /**
     * Check contacts info
     */
    @Test
    public void check_contacts_data(){
        contactsPage.isTelephoneAndEmailCorrect();
    }

    /**
     * test contact form
     */
    @Test
    public void check_contact_form(){
        contactsPage.isFormVisible();
        contactsPage.checkValidation();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////FOOTER TESTS////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * checking for footer block
     */
    @Test()
    public void check_footer_block() {
        Assert.assertTrue(contactsPage.footerBlockStatus());
        logger.info("Footer block isDisplayed");
    }

    /**
     * checking links in footer text
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_text() {
        contactsPage.urlsInFooterTextStatus();
        logger.info("Links are correct");
    }

    /**
     * checking links in footer nav Menu
     * Should be visible and shoudHave correct href
     */
    @Test()
    public void check_links_in_footer_nav_menu() {
        contactsPage.urlsInFooterNavMenuStatus();
        logger.info("Links are correct");
    }

    /**
     * checking images in footer
     * Should be visible and size = 5
     */
    @Test()
    public void check_images_in_footer() {
        Assert.assertEquals(contactsPage.imagesFooterStatus(), 5);
        logger.info("Images are correct");
    }

    /**
     * checking search filed
     * Should be visible
     */
    @Test()
    public void check_search_field_in_footer() {
        Assert.assertTrue(contactsPage.searchFieldStatus());
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
