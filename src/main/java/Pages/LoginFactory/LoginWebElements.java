package Pages.LoginFactory;

import Pages.RegisterFactory.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//  LoginWebElements - Definiujemy publiczną klasę która przechowuje elementy widoku LoginPage
public class LoginWebElements {

    //  Konstruktor obiektu LoginWebElements, który przekazuje zmienna driver, która jest obiektu typu WebDriver;
    LoginWebElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //  Definiujemy zmieną driver która jest obiektem typu WebDriver;
    protected WebDriver driver;

    // Lokalizujemy wszystkie elementy widoku LoginPage za pomocą adnotacji @Findby;
    @FindBy(tagName = "body") public static WebElement loginBody;
    @FindBy(className = "sc-cqpYsc gNDfCh") WebElement countrySelector;
    @FindBy(id = "react-select-13-option-2") WebElement polishPrefix;
    @FindBy(id = "phone") WebElement loginPhoneInput;
    @FindBy(id = "submitLoginPhone")public static WebElement loginContinueButton;
    @FindBy(xpath = "//*[contains(@class, 'sc-cugefK')]")public static WebElement buttonIsVisible;
    @FindBy(className = "sc-cmthru")public static WebElement errorPhoneIsRequired;
    @FindBy(id = "loginSignupLink") WebElement signUpButton;

    @FindBy(id = "password") WebElement passwordInput;
    @FindBy(id = "submitLoginPassword") WebElement passwordContinueButton;


}
