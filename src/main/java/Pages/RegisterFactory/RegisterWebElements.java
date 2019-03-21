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
    @FindBy(id = "fullName")  WebElement fullName;
    @FindBy(id = "email")  WebElement email;
    @FindBy(id = "dropdown-year")  WebElement yearInput;
    @FindBy(className = "month-input")  WebElement monthInput;
    @FindBy(className = "day-input")  WebElement dayInput;
    @FindBy(className = "css-vj8t7z") WebElement countrySelect;
    @FindBy(className = "css-1hwfws3")  WebElement citySelector;
    @FindBy(id = "address")  WebElement address;
    @FindBy(id = "policies")  WebElement policies;
    @FindBy(xpath = "messages")  WebElement messages;
    @FindBy(xpath = "//*[.='Continue']") WebElement confirmSetupAccount;





}
