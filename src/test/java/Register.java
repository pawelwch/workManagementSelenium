import JsonData.JsonParser;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static TestMethods.BaseMethods.*;
import static Pages.RegisterFactory.RegisterWebElements.*;

//  Klasa bazowa która przechowuje obiekty poszczególnych klas?/Pages?
public class Register {

    WebDriver driver;
    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    BaseMethods baseMethods;
    ConfigureMethods configureMethods;
    JsonParser jsonParser;


    void registerLabourer(WebElement accountType) {
        String pinCode = generateRandomNumber(6);
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView(pinCode, pinCode);
        registerPage.accountTypeSelector(accountType);
        registerPage.setUpAccount_name_email_address(generateRandomString(5),generateRandomEmail(),generateRandomString(20));
        registerPage.setUpAccount_Birth_date(year2000,month1,day20);
        registerPage.setUpAccount_citySelector();
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.moreAboutYou_basicData(male,generateRandomNumber(3),generateRandomNumber(2),zero_minus);
        registerPage.moreAboutYou_skillSet(true, skillExcell, null, null);
        registerPage.moreAboutYou_licensesAndCertificates(false,null,licenseTwo, null);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageHindi, languageEnglish, null,languageGerman, null);
        registerPage.photoUpload("skip");

    }

    void noPhoneNumber(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone("");
    }

    void tooManyPhoneDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber()+1);
    }

    void tooLittleDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        // do poprawy
    }

    void lettersInPhoneInput() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generateRandomString(9));
    }

    void repeatedPhoneNumber() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        String num = generatePhoneNumber();
        registerPage.registerCompletePhone(num);
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(num);
    }

    void tooLongPinCode() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(11);
        // max znaków w setPinView to 10 na jeden input
        registerPage.setPinView(firstPin,firstPin);
    }

    void tooShortPinCode() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(5);
        // min znaków w setPinView to 6 na jeden input
        registerPage.setPinView(firstPin,firstPin);
    }

    void onlyFirstPinFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView(firstPin,"");
    }

    void onlySecondPinFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView("",firstPin);
    }

    void emptyPinFields() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("","");
    }

    void setupAccountWithoutFullName() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address("",email,address);
        registerPage.setUpAccount_Birth_date(year2000,month1,day20);
        registerPage.setUpAccount_citySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }

    void setupAccountWithoutDateOfBirth() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_citySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }

    void setupAccountWithoutCity() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(year2000,month1,day20);
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }
    void setupAccountWithoutAddress() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,"");
        registerPage.setUpAccount_Birth_date(year2000,month1,day20);
        registerPage.setUpAccount_citySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }

    void setupAccountWithoutPolicies() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(year2000,month1,day20);
        registerPage.setUpAccount_citySelector();
        registerPage.setUpAccount_policiesAndMessages(false,true);
    }

    void aboutYourselfWithoutGender() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(year2000,month1,day20);
        registerPage.setUpAccount_citySelector();
        registerPage.setUpAccount_policiesAndMessages(true,true);
        registerPage.moreAboutYou_basicData(null,"180","80", a_minus);
        registerPage.moreAboutYou_skillSet(false, skillMsOffice, skillExcell, skillProgramming);
        registerPage.moreAboutYou_licensesAndCertificates(false, licenseOne, licenseTwo, licenseThree);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageEnglish,languagePolish,languageGerman,languageHindi,languageSpanish);
    }


}
