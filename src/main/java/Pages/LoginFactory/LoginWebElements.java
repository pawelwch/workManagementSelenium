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
    @FindBy(xpath = "//*[@type='tel']") WebElement loginPhoneInput;
    @FindBy(xpath = "//*[.='Continue']") WebElement loginContinueButton;
    @FindBy(xpath = "//*[@href='/sign-up']") WebElement signUpButton;


}
