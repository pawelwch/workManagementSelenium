package Pages.ProfileFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfileWebElements {

    protected WebDriver driver;

    public ProfileWebElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
