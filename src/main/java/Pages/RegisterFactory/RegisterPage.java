package Pages.RegisterFactory;

import org.openqa.selenium.WebDriver;


/*
klasa RegisterPage - klasa w której przechowujemy i wykonujemy metody dot. RegisterPage. Roszerzona jest o klasę RegisterWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony.
 */
public class RegisterPage extends RegisterWebElements{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void firstViewRegister(String phone) {
        phoneInput.sendKeys(phone);
        submitFirstView.click();

    }

}
