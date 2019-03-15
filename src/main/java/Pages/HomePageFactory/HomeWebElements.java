package Pages.HomePageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//  HomeWebElements - definiujemy publiczną klasę która przechowuje elementy widoku HomePage
public class HomeWebElements {


    //  driver - zmienna która przechowuje obiekt typu WebDriver
    protected WebDriver driver;
    /*
    @Findby - adnotacja, która określa konkretną lokalizację obiektu. W tym przypadku adnotacja dotyczy przycisku,
    który jest lokalizowany na stronie i przypisywany do zmiennej signUpButton.
    Alternatywa to: WebElement signUp = driver.findElement(By.xpath(""));
    */
    @FindBy(xpath = "//*[.='Sign up']") WebElement signUpButton;

    HomeWebElements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
