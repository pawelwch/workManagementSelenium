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
}
