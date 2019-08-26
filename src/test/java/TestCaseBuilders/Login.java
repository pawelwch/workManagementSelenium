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
import static Pages.LoginFactory.LoginWebElements.*;
import static TestMethods.BaseMethods.checkNotify;
import static TestMethods.BaseMethods.generatePhone;
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

    public void login_tooLongPhoneNumber(){

    }

    public void login_tooShortPhoneNumber(){

    }

    public void login_incorrectPassword(){

    }

    public void login_emptyPasswordInput(){

    }

}
