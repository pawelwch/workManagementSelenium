package TestCaseBuilders;

import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static JsonData.JsonParser_Notification.error_PhoneInput;
import static TestMethods.BaseMethods.*;
import static Pages.RegisterFactory.RegisterWebElements.*;
import static TestMethods.ConfigureMethods.waitForIt;
import static TestMethods.StaticsData.*;

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
     * @param city_accountType ze względu na sztywny xpath trzeba wybrać czy rejestrujemy się jako labourer. Jesli tak to tak wpisujemy tak, jeśli nie, to contractor lub employer*/
    protected void register(WebElement accountType, WebElement city_accountType) {
        String pinCode = generateRandomNumber(6);
        System.out.println(pinCode);
        String phone = generatePhone();
        System.out.println(phone);

        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(phone);
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView(pinCode, pinCode);
        registerPage.confirmPin();
        registerPage.accountTypeSelector(accountType);
        registerPage.setUpAccount_name_email_address(generateRandomString(5),generateRandomEmail(),generateRandomString(20));
        registerPage.setUpAccount_Birth_date(getYearSelector("1999"),getMonthSelector("March"),day20);
        registerPage.setUpAccount_citySelector(city_accountType);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_basicData(male,generateRandomNumber(3),generateRandomNumber(2),zero_minus);
        registerPage.moreAboutYou_skillSet(true, skillExcell, null, null);
        registerPage.moreAboutYou_licensesAndCertificates(false,licenseTwo, null, null);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageHindi, languageEnglish, languageGerman,null, null);
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",AVATAR);
        registerPage.uploadIdCard(AVATAR,PDF);
        registerPage.uploadCertificates(AVATAR, PDF);
        registerPage.idNumber(generateRandomNumber(5));
        registerPage.continueDocumetsUploadButton();
    }

    protected void noPhoneNumber(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone("");
    }

    protected void tooManyPhoneDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone()+1);
    }

    protected void tooLittleDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        // do poprawy
    }

    protected void lettersInPhoneInput() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generateRandomString(9));
        checkNotify(errorPhoneInput,error_PhoneInput);
    }

    protected void repeatedPhoneNumber() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        String num = generatePhone();
        registerPage.registerCompletePhone(num);
        registerPage.submitPhone ();
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(num);
        registerPage.submitPhone ();
        //Wstawić walidacje, czy input z sms-kodem jest pusty
    }

    protected void tooLongPinCode() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(11);
        // max znaków w setPinView to 10 na jeden input
        registerPage.setPinView(firstPin,firstPin);
    }

    protected void tooShortPinCode() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(5);
        // min znaków w setPinView to 6 na jeden input
        registerPage.setPinView(firstPin,firstPin);
    }

    protected void onlyFirstPinFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView(firstPin,"");
    }

    protected void onlySecondPinFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView("",firstPin);
    }

    protected void emptyPinFields() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("","");
        /**Sprawdza ile przycisków jest aktywnych. Powinno być 0*/

    }

    protected void setupAccountWithoutFullName() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("February"),getDaySelector("10"));
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_name_email_address("",email,address);
        registerPage.setUpAccount_policiesAndMessages(true,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

    protected void setupAccountWithoutDateOfBirth() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

    protected void setupAccountWithoutCity() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("January"),day20);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }
    protected void setupAccountWithoutAddress() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        registerPage.setUpAccount_name_email_address(name,email,"");
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("March"),day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

    protected void setupAccountWithoutPolicies() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("January"),day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(false,true);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

    protected void aboutYourselfWithoutGender() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone();
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"), getMonthSelector("February"), day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_basicData(null, "180", "80", a_minus);
        //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }
        protected void aboutYourselfOnlyWithGender() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"), getMonthSelector("February"), day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_basicData(male, "", "", null);
        registerPage.confirm_moreAboutYou();
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

        protected void withoutProfilePicture() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"), getMonthSelector("January"), day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_basicData(male, "180", "80", a_minus);
        registerPage.moreAboutYou_skillSet(false, skillMsOffice, skillExcell, skillProgramming);
        registerPage.moreAboutYou_licensesAndCertificates(false, licenseOne, licenseTwo, licenseThree);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageEnglish, languagePolish, languageGerman, languageHindi, languageSpanish);
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("skip", "");
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }
        protected void withJpgProfilePicture(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"), getMonthSelector("January"), day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_basicData(male, "180", "80", a_minus);
        registerPage.moreAboutYou_skillSet(false, skillMsOffice, skillExcell, skillProgramming);
        registerPage.moreAboutYou_licensesAndCertificates(false, licenseOne, licenseTwo, licenseThree);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageEnglish, null, null, null);
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",  AVATAR);
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }

        protected void withPngProfilePicture() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.submitPhone ();
        registerPage.confirmSms("");
        registerPage.setPinView("123456", "123456");
        registerPage.confirmPin();
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " + generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name, email, address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"), getMonthSelector("January"), day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_countrySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.confirm_SetUpAccount();
        registerPage.moreAboutYou_basicData(male, "180", "80", a_minus);
        registerPage.moreAboutYou_skillSet(false, skillMsOffice, skillExcell, skillProgramming);
        registerPage.moreAboutYou_licensesAndCertificates(false, licenseOne, licenseTwo, licenseThree);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageEnglish, null, null, null);
        registerPage.confirm_moreAboutYou();
        registerPage.photoUpload("browser",  ("user.dir") + "src/main/resources/Images_And_Documents/pobrane.png");
            //Dopisać walidacje, czy przycisk "Continue" "jest disable" i czy pojawia się error pod inputem
    }
}
