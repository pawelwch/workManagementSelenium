package Pages.RegisterFactory;

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
    protected WebDriver driver;

    // Lokalizujemy wszystkie elementy widoku RegisterPage za pomocą adnotacji @Findby;
    @FindBy(xpath = "//*[@type='tel']") WebElement registerPhoneInput;

    @FindBy(className = "selected-flag")WebElement countrySelector;
    @FindBy(xpath = "//*[@data-country-code='pl']") WebElement polishPrefix;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div[2]/div/button") WebElement submitFirstView;
    @FindBy(xpath = "//*[@href='/log-in']") WebElement logInButton;
    @FindBy(id = "smsCodeInput") WebElement smsInput;
    @FindBy(xpath = "//*[.='Continue']") WebElement confirmSmsCodeButton;
    @FindBy(xpath = "//*[@name = 'pinInput']") WebElement firstPinInput;
    @FindBy(xpath = "//*[@name = 'pinRepeatInput']") WebElement secondPinInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div[3]/button") WebElement pinConfirmButton;
    @FindBy(xpath = "//*[.='Labourer']") public static WebElement labourer;
    @FindBy(xpath = "//*[.='Contractor']") public static WebElement contractor;
    @FindBy(xpath = "//*[.='Employer']") public static WebElement employer;

//selektgory z datą do zparametryzowania!!
    @FindBy(id = "fullName")  WebElement fullName;
    @FindBy(id = "email")  WebElement email;
    @FindBy(id = "dropdown-year")  WebElement yearInput;
    @FindBy (xpath = "//*[@value='2000']") WebElement year2000;
    @FindBy(xpath = "//*[.='January']")  WebElement month1;
    @FindBy(xpath = "//*[@value='20']")  WebElement day20;

    @FindBy(className = "css-1hwfws3") WebElement countrySelect;
    @FindBy(className = "css-11unzgr") WebElement firstCountryInSelector;
    @FindBy(className = "css-1g6gooi") WebElement countryInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div[5]/div/div[1]/div[2]")  WebElement citySelector;
    @FindBy(id = "react-select-3-input")  WebElement firstCityInSelektor;
    @FindBy(id = "react-select-3-option-0") WebElement WarsawCity;
    @FindBy(id = "address")  WebElement address;
    @FindBy(id = "policies")  WebElement policies;
    @FindBy(id = "messages")  WebElement messages;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div/div[9]/button") WebElement confirmSetupAccount;

    @FindBy(id = "male" )public static WebElement male;
    @FindBy(id = "female" )public static WebElement female;
    @FindBy(id = "other" )public static WebElement other;
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
    @FindBy(id = "react-select-2-option-0")public static WebElement skillExcell;
    @FindBy(id = "react-select-2-option-1")public static WebElement skillMsOffice;
    @FindBy(id = "react-select-2-option-2")public static WebElement skillProgramming;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[6]/div/div/div[1]" ) WebElement licensesAndCertificates;
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
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[1]/div/button") WebElement browserGallery;
    @FindBy (xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[2]/button") WebElement takeAPhoto;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[1]/div[3]/div/input") WebElement uploadIdCard;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div[3]/div/input") WebElement uploadCertificates;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[3]/div[2]/p[2]/input") WebElement idNumber;

}
