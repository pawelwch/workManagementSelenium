package TestCaseBuilders;

import JsonData.JsonParser;
import Pages.HomePageFactory.HomePage;
import Pages.JobsFactory.JobsPage;
import Pages.LoginFactory.LoginPage;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;

public class Jobs {


    WebDriver driver ;
    HomePage homePage ;
    LoginPage loginPage ;
    JobsPage jobsPage ;
    BaseMethods baseMethods ;
    ConfigureMethods configureMethods ;
    JsonParser jsonParser ;
    REST_Methods rest_methods ;

    protected void AddJob_SUCCESS () {
        homePage.AddOffer();

    }


}
