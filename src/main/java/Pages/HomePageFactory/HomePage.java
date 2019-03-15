package Pages.HomePageFactory;

import org.openqa.selenium.WebDriver;

/*
klasa HomePage - klasa w której przechowujemy i wykonujemy metody dot. HomePage. Roszerzona jest o klasę HomeWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony.
 */
public class HomePage  extends HomeWebElements{

    public HomePage(WebDriver driver) {
        super(driver);
    }
/*
GoToSignUp - metoda publiczna, która korzysta z elementu(signUpButton) klasy HomeWebElements. Metoda klika button.
 */
    public void GoToSignUp(){
        signUpButton.click();
    }


}
