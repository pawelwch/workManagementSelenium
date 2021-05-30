package Pages.CreatedOffersFactory;

import org.openqa.selenium.WebDriver;

import static TestMethods.ConfigureMethods.waitForIt;

public class CreatedOffersPage extends CreatedOffersWebElements{

    public CreatedOffersPage(WebDriver driver){
        super(driver);
    }

    public void AddNewJobOffer(){
        waitForIt(addNewJobOfferButton).click();
    }
}
