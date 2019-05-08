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
        waitForIt(titleOfJob).sendKeys(title);
        waitForIt(descriptionJob).sendKeys(description);
    }

    public void confirm_basicInformation() {
        waitForIt(confirmJobBasicInformation).click();
    }

    public void jobDetails_locationSelector() {
        waitForIt(LocationSlector).sendKeys("Wroc");
        sleep(2000);
        waitForIt(firstSelectorElement).click();
    }

    public void jobDetails_datePicker() {
        waitForIt(datePicker).click();
        waitForIt(getDay).click();
//dokończyć datepickera
    }

    public void jobDetails_employmentType() {

    }
}
