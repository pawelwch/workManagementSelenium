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
import static TestMethods.StaticsData.*;

//  Klasa bazowa która przechowuje obiekty poszczególnych klas?/Pages?
public class Register {

    WebDriver driver;
    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    BaseMethods baseMethods;
    ConfigureMethods configureMethods;
    JsonParser jsonParser;


    /**@param accountType - ustala jakie konto ma byc rejestrowane. Do wyboru: labourer, contractor, employer
     * @param city_accountType ze względu na sztywny xpath trzeba wybrać czy rejestrujemy się jako labourer. Jesli tak to tak wpisujemy tak, jeśli nie, to contractor lub employer*/
    void register(WebElement accountType, WebElement city_accountType) {
        String pinCode = generateRandomNumber(6);
        System.out.println(pinCode);
        String phone = generatePhone();
        System.out.println(phone);
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(phone);
        registerPage.confirmSms("");
        registerPage.setPinView(pinCode, pinCode);
        registerPage.accountTypeSelector(accountType);
        registerPage.setUpAccount_name_email_address(generateRandomString(5),generateRandomEmail(),generateRandomString(20));
        registerPage.setUpAccount_Birth_date(getYearSelector("1999"),getMonthSelector("March"),day20);
        registerPage.setUpAccount_citySelector(city_accountType);
        registerPage.setUpAccount_policiesAndMessages(true, true);
        registerPage.moreAboutYou_basicData(male,generateRandomNumber(3),generateRandomNumber(2),zero_minus);
        registerPage.moreAboutYou_skillSet(true, skillExcell, null, null);
        registerPage.moreAboutYou_licensesAndCertificates(false,licenseTwo, null, null);
        registerPage.moreAboutYou_education(educationVol1);
        registerPage.moreAboutYou_languages(languageHindi, languageEnglish, languageGerman,null, null);
        registerPage.photoUpload("browser",AVATAR);
        registerPage.uploadIdCard(AVATAR,PDF);
        registerPage.uploadCertificates(AVATAR, PDF);
        registerPage.idNumber(generateRandomNumber(5));
        registerPage.continueDocumetsUploadButton();
    }

    void noPhoneNumber(){
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone("");
    }

    void tooManyPhoneDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone()+1);
    }

    void tooLittleDigits() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
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
        String num = generatePhone();
        registerPage.registerCompletePhone(num);
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(num);
    }

    void tooLongPinCode() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(11);
        // max znaków w setPinView to 10 na jeden input
        registerPage.setPinView(firstPin,firstPin);
    }

    void tooShortPinCode() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(5);
        // min znaków w setPinView to 6 na jeden input
        registerPage.setPinView(firstPin,firstPin);
    }

    void onlyFirstPinFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView(firstPin,"");
    }

    void onlySecondPinFilledOut() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        String firstPin = generateRandomNumber(6);
        registerPage.setPinView("",firstPin);
    }

    void emptyPinFields() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("","");
    }

    void setupAccountWithoutFullName() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address("",email,address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("February"),getDaySelector("10"));
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }

    void setupAccountWithoutDateOfBirth() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }

    void setupAccountWithoutCity() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("January"),day20);
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }
    void setupAccountWithoutAddress() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,"");
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("March"),day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_policiesAndMessages(true,true);
    }

    void setupAccountWithoutPolicies() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("January"),day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_policiesAndMessages(false,true);
    }

    void aboutYourselfWithoutGender() {
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhone());
        registerPage.confirmSms("");
        registerPage.setPinView("123456","123456");
        registerPage.accountTypeSelector(labourer);
        String name = generateRandomString(5) + " " +generateRandomString(5);
        String email = generateRandomEmail();
        String address = generateRandomString(10) + " 2/2";
        registerPage.setUpAccount_name_email_address(name,email,address);
        registerPage.setUpAccount_Birth_date(getYearSelector("2000"),getMonthSelector("February"),day20);
        registerPage.setUpAccount_citySelector(labourer);
        registerPage.setUpAccount_policiesAndMessages(true,true);
        registerPage.moreAboutYou_basicData(null,"180","80", a_minus);

    }


}
