package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AuthenticationPage {

    private ElementsCollection listOfSelect = $$(By.xpath("//div[@class='custom-select__placeholder']")); // 0 - Gender; 1 - Citizenship; 2- Country of Residense; 3 -I am a tax of resident
    private SelenideElement firstItemInList = $(By.xpath("//div[contains(@class, 'list-show')]//li[1]"));
    private SelenideElement dateOfBirth = $(By.xpath("//input[@name='Date of Birth']"));
    private SelenideElement placeOfBirth = $(By.xpath("//input[@name='Place of Birth']"));
    private SelenideElement passportNumber = $(By.xpath("//input[@name='Passport Number']"));
    private SelenideElement nationalID = $(By.xpath("//input[@name='National ID']"));
    private SelenideElement addressLine1 = $(By.xpath("//input[@name='Address Line 1']"));
    private SelenideElement addressLine2 = $(By.xpath("//input[@name='Address Line 2']"));
    private SelenideElement city = $(By.xpath("//input[@name='City']"));
    private SelenideElement postalCode = $(By.xpath("//input[@name='Postal Code']"));
    private SelenideElement taxIdentificationNumber = $(By.xpath("//input[@name='Tax Identification Number']"));
    private SelenideElement not_a_PEP_Checkbox = $(By.xpath("//input[@id='myCheckBox']"));
    private SelenideElement i_am_not_a_US_reportable_person_Checkbox = $(By.xpath("//input[@id='myCheckBox2']"));
    private SelenideElement continueButton = $(By.xpath("//button[@class='btn register-send-step-three']"));
    private SelenideElement tradingForexCheckBox = $(By.xpath("//input[@name='Trading Forex']"));
    private SelenideElement speculationCheckBox = $(By.xpath("//input[@name='Speculation']"));
    private SelenideElement employedRadioButton = $(By.xpath("//input[@value='Employed (score-1)']"));
    private SelenideElement companyNameField = $(By.xpath("//input[@name='Company Name']"));
    private SelenideElement savingsRadioButton = $(By.xpath("//input[@value='Savings (score-1)']"));
    private ElementsCollection priceRange_RadioButtons = $$(By.xpath("//input[@value='€0 - €20,000 (score-0)']"));
    private ElementsCollection bankAccount = $$(By.xpath("//input[@value='Bank Account (score-1)']"));
    private SelenideElement saveAndContinueButton = $(By.xpath("//button[@class='btn register-send-step-four']"));
    private SelenideElement saveAndContinueFourButton = $(By.xpath("//button[@class='btn register-send-step-five_one']"));
    private SelenideElement saveAndContinueFiveButton = $(By.xpath("//button[@class='btn register-send-step-five_two']"));
    private SelenideElement saveAndContinueSixButton = $(By.xpath("//button[@class='btn register-send-step-five_three']"));
    private SelenideElement secondaryDegreeButton = $(By.xpath("//input[@value='Secondary Degree (High School)']"));
    private SelenideElement workedForButton = $(By.xpath("//input[@value='Worked for at least 3 years in such a role']"));
    private ElementsCollection yesButton = $$(By.xpath("//input[@value='Yes']"));
    private ElementsCollection lessThanButton = $$(By.xpath("//input[@value='Less than 2']"));
    private SelenideElement makeMyOwnButton = $(By.xpath("//input[@value='I make my own trading decisions']"));
    private SelenideElement make = $(By.xpath("//input[@value='Make']"));
    private SelenideElement E1000Button = $(By.xpath("//input[@value='€1,000']"));
    private SelenideElement stopLossButton = $(By.xpath("//input[@value='Stop Loss']"));
    private SelenideElement E700Button = $(By.xpath("//input[@value='€700']"));
    private SelenideElement quizResultPopUP = $(By.xpath("//div[@class='popup']/p"));
    private SelenideElement qiuzAgreeButton = $(By.xpath("//div[@class='popup']/div[@class='button button_quize']"));
    private SelenideElement infoSubmittedText = $(By.xpath("//div[@class='main-aut__block-four main-aut__wrapper main-aut__wrapper-fourth thank-you-page']//h2"));
    private SelenideElement depositeButton = $(By.xpath("//div[@class='main-aut__block-four main-aut__wrapper main-aut__wrapper-fourth thank-you-page']//a[@href='/my-account/']"));


    public void pickLessThanButton(){
        lessThanButton.get(0).click();
    }

    public void pickLessThanSecondButton(){
        lessThanButton.get(1).click();
    }

    public void pickYesFirstButton(){
        yesButton.get(0).click();
    }
    public void pickYesSecondButton(){
        yesButton.get(1).click();
    }
    public void pickYesThirdButton(){
        yesButton.get(2).click();
    }
    public void pickYesFoursButton(){
        yesButton.get(3).click();
    }

    public void pickGender(){
            listOfSelect.get(0).click();
            getFirstItemInList().click();
    }

    public void pickCitizenShip(){
        listOfSelect.get(1).click();
        getFirstItemInList().click();
    }

    public void pickCountryOfResindence(){
        listOfSelect.get(2).click();
        getFirstItemInList().click();
    }
    public void pickTaxOfResindent(){
        listOfSelect.get(3).click();
        getFirstItemInList().click();
    }

    public void pickOccupation(){
        listOfSelect.get(4).click();
        getFirstItemInList().click();
    }

    public void pickFirstPriceRangeButton(){
        priceRange_RadioButtons.get(0).click();
    }
    public void pickSecondPriceRangeButton(){
        priceRange_RadioButtons.get(1).click();
    }
    public void pickThirdPriceRangeButton(){
        priceRange_RadioButtons.get(2).click();
    }

    public void pickFirstBankAccountButton(){
        bankAccount.get(0).click();
    }

    public void pickSecondBankAccountButton(){
        bankAccount.get(1).click();
    }




    public SelenideElement getDateOfBirth() {
        return dateOfBirth;
    }

    public SelenideElement getFirstItemInList() {
        return firstItemInList;
    }

    public SelenideElement getPlaceOfBirth() {
        return placeOfBirth;
    }

    public SelenideElement getPassportNumber() {
        return passportNumber;
    }

    public SelenideElement getNationalID() {
        return nationalID;
    }

    public SelenideElement getAddressLine1() {
        return addressLine1;
    }

    public SelenideElement getAddressLine2() {
        return addressLine2;
    }

    public SelenideElement getCity() {
        return city;
    }

    public SelenideElement getPostalCode() {
        return postalCode;
    }

    public SelenideElement getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public SelenideElement getNot_a_PEP_Checkbox() {
        return not_a_PEP_Checkbox;
    }

    public SelenideElement getContinueButton() {
        return continueButton;
    }

    public SelenideElement getTradingForexCheckBox() {
        return tradingForexCheckBox;
    }

    public SelenideElement getSpeculationCheckBox() {
        return speculationCheckBox;
    }

    public SelenideElement getEmployedRadioButton() {
        return employedRadioButton;
    }

    public SelenideElement getCompanyNameField() {
        return companyNameField;
    }

    public SelenideElement getSavingsRadioButton() {
        return savingsRadioButton;
    }


    public SelenideElement getSaveAndContinueButton() {
        return saveAndContinueButton;
    }

    public SelenideElement getSecondaryDegreeButton() {
        return secondaryDegreeButton;
    }

    public SelenideElement getWorkedForButton() {
        return workedForButton;
    }

    public SelenideElement getSaveAndContinueFourButton() {
        return saveAndContinueFourButton;
    }

    public SelenideElement getMakeMyOwnButton() {
        return makeMyOwnButton;
    }

    public SelenideElement getSaveAndContinueFiveButton() {
        return saveAndContinueFiveButton;
    }

    public SelenideElement getMake() {
        return make;
    }

    public SelenideElement getE1000Button() {
        return E1000Button;
    }

    public SelenideElement getStopLossButton() {
        return stopLossButton;
    }

    public SelenideElement getE700Button() {
        return E700Button;
    }

    public SelenideElement getSaveAndContinueSixButton() {
        return saveAndContinueSixButton;
    }

    public SelenideElement getQuizResultPopUP() {
        return quizResultPopUP;
    }

    public SelenideElement getQiuzAgreeButton() {
        return qiuzAgreeButton;
    }

    public SelenideElement getInfoSubmittedText() {
        return infoSubmittedText;
    }

    public MyAccount getDepositeButton() {
        depositeButton.waitUntil(Condition.visible,5000).click();
        return page(MyAccount.class);
    }

    public SelenideElement getI_am_not_a_US_reportable_person_Checkbox() {
        return i_am_not_a_US_reportable_person_Checkbox;
    }
}
