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
public class Base {

    WebDriver driver;
    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;
    BaseMethods baseMethods;
    ConfigureMethods configureMethods;
    JsonParser jsonParser;

    /**Adnotacja @BeforeClass ustawia różne konfigurację które będą wykonane przez wykonaniem każdego testu;
     Adnotacja odnosi się do metody setUpBrowser(), która setupuje Driver w odpowiedni sposób;
     */


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



}
