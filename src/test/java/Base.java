import JsonData.JsonParser;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.RegisterFactory.RegisterWebElements.labourer;
import static TestMethods.BaseMethods.generatePhoneNumber;
import static TestMethods.BaseMethods.generateRandomNumber;
import static TestMethods.ConfigureMethods.browserPicker;
import static TestMethods.ConfigureMethods.sleep;

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



    void registerAsLabourer(WebElement accountType) {
        String pinCode = generateRandomNumber(6);
        homePage.GoToSignUp();
        registerPage.selectCountry();
        registerPage.registerCompletePhone(generatePhoneNumber());
        registerPage.confirmSms("");
        registerPage.setPinView(pinCode, pinCode);
        registerPage.accountTypeSelector(accountType);
    }



}
