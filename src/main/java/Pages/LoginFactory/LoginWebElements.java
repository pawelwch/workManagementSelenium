package Pages.LoginFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

//  LoginWebElements - Definiujemy publiczną klasę która przechowuje elementy widoku LoginPage
public class LoginWebElements {

    //  Definiujemy zmieną driver która jest obiektem typu WebDriver;
    protected WebDriver driver;

    // Lokalizujemy wszystkie elementy widoku LoginPage za pomocą adnotacji @Findby;
    @FindBy(xpath = "//*[@type='tel']") WebElement loginPhoneInput;
    @FindBy(xpath = "//*[.='Continue']") WebElement loginContinueButton;
    @FindBy(xpath = "//*[@href='/sign-up']") WebElement signUpButton;

    LoginWebElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
