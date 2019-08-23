package Pages.RegisterFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  RegisterWebElements - Definiujemy publiczną klasę która przechowuje elementy widoku RegisterPage
public class RegisterWebElements {



    //  Konstruktor obiektu RegisterWebElements, który przekazuje zmienna driver, która jest obiektu typu WebDriver;
    RegisterWebElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //  Definiujemy zmieną driver która jest obiektem typu WebDriver;
    protected static WebDriver driver;

    // Lokalizujemy wszystkie elementy widoku RegisterPage za pomocą adnotacji @Findby;

    @FindBy(tagName = "body") public static WebElement body;
    @FindBy(xpath = "//*[@href='/log-in']") WebElement logInButton;

    @FindBy(className = "MuiFormHelperText-root") public static WebElement errorPhoneIsRequired;
    @FindBy(className = "error-message") public static WebElement errorPhoneInput;
    @FindBy(className = "MuiFormHelperText-root") public static WebElement errorValidPhoneNumber;
    @FindBy(className = "sc-keVrkP")WebElement countrySelector;
    @FindBy(id = "react-select-4-option-2") public static WebElement polishPrefix;
    @FindBy(id = "phone") WebElement registerPhoneInput;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/section/div/form/div[2]/div/button") public static  WebElement submitFirstView;


    @FindBy(name = "code-5") WebElement sixthNumberOfSmsCode;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/section/div/div[2]/p") public static WebElement resendSmsCodeButton;

    @FindBy(className = "sc-eEieub") public static WebElement errorPinCode;
    @FindBy(className = "sc-eEieub") public static WebElement errorPinCodeDoesntMatch;
    @FindBy(id = "password") WebElement firstPinInput;
    @FindBy(id = "passwordConfirm") WebElement secondPinInput;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[4]/button") public static WebElement passwordConfirmButton;

    @FindBy(id = "btn-labourer") public static WebElement labourer;
    @FindBy(xpath = "//*[.='Contractor']") public static WebElement contractor;
    @FindBy(xpath = "//*[.='Employer']") public static WebElement employer;

//    public static WebElement getDaySelector(String day) {
//        WebElement daySelector = driver.findElement(By.xpath("//*[@value='"+day+"']"));
//        return daySelector;
//    }
//
//    public static WebElement getMonthSelector(String month) {
//        WebElement monthSelector = driver.findElement(By.xpath("//*[.='"+month+"']"));
//        return monthSelector;
//    }
//
//    public static WebElement getYearSelector(String year) {
//        WebElement yearSelector = driver.findElement(By.xpath("//*[@value='"+year+"']"));
//        return yearSelector;
//    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[1]/div/button[1]")public static WebElement male;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[1]/div/button[2]")public static WebElement female;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[1]/div/button[3]")public static WebElement other;

    @FindBy(id = "fullName")  WebElement fullName;
    @FindBy(id = "email")  WebElement email;
    @FindBy(id = "dob") public static WebElement dayOfBirthInput;

    @FindBy(id = "dropdown-year")  WebElement yearInput;
    @FindBy(xpath = "//*[@value='20']") public static  WebElement day20;

    @FindBy(xpath = "//*[@id=\"country\"]/div") WebElement countryInput;
    @FindBy(id = "react-select-5-input") WebElement countryInputText;
    @FindBy(id = "react-select-5-option-0") WebElement firstCountryInSelector;
    @FindBy(xpath = "//*[@id=\"city\"]/div")  WebElement cityInput;
    @FindBy(id = "react-select-6-input") WebElement cityinputText;
    @FindBy(id = "react-select-6-option-0") WebElement firstCityChoice;
    @FindBy(id = "address")  WebElement address;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[8]/div[1]/label/span[2]")  WebElement policies;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[8]/div[2]/label/span[2]")  WebElement marketing;
    @FindBy(xpath = "//*[contains(text(), 'Continue')]") public static WebElement confirmSetupAccount;
    @FindBy(xpath = "//div[@class='error-message") public static WebElement errorSetupYourAccount;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div/label/input" ) WebElement height;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div/label/input" ) WebElement weight;
    @FindBy(id = "a+" )public static WebElement a_plus;
    @FindBy(id = "a-" )public static WebElement a_minus;
    @FindBy(id = "b+" )public static WebElement b_plus;
    @FindBy(id = "b-" )public static WebElement b_minus;
    @FindBy(id = "ab+" )public static WebElement ab_plus;
    @FindBy(id = "ab-" )public static WebElement ab_minus;
    @FindBy(id = "0+" )public static WebElement zero_plus;
    @FindBy(id = "0-" )public static WebElement zero_minus;
    @FindBy(className = "css-1hwfws3" ) WebElement skillsets;
    @FindBy(xpath = "//*[@id=\"react-select-2-input\"]") WebElement skillInputTyping; //zmienic na id
    @FindBy(id = "react-select-2-option-0")public static WebElement skillExcell;
    @FindBy(id = "react-select-2-option-1")public static WebElement skillMsOffice;
    @FindBy(id = "react-select-2-option-2")public static WebElement skillProgramming;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[6]/div/div/div[1]" ) WebElement licensesAndCertificates;
    @FindBy(id = "react-select-3-input" ) WebElement licensesInputTyping;
    @FindBy(id = "react-select-3-option-0" )public static WebElement licenseOne;
    @FindBy(id = "react-select-3-option-1" )public static WebElement licenseTwo;
    @FindBy(id = "react-select-3-option-2" )public static WebElement licenseThree;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[7]/div/div/div[1]" ) WebElement education;
    @FindBy(id = "react-select-4-option-0" )public static WebElement educationVol1;
    @FindBy(id = "react-select-4-option-1" )public static WebElement educationVol2;
    @FindBy(id = "react-select-4-option-2" )public static WebElement educationVol3;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[8]/div/div/div[1]" ) WebElement languages;
    @FindBy(id = "react-select-5-option-0" )public static WebElement languagePolish;
    @FindBy(id = "react-select-5-option-1" )public static WebElement languageEnglish;
    @FindBy(id = "react-select-5-option-2" )public static WebElement languageGerman;
    @FindBy(id = "react-select-5-option-3" )public static WebElement languageHindi;
    @FindBy(id = "react-select-5-option-4" )public static WebElement languageSpanish;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[9]/button") WebElement continueButtonMoreAboutU;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[1]/button") WebElement skipButton;
    @FindBy (xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[1]/input") WebElement uploadPhoto;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[2]/button") WebElement savePhoto;
    @FindBy (xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[2]/button") WebElement takeAPhoto;


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[1]/div[3]/div/input") WebElement uploadIdCard;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div[3]/div/input") WebElement uploadCertificates;
    /**Selektory takie jak addNextFile, cancleButton, deleteButton oraz submit wystarczy podac tylko raz, bo na widoku dodawania certyfikatów,
     * jak i na widoku dodawania zdjec z cardId te selektory sa takie same*/
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/input[2]") WebElement addNextFile;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div[3]/span[2]/button") WebElement cancleButton;
    @FindBy(xpath = "//*[.=Delete]") WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div[2]/button") WebElement submitCardId;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[2]/p[2]/input") WebElement idNumber;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[4]/button") WebElement continueDocumentsUpload;

    /** CONTRACTOR SELECTORS */

}
