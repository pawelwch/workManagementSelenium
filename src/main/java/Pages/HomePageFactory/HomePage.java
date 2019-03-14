package Pages.HomePageFactory;

import org.openqa.selenium.WebDriver;

public class HomePage  extends HomeWebElements{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void GoToSignUp(){
        signUpButton.click();
    }


}
