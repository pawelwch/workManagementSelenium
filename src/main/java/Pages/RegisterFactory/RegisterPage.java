package Pages.RegisterFactory;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends RegisterWebElements{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void firstViewRegister(String phone) {
        phoneInput.sendKeys(phone);
    }

}
