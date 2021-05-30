package Pages.CreatedOffersFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedOffersWebElements {

    protected WebDriver driver;

    CreatedOffersWebElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a") public static WebElement addNewJobOfferButton;

}
