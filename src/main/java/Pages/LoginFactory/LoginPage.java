package Pages.LoginFactory;


import org.openqa.selenium.WebDriver;

/*
klasa LoginPage - klasa w której przechowujemy i wykonujemy metody dot. LoginPage. Roszerzona jest o klasę LoginWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony.
 */
public class LoginPage extends LoginWebElements{

    /*
    Metoda przekazująca w parametrze zmienna driver która jest obiektu typu WebDriver. Metoda super() powoduje wywołanie konstruktora klasy nadrzędnej.
    W tym przypadku metoda LoginPage korzysta z konstruktora utworzonego w klasie LoginWebElements;
     */
    LoginPage(WebDriver driver) {
        super(driver);
    }

    /*
        Definiujemy metodę przekazująca w parametrze wartość typu String.
        Wykonanie metody spowoduje przekazanie parametru do elementu strony loginPhoneInput oraz kliknięcie loginContinueButton;
     */
    public void loginView(String phone) {
        loginPhoneInput.sendKeys(phone);
        loginContinueButton.click();
    }
}


