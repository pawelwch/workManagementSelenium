package Pages.LoginFactory;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static TestMethods.BaseMethods.configureMethods;
import static TestMethods.ConfigureMethods.waitForIt;

/*
klasa LoginPage - klasa w której przechowujemy i wykonujemy metody dot. LoginPage. Roszerzona jest o klasę LoginWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony.
 */
public class LoginPage extends LoginWebElements{

   // Konstruktor klasy przekazujący w parametrze zmienną driver która jest obiektu typu WebDriver.
    public LoginPage(WebDriver driver) {
       /*
        Metoda super() powoduje wywołanie konstruktora klasy nadrzędnej.
        W tym przypadku metoda LoginPage korzysta z konstruktora utworzonego w klasie LoginWebElements;
         */
        super(driver);
    }

    public void selectCountry() {
        waitForIt(countrySelector).click();
        configureMethods.scroolToTheSomePoint(polishPrefix);
        waitForIt(polishPrefix).click();
    }

    public void loginCompletePhone(String phone) {
        waitForIt(loginPhoneInput).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));
        waitForIt(loginPhoneInput).sendKeys(phone);
    }

    public void submitPhone() {
        // waitForIt().click();
    }
}


