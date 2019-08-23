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

import static TestMethods.BaseMethods.generatePhone;

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
        loginPage.selectCountry();
        loginPage.loginCompletePhone("");
        loginPage.submitPhone();
    }

    public void login_emptyPhoneNumberInput(){

    }

    public void login_tooLongPhoneNumber(){

    }

    public void login_tooShortPhoneNumber(){

    }

    public void login_incorrectPassword(){

    }


}
