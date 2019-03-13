package Pages.HomePageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWebElements {

    protected WebDriver driver;

        HomeWebElements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
