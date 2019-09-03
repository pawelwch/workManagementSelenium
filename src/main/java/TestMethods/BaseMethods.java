package TestMethods;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Random;

public class BaseMethods {


    public static ConfigureMethods configureMethods;
    static private Random random = new Random();
    static private StringBuilder stringBuilder = new StringBuilder();
    private final static char [] chars = "abcdefghijklmnoprstuwxyz".toCharArray();
    private final static char [] numbers = "1234567890".toCharArray();
    static ExtentTest test;

    /** Metoda generuje losowe Stringi
     * @param length podajemy dlugosc danego lancucha
     * @return zwraca losowy ciag znaków. Przydatne podczas uzupelniania takich danych jak Imie czy Nazwisko */
    public static String generateRandomString (int length) {
        for (int i=0; i<length; i++) {
            stringBuilder.append(chars[random.nextInt(length)]);
        }
        return stringBuilder.toString();
    }

    /**Generuje losowy ciąg liczb.
     * @param length Wpisujemy liczbe ciągu liczb. np wpisując "2", wypluje jakaś dwucyfrową liczbe
     * @return zwraca liczbe jako String */
    public static String generateRandomNumber (int length) {
        String number = (RandomStringUtils.randomNumeric(length));
        return number;
    }

    /**Metoda, ktora generuje 9cyfrowy numer telefonu, zaczynajacy sie na "1". Ze względów bezpieczeństwa
     * @return zwraca numer telefonu */
    public static String generatePhone() {
        String number = (RandomStringUtils.randomNumeric(9));
        return number;
    }

    /** Metoda generuje losowy adress email.
     * @return  zwraca adress email. */
    public static String generateRandomEmail() {
        String email = (RandomStringUtils.randomAlphabetic(7));
        return email+"@test.com";
    }


    /**Metoda porownująca komunikat, tekst zawarty w pliku json, do rzeczywistego tekstu/komunikatu na stronie
     * @param webElement nalezy podac webElement, kory zawiera tekst/ tlumaczenie
     * @param text nalezy podac klucz tekstu, ktory chcemy sprawdzic */
    public static void checkNotify (WebElement webElement, String text) {
        String webText = configureMethods.waitForIt(webElement).getText().toString();
        Assert.assertEquals(webText, text);
    }

    /**Metoda klika na przycisk akceptacji (sumbit), na każdej stronie, która taki przycisk posiada.
     * @param element id przycisku submit.*/
    public static void submitButton(WebElement element) {
        configureMethods.waitForIt(element).submit();
    }


    /**Metoda za pomocą które klikamy w "ciało" strony aby odfocusować pole/input
     *
     * @param body parametr odnosi sie do WebElementu body
     */
    public void clickSomewhere(WebElement body){
        body.click();
    }

}
