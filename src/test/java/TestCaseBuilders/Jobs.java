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
        //homePage.AddOffer();
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
        // metoda z datepickerem przekazuj??ca tylko w parametrze EndDate
        jobsPage.jobDetails_employmentType(partTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
    }

    protected void withoutEndDateJob(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem przekazuj??ca tylko w parametrze StartDate
        jobsPage.jobDetails_employmentType(partTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
    }

    protected void withoutEmploymentType(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_assignmentType(bothAssignment);
        jobsPage.confirm_jobDetails();
    }

    protected void withoutMinNumberOfWorkers(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_employmentType(shortTermEmployment);
        jobsPage.jobDetails_assignmentType(other);
        jobsPage.confirm_jobDetails();
        jobsPage.numberOfLabourers("", "22");
        jobsPage.labourersDetails(male, "120", "80" , "18", "50");
        jobsPage.labourersDetails_languages(languagePolish);
        jobsPage.confirm_labourersDetails();
    }

    protected void withoutMinWage(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
        jobsPage.numberOfLabourers("12", "22");
        jobsPage.labourersDetails(male, "120", "80" , "18", "50");
        jobsPage.labourersDetails_languages(languagePolish);
        jobsPage.confirm_labourersDetails();
        jobsPage.highlightsSection(highVoltage, heavyMaterials);
        jobsPage.paymentDetails_paymentWage("", "1000");
        jobsPage.paymentDetails_paymentFrequency(perMonth);
        jobsPage.paymentDetails_paymentType(creditCard);
        jobsPage.previewOffer();
    }

    protected void withoutMaxWage(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
        jobsPage.numberOfLabourers("12", "22");
        jobsPage.labourersDetails(male, "120", "80" , "18", "50");
        jobsPage.labourersDetails_languages(languagePolish);
        jobsPage.confirm_labourersDetails();
        jobsPage.highlightsSection(highVoltage, heavyMaterials);
        jobsPage.paymentDetails_paymentWage("100", "");
        jobsPage.paymentDetails_paymentFrequency(perMonth);
        jobsPage.paymentDetails_paymentType(payPal);
        jobsPage.previewOffer();
    }

    protected void withoutPaymentFrequency(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
        jobsPage.numberOfLabourers("12", "22");
        jobsPage.labourersDetails(male, "120", "80" , "18", "50");
        jobsPage.labourersDetails_languages(languagePolish);
        jobsPage.confirm_labourersDetails();
        jobsPage.highlightsSection(highVoltage, heavyMaterials);
        jobsPage.paymentDetails_paymentWage("100", "120");
        jobsPage.paymentDetails_paymentType(bankTransfer);
        jobsPage.previewOffer();
    }

    protected void minWageIsBiggerThanMaxWage(){
        jobsPage.basicInformation(generateRandomString(100), generateRandomString(100));
        jobsPage.confirm_basicInformation();
        jobsPage.jobDetails_locationSelector();
        // metoda z datepickerem
        jobsPage.jobDetails_employmentType(fullTimeEmployment);
        jobsPage.jobDetails_assignmentType(contractorAssignment);
        jobsPage.confirm_jobDetails();
        jobsPage.numberOfLabourers("12", "22");
        jobsPage.labourersDetails(male, "120", "80" , "18", "50");
        jobsPage.labourersDetails_languages(languagePolish);
        jobsPage.confirm_labourersDetails();
        jobsPage.highlightsSection(highVoltage, heavyMaterials);
        jobsPage.paymentDetails_paymentWage("200", "120");
        jobsPage.paymentDetails_paymentFrequency(perHour);
        jobsPage.paymentDetails_paymentType(bankTransfer);
        jobsPage.previewOffer();
    }





}
