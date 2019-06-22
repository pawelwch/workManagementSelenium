package TestCaseBuilders;

import JsonData.JsonParser;
import Pages.HomePageFactory.HomePage;
import Pages.JobsFactory.JobsPage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import RestAPI.REST_Methods;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.WebDriver;

import static Pages.JobsFactory.JobsWebElements.*;
import static TestMethods.BaseMethods.generateRandomString;

public class Jobs {


    public WebDriver driver ;
    protected HomePage homePage ;
    protected LoginPage loginPage ;
    protected RegisterPage registerPage;
    protected JobsPage jobsPage ;
    protected BaseMethods baseMethods ;
    protected ConfigureMethods configureMethods ;
    protected JsonParser jsonParser ;
    protected REST_Methods rest_methods ;

    protected void addJob_SUCCESS () {
        homePage.AddOffer();
        jobsPage.basicInformation(generateRandomString(20), generateRandomString(120));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // datepicker method
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(individualAssignment);
        jobsPage.confirm_jobDetails();
        jobsPage.numberOfLabourers("12", "34");
        jobsPage.labourersDetails(male, "120","75", "20","60");
        jobsPage.labourersDetails_languages(languagePolish,languageGerman,languageSpanish);
        //jobsPage.highligthsSection();
        jobsPage.paymentDetails_paymentWage("100", "200");
        jobsPage.paymentDetails_paymentFrequency(perDay);
        jobsPage.paymentDetails_paymentType(creditCard);
        jobsPage.previewOffer();
        jobsPage.publishJobOffer();
    }

    protected void withoutTitleJob(){
        jobsPage.basicInformation("", generateRandomString(100));
        jobsPage.confirm_basicInformation();
    }

    protected void withoutDescriptionJob(){
        jobsPage.basicInformation(generateRandomString(100), "");
        jobsPage.confirm_basicInformation();
    }

    protected void withoutLocationJob(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        // metoda z datepickerem
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
    }

    protected void withoutStartDateJob(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem przekazująca tylko w parametrze EndDate
        jobsPage.jobDetails_employmentType(partTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
    }

    protected void withoutEndDateJob(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem przekazująca tylko w parametrze StartDate
        jobsPage.jobDetails_employmentType(partTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
    }

    protected void withoutEmploymentType(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_assignmentType(shortTermEmployment);
        jobsPage.confirm_jobDetails();

    }


}
