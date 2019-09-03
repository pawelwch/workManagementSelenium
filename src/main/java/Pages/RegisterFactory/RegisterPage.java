package Pages.RegisterFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void logIn () {
        waitForIt(logInButton).click();
    }

    public void selectCountry() {
        waitForIt(countrySelector).click();
        sleep(1000);
        configureMethods.scroolToTheSomePoint(polishPrefix);
        sleep(1000);
        waitForIt(polishPrefix).click();
    }

//    public void selectCountry() {
//        sleep(1000);
//        waitForIt(countrySelector).click();
//        Select countryDropDown = new Select(countrySelector);
//        countryDropDown.selectByValue("Poland");
//    }

    public void registerCompletePhone(String phone) {
        waitForIt(registerPhoneInput).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));
        waitForIt(registerPhoneInput).sendKeys(phone);

    }

    public void confirmSms(String sms) {
        waitForIt(resendSmsCodeButton).click();
        String  number = waitForIt(sixthNumberOfSmsCode).getAttribute("value");
        waitForIt(sixthNumberOfSmsCode).clear();
        waitForIt(sixthNumberOfSmsCode).sendKeys(number);
    }

    public void setPinView(String pin1, String pin2) {
        waitForIt(firstPinInput).sendKeys(pin1);
        waitForIt(secondPinInput).sendKeys(pin2);
    }

    public String checkDisableButton (WebElement disableButton) {
        String isDisable = waitForIt(disableButton).getAttribute("disabled");
        System.out.println(isDisable);
        return isDisable;
    }

    public void accountTypeSelector(WebElement accountType) {
        waitForIt(accountType).click();
    }

    public void setUpAccount_gender(WebElement gender){
        waitForIt(gender).click();
    }

    public void setUpAccount_name_email_address(String fullName, String email, String address) {
        waitForIt(this.fullName).sendKeys(fullName);
        waitForIt(this.email).sendKeys(email);
        waitForIt(this.address).sendKeys(address);
    }

//    public void setUpAccount_Birth_date(WebElement year, WebElement month, WebElement day) {
//        waitForIt(yearInput).click();
//        waitForIt(year).click();
//        waitForIt(month).click();
//        waitForIt(day).click();
//    }

    public void setUpAccount_Birth_date(String dayOfBirth){
        waitForIt(dayOfBirthInput).sendKeys(dayOfBirth);
    }

    public void setUpAccount_countrySelector() {
        waitForIt(countryInput).click();
        sleep(1000);
        System.out.println(countryInput.isEnabled());
        System.out.println(countryInput.isDisplayed());
        waitForIt(countryInput).sendKeys("Polan");
        waitForIt(firstCountryInSelector).click();
    }

    public void setUpAccount_citySelector(String country) {
        waitForIt(cityInput).click();
        waitForIt(cityInput).sendKeys(country);
        waitForIt(firstCityChoice).click();
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
    }

    public void confirm_SetUpAccount () {
        waitForIt(confirmSetupAccount).click();
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
    }

    public void confirm_moreAboutYou () {
        waitForIt(continueButtonMoreAboutU).click();
    }

    public void photoUpload (String action, String photoPath) {
        sleep(1000);
        switch (action) {
            case "skip":
                waitForIt(skipButton).click();
                break;
            case "browser":
                uploadPhoto.sendKeys(photoPath);
                sleep(2000);
                waitForIt(savePhoto).click();
                break;
            case "takePhoto":
                waitForIt(takeAPhoto).click();
                break;
        }
    }

    public void uploadIdCard (String idCardPath, String nextFile) {
        sleep(1000);
        uploadIdCard.sendKeys(idCardPath);
        addNextFile.sendKeys(nextFile);
        waitForIt(submitCardId).click();
    }

    public void uploadCertificates (String CertificatesPath, String nextFile) {
        sleep(1000);
        uploadCertificates.sendKeys(CertificatesPath);
        addNextFile.sendKeys(nextFile);
        waitForIt(submitCardId).click();
    }

    public void idNumber (String idNumber) {
        sleep(1000);
        waitForIt(this.idNumber).sendKeys(idNumber);
    }

    public void continueDocumetsUploadButton () {
        sleep(2000);
        waitForIt(continueDocumentsUpload).click();
    }

}
