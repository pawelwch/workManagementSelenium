package TestCaseBuilders;

import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.LoginFactory.LoginWebElements;
import Pages.RegisterFactory.RegisterPage;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;

import static JsonData.JsonParser_Notification.error_PhoneIsRequired;
import static JsonData.JsonParser_Notification.error_ValidPhoneNumber;
import static Pages.LoginFactory.LoginWebElements.*;
import static TestMethods.BaseMethods.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Login {

    public WebDriver driver ;
    protected HomePage homePage ;
    protected RegisterPage registerPage ;
    protected LoginPage loginPage ;
    protected BaseMethods baseMethods ;
    protected ConfigureMethods configureMethods ;
    protected JsonParser jsonParser ;
    protected JsonParser_Notification jsonParser_notification;
    protected REST_Methods rest_methods ;

    public void login_SUCCESS(){
        homePage.GoToLogin();
        loginPage.fillLoginPhoneInput("9979979997");
        loginPage.submitPhone();
        loginPage.fillLoginPasswordInput("12345678");
        loginPage.submitLoginPassword();
    }

    public void login_emptyPhoneNumberInput(){
        homePage.GoToLogin();
        loginPage.fillLoginPhoneInput("");
        baseMethods.clickSomewhere(loginBody);
        boolean buttonIsVisible = LoginWebElements.buttonIsVisible.isDisplayed();
        assertFalse(buttonIsVisible);
        checkNotify(errorPhoneIsRequired, error_PhoneIsRequired);
    }


    public void login_tooShortPhoneNumber(){
        homePage.GoToLogin();
        String number = 8 + generateRandomNumber(7);
        loginPage.fillLoginPhoneInput(number);
        baseMethods.clickSomewhere(loginBody);
        loginPage.submitPhone();
        checkNotify(errorValidPhoneNumber, error_ValidPhoneNumber);
        // do poprawy
    }

    public void login_incorrectPassword(){
    //// TODO: 25.10.2021
    }

    public void login_emptyPasswordInput(){
    //// TODO: 25.10.2021
    }

}
