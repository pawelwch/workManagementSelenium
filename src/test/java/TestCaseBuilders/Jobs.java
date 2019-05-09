package TestCaseBuilders;

import JsonData.JsonParser;
import Pages.HomePageFactory.HomePage;
import Pages.JobsFactory.JobsPage;
import Pages.LoginFactory.LoginPage;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;

import static Pages.JobsFactory.JobsWebElements.*;
import static TestMethods.BaseMethods.generateRandomString;

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
        jobsPage.basicInformation(generateRandomString(20), generateRandomString(120));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // datepicker method
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(individualAssignment);
        jobsPage.confirm_jobDetails();
    }


}
