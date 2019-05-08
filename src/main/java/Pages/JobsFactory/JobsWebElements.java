package Pages.JobsFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobsWebElements {

    protected final WebDriver driver;

    JobsWebElements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[1]/label/input") WebElement titleOfJob;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[3]/textarea") WebElement descriptionJob;
    @FindBy(xpath = "//*[contains(text(), 'Continue')]") WebElement confirmJobBasicInformation;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[3]/textarea") WebElement goBackButon;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[3]/textarea") WebElement LocationSlector;
    @FindBy(id =  "react-select-12-option-0") WebElement firstSelectorElement;
    @FindBy(className =  "react-date-picker__inputGroup") WebElement datePicker;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/button[7]") WebElement getDay;
    @FindBy(id = "full-time") WebElement fullTimeEmployment;
    @FindBy(id = "part-time") WebElement partTimeEmployment;
    @FindBy(id = "short-term") WebElement shortTermEmployment;
    @FindBy(id = "other") WebElement otherEmployment;


}
