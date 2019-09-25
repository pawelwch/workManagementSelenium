package TestCaseBuilders;

import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import Pages.RegisterFactory.RegisterWebElements;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static JsonData.JsonParser_Notification.*;
import static TestMethods.BaseMethods.*;
import static Pages.RegisterFactory.RegisterWebElements.*;
import static TestMethods.ConfigureMethods.sleep;
import static TestMethods.ConfigureMethods.waitForIt;
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
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_height_weight(generateRandomNumber(3),generateRandomNumber(2));
        registerPage.moreAboutYou_skillSet(true);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages(null, null);
        registerPage.moreAboutYou_biography();
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",AVATAR);
        registerPage.uploadIdCard(AVATAR,PDF);
        registerPage.uploadCertificates(AVATAR, PDF);
        registerPage.idNumber(generateRandomNumber(5));
        registerPage.continueDocumetsUploadButton();
    }

    protected void signUp_WithNoPhoneNumber(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone("");
        baseMethods.clickSomewhere(body);
        checkNotify(errorPhoneIsRequired, error_PhoneIsRequired);

    }

    protected void signUp_WithTooManyPhoneDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone()+1);
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

    protected void signUp_WithTooLongPassword() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        BaseMethods.submitButton(submitFirstView);
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(15);
        registerPage.setPinView(firstPin,firstPin);
        boolean actualValue = passwordConfirmButton.isEnabled();
        //dokończyć assercje
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
        registerPage.setUpAccount_Birth_date("06 - 02 - 1993");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        boolean buttonIsActive = registerPage.confirmSetupAccount.isEnabled();
        checkNotify(errorSetupYourAccount, error_setupYourAccount);
        if(buttonIsActive)
            System.out.println("Pass");
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
        registerPage.setUpAccount_Birth_date("08 10 1993");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        boolean buttonIsActive = registerPage.confirmSetupAccount.isEnabled();
        checkNotify(errorSetupYourAccount, error_setupYourAccount);
        if(buttonIsActive)
            System.out.println("Pass");
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
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        checkNotify(errorSetupYourAccount, error_setupYourAccount);
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
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        //registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
        boolean buttonIsActive = registerPage.confirmSetupAccount.isEnabled();
        checkNotify(errorSetupYourAccount, error_setupYourAccount);
        if(buttonIsActive)
            System.out.println("Pass");
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
        registerPage.setUpAccount_gender(male);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        registerPage.setUpAccount_name_email_address(name,email,"");
        registerPage.setUpAccount_Birth_date("20 - 05 - 1993");
        //registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
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
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(false,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }



    protected void signUp_WithNoProfilePicture() {
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
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("skip", "");
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

    protected void signUp_WithJpgProfilePicture(){
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
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_height_weight( "180", "80");
        registerPage.moreAboutYou_skillSet(false);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages();
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",  AVATAR);
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

        protected void signUp_WithPngProfilePicture() {
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
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_height_weight( "180", "80");
        registerPage.moreAboutYou_skillSet(false);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages();
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",  PNG);
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
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
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_height_weight("180", "80");
        registerPage.moreAboutYou_skillSet(false);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages();
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",  AVATAR);
        registerPage.uploadIdCard(IDCARD, IDCARD1);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem

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
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date("20 - 05 - 2013");
        registerPage.setUpAccount_countrySelector("Pola");
        registerPage.setUpAccount_citySelector("Wroc");
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_height_weight( "180", "80");
        registerPage.moreAboutYou_skillSet(false);
        registerPage.moreAboutYou_licensesAndCertificates(false);
        //registerPage.moreAboutYou_education();
        registerPage.moreAboutYou_languages();
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser", AVATAR);
        registerPage.uploadCertificates(CERT, CERT1);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem

    }
}
