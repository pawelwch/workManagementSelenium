package Pages.RegisterFactory;

import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.Key;

import static TestMethods.BaseMethods.*;
import static TestMethods.ConfigureMethods.*;


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
        sleep(1000);
        waitForIt(polishPrefix).click();
    }

    public void registerCompletePhone(String phone) {
      waitForIt(registerPhoneInput).sendKeys(phone);
        waitForIt(submitFirstView).click();

    }

    public void confirmSms(String sms) {
        sleep(1000);
        waitForIt(confirmSmsCodeButton).click();
        sleep(2000);
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

    public void setUpAccount_name_email_address(String fullName, String email, String address) {
        waitForIt(this.fullName).sendKeys(fullName);
        waitForIt(this.email).sendKeys(email);
        waitForIt(this.address).sendKeys(address);
    }

    public void setUpAccount_Birth_date(WebElement year, WebElement month, WebElement day) {
        waitForIt(yearInput).click();
        waitForIt(year).click();
        waitForIt(month).click();
        waitForIt(day).click();
    }

    public void setUpAccount_citySelector() {
        waitForIt(citySelector).click();
        waitForIt(firstCityInSelektor).sendKeys("warsz");
        sleep(2000);
        waitForIt(WarsawCity).click();
    }

    /**@param policies jesli ==true, to klika w checkbox z policies, jesli false, to nie.
     * @param messages jesli ==true, to klika w checkbox ze zgodą messeges, jesli false, to nie.
     *                 Metoda dodatkowo kończy się kliknięciem w button Continue */
    public void setUpAccount_policiesAndMessages(boolean policies, boolean messages) {
        if (policies==true) {
            waitForIt(this.policies).click();
        }
        if (messages==true) {
            waitForIt(this.messages).click();
        }
        waitForIt(confirmSetupAccount).click();
    }

    public void moreAboutYou_basicData(WebElement gender, String height, String weight, WebElement bloodType) {
        waitForIt(gender).click();
        waitForIt(this.height).sendKeys(height);
        waitForIt(this.weight).sendKeys(weight);
        waitForIt(bloodType).click();
    }

    /**@param isManual -jeśli jest true, to wpisuje w input wygenerowany losowy ciag znakow. False- wybiera z listy gotowych skilli.
     * @param args -Webelement skilli. Aktywuje się w sytuacji, kiedy isManual==false.  Może generować max do 3 roznych skilli*/
    public void moreAboutYou_skillSet(boolean isManual, WebElement... args){
        waitForIt(skillsets).click();
        if (isManual==true) {
            waitForIt(skillInputTyping).sendKeys(generateRandomString(6));
           waitForIt(skillInputTyping).sendKeys(Keys.ENTER);
        } else {
            try {
                waitForIt(args[0]).click();
                waitForIt(skillsets).click();
                waitForIt(args[1]).click();
                waitForIt(skillsets).click();
                waitForIt(args[2]).click();
            }
            catch (NullPointerException e) {
                waitForIt(height).click(); }
            }
    }

    /**@param isManual -jeśli jest true, to wpisuje w input wygenerowany losowy ciag znakow. False- wybiera z listy gotowych licencji z dropdowna.
     * @param args -Webelement licencji. Aktywuje się w sytuacji, kiedy isManual==false. Może generować max do 3 roznych licencji*/
    public void moreAboutYou_licensesAndCertificates (boolean isManual, WebElement... args) {
        waitForIt(licensesAndCertificates).click();
        if (isManual==true) {
            waitForIt(licensesInputTyping).sendKeys(generateRandomString(6));
            waitForIt(licensesInputTyping).sendKeys(Keys.ENTER);
        } else {
            try {
                waitForIt(args[0]).click();
                waitForIt(licensesAndCertificates).click();
                waitForIt(args[1]).click();
                waitForIt(licensesAndCertificates).click();
                waitForIt(args[2]).click();
                waitForIt(height).click();
            } catch (NullPointerException e) {
                waitForIt(height).click();
            }
        }
    }

    public void moreAboutYou_education(WebElement education) {
        waitForIt(this.education).click();
        waitForIt(education).click();
    }

    /**@param args -wybiera język z listy dostępnych WebElementów w:
     * @see RegisterWebElements Parametr ten, to varargs, wiec moze przyjmować zmienna liczbe argumentów.
     * dodatkowo metoda zamyka się poprzez kliknięciem w przycisk continue */
    public void moreAboutYou_languages (WebElement...args) {
        waitForIt(languages).click();
        try {
            waitForIt(args[0]).click();
            waitForIt(languages).click();
            waitForIt(args[1]).click();
            waitForIt(languages).click();
            waitForIt(args[2]).click();
            waitForIt(languages).click();
            waitForIt(args[3]).click();
            waitForIt(languages).click();
            waitForIt(args[4]).click();
        }catch (NullPointerException e) {
            waitForIt(height).click();
        }
        waitForIt(continueButtonMoreAboutU).click();
    }

    public void photoUpload (String action) {
        sleep(2000);
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
