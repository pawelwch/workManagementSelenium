package Pages.RegisterFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterWebElements {

  protected WebDriver driver;

    @FindBy(xpath = "//*[@type='tel']") WebElement phoneInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div/button") WebElement submitFirstView;
    @FindBy(xpath = "//*[@href='/log-in']") WebElement logInButton;

    RegisterWebElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
