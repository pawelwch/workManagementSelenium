package Pages.HomePageFactory;

import org.openqa.selenium.WebDriver;

/*
klasa HomePage - klasa w której przechowujemy i wykonujemy metody dot. HomePage. Roszerzona jest o klasę HomeWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony;
 */
public class HomePage extends HomeWebElements{

    // Konstruktor HomePage który w parametrze przekazuje zmienna driver która jest obiektem typu WebDriver;
    public HomePage(WebDriver driver) {
        // Konstruktor HomePage, przechowuje metode super(), która pozwala na korzystanie z elementów klasy HomeWebElements;
        super(driver);
    }

//  GoToSignUp - metoda publiczna, która korzysta z elementu(signUpButton) klasy HomeWebElements. Metoda klika button.
    public void GoToSignUp(){
        signUpButton.click();
    }


}
