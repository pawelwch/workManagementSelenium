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
        registerPage.setUpAccount(generateRandomString(5),generateRandomEmail(),null,null,null,generateRandomString(20),true,true);
        registerPage.moreAboutYourselfView(male,generateRandomNumber(3),generateRandomNumber(2),zero_minus);
        registerPage.photoUpload("skip");

    }



}
