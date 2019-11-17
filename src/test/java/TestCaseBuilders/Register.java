package TestCaseBuilders;

import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.HomePageFactory.HomePage;
import Pages.HomePageFactory.HomeWebElements;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import Pages.RegisterFactory.RegisterWebElements;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static JsonData.JsonParser_Notification.*;
import static TestMethods.BaseMethods.*;
import static Pages.RegisterFactory.RegisterWebElements.*;
import static TestMethods.ConfigureMethods.*;
import static TestMethods.StaticsData.*;
import static org.testng.Assert.*;

/**Klasa która przechowuje kroki TestCasów */
public class Register {

    public WebDriver driver ;
    protected HomePage homePage ;
    protected RegisterPage registerPage ;
    protected LoginPage loginPage ;
    protected BaseMethods baseMethods ;
    protected ConfigureMethods configureMethods ;
    protected JsonParser jsonParser ;
    protected JsonParser_Notification jsonParser_notification;
    protected REST_Methods rest_methods ;


    /**@param accountType - ustala jakie konto ma byc rejestrowane. Do wyboru: labourer, contractor, employer
     * @param  accountType względu na sztywny xpath trzeba wybrać czy rejestrujemy się jako labourer. Jesli tak to tak wpisujemy tak, jeśli nie, to contractor lub employer */
    protected void register(WebElement accountType) {
        String pinCode = generateRandomNumber(6);
        System.out.println(pinCode);
        String phone = generatePhone();
        System.out.println(phone);

        homePage.GoToSignUp();
        //registerPage.selectCountry();
        registerPage.registerCompletePhone(phone);
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView(pinCode, pinCode);
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(accountType);
        registerPage.setUpAccount_name_email_address(generateRandomString(5),generateRandomEmail(),generateRandomString(20));
        registerPage.setUpAccount_gender(male);
        registerPage.setUpAccount_Birth_date("08 10 1993");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);

        registerPage.moreAboutYou_height_weight(generateRandomNumber(3),generateRandomNumber(2));
        registerPage.moreAboutYou_skillSet(true);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages(null, null);
        registerPage.moreAboutYou_biography();

//        registerPage.photoUpload("browser",AVATAR);
//        registerPage.uploadIdCard(AVATAR,PDF);
//        registerPage.uploadCertificates(AVATAR, PDF);
        registerPage.idNumber(generateRandomNumber(5));
        registerPage.continueDocumetsUploadButton();
    }

    protected void signUp_WithNoPhoneNumber(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(" ");
        baseMethods.clickSomewhere(body);
        checkNotify(errorPhoneIsRequired, error_PhoneIsRequired);

    }

    protected void signUp_WithTooManyPhoneDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone()+"123");
        checkNotify(errorPhoneInput, error_PhoneInput);
    }

    protected void signUp_WithTooLittlePhoneDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        String number = 8 + generateRandomNumber(7);
        registerPage.registerCompletePhone(number);
        baseMethods.clickSomewhere(body);
        checkNotify(errorValidPhoneNumber, error_ValidPhoneNumber);
    }

    protected void signUp_WithLettersInPhoneInput() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generateRandomString(9));
        baseMethods.clickSomewhere(body);
        checkNotify(errorValidPhoneNumber, error_ValidPhoneNumber);
    }

    protected void signUp_WithSuperLongPassword() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(25);
        registerPage.setPinView(firstPin,firstPin);
        boolean actualValue = passwordConfirmButton.isEnabled();
    }

    protected void signUp_WithTooShortPassword() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(5);
        registerPage.setPinView(firstPin,firstPin);
        baseMethods.clickSomewhere(body);
        checkNotify(errorPinCode, error_PinCode);
    }

    protected void signUp_PasswordsAreNotTheSame() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        String firstPassword = generateRandomNumber(5);
        String secondPassword = generateRandomNumber(5);
        registerPage.setPinView(firstPassword, secondPassword);
        baseMethods.clickSomewhere(body);
        checkNotify(errorPinCodeDoesntMatch, error_PinCodeDoesntMatch);
    }


    protected void signUp_WithOnlyFirstPasswordFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView(firstPin,"");
        checkNotify(errorPinCode, error_PinCode);
        /*
        SPRAWDZIC CZY BUTTON ISDISPLAYED
        boolean buttonIsVisible = passwordConfirmButton.isDisplayed();
        sleep(1000);
        assertFalse(buttonIsVisible);
         */

    }

    protected void signUp_WithOnlySecondPasswordFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView("",firstPin);
        checkNotify(errorPinCodeDoesntMatch, error_PinCodeDoesntMatch);
    }

    protected void signUp_WithEmptyPasswordFields() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("","");
        // dopisac assercje na brak buttona;
    }

    protected void signUp_WithoutGender(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("Abc123456","Abc123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        int buttonIsActive = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button/span[1]")).size();
        checkNotify(errorSetupYourAccount, error_setupYourAccount);
        assertEquals(buttonIsActive, 0);
    }

    protected void signUp_WithoutFullName() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("Abc123456","Abc123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(male);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address("",email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        int buttonIsActive = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button/span[1]")).size();
        checkNotify(errorFullName, error_FullName);
        assertEquals(buttonIsActive, 0);
    }

    protected void signUp_WithoutDateOfBirth() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(male);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        int buttonIsActive = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button/span[1]")).size();
        checkNotify(errorDateOfBirth, error_DateOfBirth);
        assertEquals(buttonIsActive, 0);
    }

    protected void signUp_WithoutCity() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(male);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        int buttonIsActive = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button/span[1]")).size();
        checkNotify(errorCity, error_City);
        assertEquals(buttonIsActive, 0);
    }

    protected void signUp_WithoutAddress() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(female);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        registerPage.setUpAccount_name_email_address(name,email,"");
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        int buttonIsActive = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button/span[1]")).size();
        checkNotify(errorAddress, error_Address);
        assertEquals(buttonIsActive, 0);

    }

    protected void signUp_WithoutPolicies() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(false,true);
        int buttonIsActive = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button/span[1]")).size();
        //checkNotify(errorAddress, error_Address);
        assertEquals(buttonIsActive, 0);

    }


    protected void signUp_WithoutMoreAboutYourself(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.clickAtSkipViewButton(skipButton);

    }

    protected void signUp_withoutHeightAndWeight(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.moreAboutYou_skillSet(false, excelSkill, javaScriptSkill, msOfficeSkill);
        registerPage.moreAboutYou_licensesAndCertificates(true);
        registerPage.moreAboutYou_education(masterEducation);
        registerPage.moreAboutYou_languages(polishLanguage, englishLanguage);
        registerPage.moreAboutYou_biography();
    }

    protected void signUp_withoutSkillsets(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.moreAboutYou_height_weight("200", "90");
        registerPage.moreAboutYou_licensesAndCertificates(true);
        registerPage.moreAboutYou_education(masterEducation);
        registerPage.moreAboutYou_languages(polishLanguage, englishLanguage);
        registerPage.moreAboutYou_biography();
    }

    protected void signUp_withoutLicensesAndCertificates(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.moreAboutYou_height_weight("200", "90");
        registerPage.moreAboutYou_skillSet(false, excelSkill, javaScriptSkill, msOfficeSkill);
        registerPage.moreAboutYou_education(masterEducation);
        registerPage.moreAboutYou_languages(polishLanguage, englishLanguage);
        registerPage.moreAboutYou_biography();
    }

    protected void signUp_withoutEducation(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.moreAboutYou_height_weight("200", "90");
        registerPage.moreAboutYou_licensesAndCertificates(true);
        registerPage.moreAboutYou_skillSet(false, excelSkill, javaScriptSkill, msOfficeSkill);
        registerPage.moreAboutYou_languages(polishLanguage, englishLanguage);
        registerPage.moreAboutYou_biography();
    }

    protected void signUp_withoutLanguages(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.moreAboutYou_height_weight("200", "90");
        registerPage.moreAboutYou_licensesAndCertificates(true);
        registerPage.moreAboutYou_skillSet(false, excelSkill, javaScriptSkill, msOfficeSkill);
        registerPage.moreAboutYou_education(masterEducation);
        registerPage.moreAboutYou_biography();
    }

    protected void signUp_withoutBiography(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.moreAboutYou_height_weight("200", "90");
        registerPage.moreAboutYou_licensesAndCertificates(true);
        registerPage.moreAboutYou_skillSet(false, excelSkill, javaScriptSkill, msOfficeSkill);
        registerPage.moreAboutYou_education(masterEducation);
        registerPage.moreAboutYou_languages(polishLanguage, englishLanguage);
    }

    protected void signUp_WithoutProfilePicture() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(female);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        registerPage.clickAtSkipViewButton(skipButton);
        registerPage.photoUpload("skip", "");

    }

    protected void signUp_WithJpgProfilePicture() throws Exception{
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(female);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        sleep(1000);
        submitButton(confirmSetupAccount);
        sleep(1000);
        registerPage.clickAtSkipViewButton(skipButton);
        registerPage.uploadProfilePicture(JPG_PROFILE_PICTURE);
        sleep(2000);
        checkIfPictureIsPresent(currentProfilePicture);
    }

        protected void signUp_WithPngProfilePicture() throws Exception {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(other);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        sleep(1000);
        registerPage.clickAtSkipViewButton(skipButton);
        registerPage.uploadProfilePicture(PNG_PROFILE_PICTURE);
        sleep(2000);
        checkIfPictureIsPresent(currentProfilePicture);
    }

    protected void signUp_DocumentsUploadedOnlyWithIdCard() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        registerPage.setUpAccount_gender(male);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        sleep(1000);
        BaseMethods.submitButton(confirmSetupAccount);
        sleep(1000);
        registerPage.clickAtSkipViewButton(skipButton);
        registerPage.clickAtSkipViewButton(skipButton);
        registerPage.uploadIdCard(IDCARD, IDCARD1);
    }

    protected void signUp_DocumentsUploadedOnlyWithCertificates() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        BaseMethods.submitButton(passwordConfirmButton);
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        scroolToTheSomePoint(marketing);
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("1993 - 10 - 08");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);

        registerPage.moreAboutYou_height_weight( "180", "80");
        registerPage.moreAboutYou_skillSet(false);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages();

        //registerPage.photoUpload("browser", AVATAR);
        //registerPage.uploadCertificates(CERT, CERT1);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem

    }
}
