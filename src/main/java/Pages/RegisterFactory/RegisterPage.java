package Pages.RegisterFactory;

import TestMethods.ConfigureMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static TestMethods.ConfigureMethods.sleep;
import static TestMethods.ConfigureMethods.waitForIt;


/**klasa RegisterPage - klasa w której przechowujemy i wykonujemy metody dot. RegisterPage. Roszerzona jest o klasę RegisterWebElements,
dzięki której będziemy się odwoływać do poszczególnych elementów strony.
 */
public class RegisterPage extends RegisterWebElements{

    /** Metoda przekazująca w parametrze zmienna driver która jest obiektu typu WebDriver. Metoda super() powoduje wywołanie konstruktora klasy nadrzędnej.
    W tym przypadku metoda RegisterPage korzysta z konstruktora utworzonego w klasie RegisterWebElements;
     */
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    /**Definiujemy metodę przekazująca w parametrze wartość typu String.
        Wykonanie metody z parametrem spowoduje przekazanie parametru do elementu strony registerPhoneInput oraz kliknięcie submitFirstView;
     */
    public void selectCountry() {
        sleep(1000);
        waitForIt(countrySelector).click();
        waitForIt(polishPrefix).click();
    }

    public void registerCompletePhone(String phone) {
      waitForIt(registerPhoneInput).sendKeys(phone);
        waitForIt(submitFirstView).click();

    }

    public void confirmSms(String sms) {
//        waitForIt(smsInput).sendKeys(sms);
        sleep(1000);
        waitForIt(confirmSmsCodeButton).click();
    }

    public void setPinView(String pin1, String pin2) {
        waitForIt(firstPinInput).sendKeys(pin1);
        waitForIt(secondPinInput).sendKeys(pin2);
        sleep(1500);
        waitForIt(pinConfirmButton).click();
    }

    public void accountTypeSelector(WebElement accountType) {
        waitForIt(accountType).click();
    }


    //selektory z datą do zparametryzowania.
    public void setUpAccount(String fullName, String email,String year, String month, String day, String address, boolean policies, boolean messages) {
        waitForIt(this.fullName).sendKeys(fullName);
        waitForIt(this.email).sendKeys(email);
        waitForIt(yearInput).click();
        waitForIt(year2000).click();
        waitForIt(month1).click();
        waitForIt(day20).click();
        waitForIt(citySelector).click();
        waitForIt(firstCityInSelektor).sendKeys("warsz");
        waitForIt(WarsawCity).click();
        waitForIt(this.address).sendKeys(address);
        if (policies==true) {
            waitForIt(this.policies).click();
        }
        if (messages==true) {
            waitForIt(this.messages).click();
        }
        waitForIt(confirmSetupAccount).click();
    }

    public void moreAboutYourselfView(WebElement gender, String height, String weight, WebElement bloodType) {
        waitForIt(gender).click();
        waitForIt(this.height).sendKeys(height);
        waitForIt(this.weight).sendKeys(weight);
        waitForIt(bloodType).click();
        waitForIt(skillsets).click();
        waitForIt(skillExcell).click();
        waitForIt(gender).click();
        waitForIt(licensesAndCertificates).click();
        waitForIt(licenseOne).click();
        waitForIt(education).click();
        waitForIt(educationVol1).click();
        waitForIt(languages).click();
        waitForIt(languageEnglish).click();
        waitForIt(continueButtonMoreAboutU).click();
        sleep(2000);
    }

    public void photoUpload (String action) {
        switch (action) {
            case "skip":
                waitForIt(skipButton).click();
                break;
            case "browser":
                waitForIt(browserGallery).click();
                break;
            case "takePhoto":
                waitForIt(takeAPhoto).click();
                break;
        }
    }

    public void documentsUploadView (String uploadIdCard, String uploadCertificates, String idCard) {
        waitForIt(this.uploadIdCard).click();
        waitForIt(this.uploadCertificates).click();
        waitForIt(this.uploadIdCard).sendKeys(idCard);
    }





}
