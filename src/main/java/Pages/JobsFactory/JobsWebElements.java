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
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/button[1]")public static WebElement male;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/button[2]")public static WebElement female;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div/button[3]")public static WebElement other;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[3]/div/label/input") WebElement minHeight;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[4]/div/label/input") WebElement minWeight;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[5]/div[1]/div/label/input") WebElement minAge;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[5]/div[2]/div/label/input") WebElement maxAge;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[6]/div/div/div[1]" ) WebElement languages;
    @FindBy(id = "react-select-3-option-0" )public static WebElement languagePolish;
    @FindBy(id = "react-select-3-option-1" )public static WebElement languageEnglish;
    @FindBy(id = "react-select-3-option-2" )public static WebElement languageGerman;
    @FindBy(id = "react-select-3-option-3" )public static WebElement languageHindi;
    @FindBy(id = "react-select-3-option-4" )public static WebElement languageSpanish;
    @FindBy(id = "react-select-3-option-5" )public static WebElement languageItalian;

    @FindBy(className = "css-vj8t7z") WebElement highlights;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/label/input")public static WebElement minWage;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[2]/div/label/input") WebElement maxWage;
    @FindBy(id = "perDay") public static WebElement perDay;
    @FindBy(id = "perHour") public static WebElement perHour;
    @FindBy(id = "perMonth") public static WebElement perMonth;
    @FindBy(id = "total") public static WebElement total;

    @FindBy(className = "css-10nd86i") WebElement paymentTypeInput;
    @FindBy(id = "react-select-2-option-0") public static WebElement creditCard;
    @FindBy(id = "react-select-2-option-1") public static WebElement bankTransfer;
    @FindBy(id = "react-select-2-option-2") public static WebElement payPal;

    @FindBy(xpath = "//button[text()='Preview']") WebElement previewOfferButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/button") WebElement publishButton;
}
