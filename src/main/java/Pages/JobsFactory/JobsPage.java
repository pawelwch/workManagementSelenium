package Pages.JobsFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static TestMethods.BaseMethods.*;
import static TestMethods.ConfigureMethods.*;

public class JobsPage extends JobsWebElements {

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public void basicInformation(String title, String description) {
        waitForIt(this.title).sendKeys(title);
        waitForIt(this.description).sendKeys(description);
    }

    public void confirm_basicInformation() {
        waitForIt(confirmJobBasicInformation).click();
    }

    public void jobDetails_locationSelector() {
        waitForIt(LocationSlector).sendKeys("Wroc");
        sleep(2000);
        waitForIt(firstSelectorElement).click();
    }

    /*
    * public void jobDetails_datePicker(WebElement) {

        waitForIt(datePicker).click();
        waitForIt(getDay).click();
    }
    *
    * */


    public void jobDetails_employmentType(WebElement employmentType) {
        waitForIt(employmentType).click();
    }

    public void jobDetails_assignmentType(WebElement assignmentType) {
        waitForIt(assignmentType).click();
    }

    public void confirm_jobDetails() {
        waitForIt(confirmJobDetails).click();
    }

    public void numberOfLabourers(String min, String max){
        waitForIt(minLabourers).sendKeys(min);
        waitForIt(maxLabourers).sendKeys(max);
    }

    public void labourersDetails(WebElement gender, String minHeight, String minWeight, String minAge, String maxAge) {
        waitForIt(gender).click();
        waitForIt(this.minHeight).sendKeys(minHeight);
        waitForIt(this.minWeight).sendKeys(minWeight);
        waitForIt(this.minAge).sendKeys(minAge);
        waitForIt(this.maxAge).sendKeys(maxAge);
    }


    /**@param args -wybiera język z listy dostępnych WebElementów w:
     * @see JobsWebElements Parametr ten, to varargs, wiec moze przyjmować zmienna liczbe argumentów.
     * dodatkowo metoda zamyka się poprzez kliknięciem w przycisk continue */
    public void labourersDetails_languages(WebElement...args) {
        waitForIt(languages).click();
        try {
            waitForIt(args[0]).click();
            waitForIt(languages).click();
            waitForIt(args[1]).click();
            waitForIt(languages).click();
            waitForIt(args[2]).click();
            waitForIt(languages).click();
            waitForIt(args[3]).click();
            waitForIt(languages).click();
            waitForIt(args[4]).click();
        }catch (NullPointerException e) {
            waitForIt(minAge).click();
        }
    }

    public void highligthsSection(WebElement...args) {
        waitForIt(highlights).click();
        try {
            waitForIt(args[0]).click();
            waitForIt(highlights).click();
            waitForIt(args[1]).click();
            waitForIt(highlights).click();
            waitForIt(args[2]).click();
            waitForIt(highlights).click();
            waitForIt(args[3]).click();
            waitForIt(highlights).click();
            waitForIt(args[4]).click();
        }catch (NullPointerException e) {
            waitForIt(minAge).click();
        }
    }

    public void paymentDetails_paymentWage(String minWage, String maxWage){
        waitForIt(this.minWage).sendKeys(minWage);
        waitForIt(this.minAge).sendKeys(maxWage);
    }

    public void paymentDetails_paymentFrequency(WebElement paymentFrequency){
        waitForIt(paymentFrequency).click();
    }





}
