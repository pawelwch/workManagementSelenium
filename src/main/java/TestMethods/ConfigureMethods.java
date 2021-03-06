package TestMethods;

import JsonData.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.NoSuchElementException;
import java.util.logging.Level;

public class ConfigureMethods {

    private static WebDriver driver;

    public ConfigureMethods (WebDriver driver) {
        this.driver = driver;
    }

    /** Jest to konfiguracja dla Chrome, ktora pozwala wyciagnąć logi z konsoli przeglądarkowej. Nalezy umiescić w
     * @see #browserPicker() () : new ChromeDriver(logCapabilitiesForChrome()) zamiast new ChromeDriver() */
//   public static DesiredCapabilities logCapabilitiesForChrome () {
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.BROWSER, Level.ALL);
//        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//        return caps;
//    }

    /** Metoda która wybiera przeglądarke. Plik konfiguracyjny jest w BagsOff/resources/ConfigFile.json Działa na razie na FF i Chrome.
     * Drivery mozna parametryzować o np metode
     * @return Zwraca podaną przeglądarke */
    public static WebDriver browserPicker (String browser) {
        if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.contains("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    /**to samo co driver.findBy(), tylko czeka, aż element się na pewno pojawi na stronie
     * @param webElement sluzy do podania WebElementu (nie moze to byc typ String, a obiekt WebElement).
     * withTimeout - okresla ile program bedzie czekac na webElement
     * pollingEvery- co ile bedzie ponawiał zapytanie o webElement
     * @return zwraca podany webElement*/
    public static WebElement waitForIt(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }

    /**Wstrzymuje działanie programu na milisekundy
     * @param time podajemy na ile wstrzymujemy program*/
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }


    /** Scrolluje strone do podanego elementu
     * @param element Podajemy webElement do ktorego chcemy scrollowac widok */
    public static void scroolToTheSomePoint(WebElement element) {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**Metoda odpowiedzialna za zrobienie screenShota. Wykorzystywana przy generowaniu raportów
     * @param driver
     * @param screenshotName -Generuje nazwe. Jest to nazwa testowanej metody oraz dokładna data wykonania screena.
     * @return Zwraca ścieżke do wygenerowanego screena. Potrzebne, aby zaimplementować obraz bezpośrednio w raportach.
     * @throws Exception */
    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat(" yyyy-MM-dd hh:mm:ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") +"/Raports/"+ screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

}
