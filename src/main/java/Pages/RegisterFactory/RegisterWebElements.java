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
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/section/div/form/div[1]/div/div/div[1]/div/div/div[1]")WebElement countrySelector;
    @FindBy(xpath = "//*[@id=\"react-select-4-option-176\"]") public static WebElement polishPrefix;
    @FindBy(id = "phone") WebElement registerPhoneInput;
    @FindBy(id = "submitSignupPhone") public static  WebElement submitFirstView;


    @FindBy(name = "code-5") WebElement sixthNumberOfSmsCode;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/section/div/div[2]/p") public static WebElement resendSmsCodeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[3]/span") public static WebElement errorPinCode;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[3]/span") public static WebElement errorPinCodeDoesntMatch;
    @FindBy(id = "password") WebElement firstPinInput;
    @FindBy(id = "passwordConfirm") WebElement secondPinInput;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[4]/button") public static WebElement passwordConfirmButton;

    @FindBy(id = "btn-labourer") public static WebElement labourer;
    @FindBy(id = "btn-contractor") public static WebElement contractor;
    @FindBy(id = "btn-employer") public static WebElement employer;

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


    //@FindBy(id = ) WebElement male;
    //@FindBy(id = ) WebElement female;
    //@FindBy(id = ) WebElement other;
    @FindBy(id = "fullName")  WebElement fullName;
    @FindBy(id = "email")  WebElement email;
    @FindBy(id = "dob") public static WebElement dayOfBirthInput;

    @FindBy(id = "dropdown-year")  WebElement yearInput;
    @FindBy(xpath = "//*[@value='20']") public static  WebElement day20;

    @FindBy(xpath = "//*[@id=\"country\"]/div/div/div") WebElement countryInput;
    @FindBy(id = "react-select-3-input") WebElement countryInputText;
    @FindBy(id = "react-select-3-option-0") WebElement firstCountryInSelector;
    @FindBy(xpath = "//*[@id=\"city\"]/div/div/div")  WebElement cityInput;
    @FindBy(xpath = "//*[@id=\"react-select-6-input\"]") WebElement cityInputText;
    @FindBy(id = "react-select-6-option-0") WebElement firstCityChoice;
    @FindBy(id = "address")  WebElement address;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[8]/div[1]/label/span[2]/span") public static WebElement policies;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[8]/div[2]/label/span[2]/span") public static WebElement marketing;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[9]/div/button") public static WebElement confirmSetupAccount;
    @FindBy(xpath = "//div[@class='error-message") public static WebElement errorSetupYourAccount;
    @FindBy(xpath = "//*[@id=\"fullName\"]/span") public static WebElement errorFullName;
    @FindBy(xpath = "//*[@id=\"dob-helper-text\"]/span") public static WebElement errorDateOfBirth;
    @FindBy(xpath = "//*[@id=\"city\"]/span") public static WebElement errorCity;
    @FindBy(xpath = "//*[@id=\"address\"]/span") public static WebElement errorAddress;

    @FindBy(id = "height") public static WebElement height;
    @FindBy(id = "weight") public static WebElement weight;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[2]/div/div/div/div") WebElement skillsets;
    @FindBy(xpath = "//*[@id=\"react-select-2-input\"]") WebElement skillInputTyping;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-0\"]") public static WebElement excelSkill;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-1\"]") public static WebElement msOfficeSkill;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-1\"]") public static WebElement programmingSkill;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-1\"]") public static WebElement javaSkill;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-1\"]") public static WebElement javaScriptSkill;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-1\"]") public static WebElement oneSkill;
    @FindBy(xpath = "//*[@id=\"react-select-14-option-1\"]") public static WebElement twoSkill;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[3]/div/div/div/div") WebElement licensesAndCertificates;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[4]/div/div/div/div") WebElement education;
    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/form/div[5]/div/div/div/div") WebElement languages;
    @FindBy(id = "biography") WebElement biography;
    @FindBy(id = "signupSkipStep") public static WebElement skipButton;

    @FindBy(id = "react-select-3-input" ) WebElement licensesInputTyping;

    @FindBy(xpath = "//*[@id=\"react-select-9-option-0\"]") public static WebElement bachelorEducation;
    @FindBy(xpath = "//*[@id=\"react-select-9-option-1\"]") public static WebElement engineerEducation;
    @FindBy(xpath = "//*[@id=\"react-select-9-option-2\"]") public static WebElement masterEducation;

    @FindBy(xpath = "//*[@id=\"react-select-10-option-0\"]") public static WebElement polishLanguage;
    @FindBy(xpath = "//*[@id=\"react-select-10-option-1\"]") public static WebElement englishLanguage;
    @FindBy(xpath = "//*[@id=\"react-select-10-option-2\"]") public static WebElement spanishLanguage;




    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[9]/button") WebElement continueButtonMoreAboutU;


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
