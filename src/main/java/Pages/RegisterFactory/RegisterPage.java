package Pages.RegisterFactory;

import TestMethods.ConfigureMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static TestMethods.ConfigureMethods.sleep;
import static TestMethods.ConfigureMethods.waitForIt;


/*
klasa RegisterPage - klasa w której przechowujemy i wykonujemy metody dot. RegisterPage. Roszerzona jest o klasę RegisterWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony.
 */
public class RegisterPage extends RegisterWebElements{

    /*
    Metoda przekazująca w parametrze zmienna driver która jest obiektu typu WebDriver. Metoda super() powoduje wywołanie konstruktora klasy nadrzędnej.
    W tym przypadku metoda RegisterPage korzysta z konstruktora utworzonego w klasie RegisterWebElements;
     */
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    /*
        Definiujemy metodę przekazująca w parametrze wartość typu String.
        Wykonanie metody z parametrem spowoduje przekazanie parametru do elementu strony registerPhoneInput oraz kliknięcie submitFirstView;
     */
    public void registerCompletePhone(String phone) {
      waitForIt(registerPhoneInput).sendKeys(phone);
        waitForIt(submitFirstView).click();

    }

    public void confirmSms(String sms) {
//        waitForIt(smsInput).sendKeys(sms);
        waitForIt(confirmSmsCodeButton).click();
    }

    public void setPinView(String pin1, String pin2) {
        waitForIt(firstPinInput).sendKeys(pin1);
        waitForIt(secondPinInput).sendKeys(pin2);
        waitForIt(pinConfirmButton).click();
    }

}
