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



    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[1]/label/input") WebElement title;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[3]/textarea") WebElement description;
    @FindBy(xpath = "//*[contains(text(), 'Continue')]") WebElement confirmJobBasicInformation;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[3]/textarea") WebElement goBackButon;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div/div[3]/textarea") WebElement LocationSlector;
    @FindBy(id =  "react-select-12-option-0") WebElement firstSelectorElement;
    @FindBy(className =  "react-date-picker__inputGroup") WebElement datePicker;
    @FindBy(xpath =  "//*[@id=\"app\"]/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/button[7]") WebElement getDay;
    @FindBy(id = "full-time") public static WebElement fullTimeEmployment;
    @FindBy(id = "part-time") public static WebElement partTimeEmployment;
    @FindBy(id = "short-term") public static WebElement shortTermEmployment;
    @FindBy(id = "other") public static WebElement otherEmployment;
    @FindBy(id = "indi") public static WebElement individualAssignment;
    @FindBy(id = "contractor") public static WebElement contractorAssignment;
    @FindBy(id = "both") public static WebElement bothAssignment;
    @FindBy(xpath = "//*[contains(text(), 'Continue')]") WebElement confirmJobDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/label/input") WebElement minLabourers;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[2]/div/label/input") WebElement maxLabourers;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/button[1]") WebElement male;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/button[2]") WebElement female;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/button[3]") WebElement other;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[3]/div/label/input") WebElement minHeight;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/label/input") WebElement minWeight;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[5]/div[1]/div/label/input") WebElement minAge;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[5]/div[2]/div/label/input") WebElement maxAge;


    /* DOKONCZYC
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[6]/div" ) WebElement languages;
    @FindBy(id = "" )public static WebElement languagePolish;
    @FindBy(id = "" )public static WebElement languageEnglish;
    @FindBy(id = "" )public static WebElement languageGerman;
    @FindBy(id = "" )public static WebElement languageHindi;
    @FindBy(id = "" )public static WebElement languageSpanish;
    **/




}
