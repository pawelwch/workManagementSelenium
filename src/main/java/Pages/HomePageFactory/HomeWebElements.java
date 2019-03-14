package Pages.HomePageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeWebElements {

    protected WebDriver driver;

    @FindBy(xpath = "//*[.='Sign up']") WebElement signUpButton;

//    WebElement signUp = driver.findElement(By.xpath(""));

        HomeWebElements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
