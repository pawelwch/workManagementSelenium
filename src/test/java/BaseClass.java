import JsonData.JsonParser;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static TestMethods.BaseMethods.*;
import static TestMethods.ConfigureMethods.browserPicker;
import static TestMethods.ConfigureMethods.sleep;

/**Klasa BaseClass przechowuje TestCasy wraz z adnotacjami dotyczącymi wykonywania testów;*/
public class BaseClass extends Base {


    /**Konstruktor klasy BaseClass, który przechowuje w parametrze zmienną driver, która jest obiektu typu WebDriver;*/
    public BaseClass () {
        PageFactory.initElements(driver, this);
    }

    /**Adnotacja @BeforeClass ustawia różne konfigurację które będą wykonane przez wykonaniem każdego testu;
    Adnotacja odnosi się do metody setUpBrowser(), która setupuje Driver w odpowiedni sposób;
    */
    @BeforeClass (alwaysRun = true)
    private void setUpBrowser() {
        JsonParser.parseJson();
        jsonParser = new JsonParser();
        baseMethods = new BaseMethods();
        configureMethods = new ConfigureMethods(driver);
        driver = browserPicker();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);

    }

     /**Adnotacja @BeforeMethod ustawia rózne konfiguracje które będą wykokane przed wykonaniem każdej metody;
     Adnotacja odnosi się do metody setUp(), która setpuje Driver w odpowiedni sposób;
     */
    @BeforeMethod (alwaysRun =  true)
    void setUp(){
        driver.get("http://18.196.86.213:3005/");
    }

    /**Adnotacja @Test jest to konkretny TestCase;
    Adnotacja odnosi się do wykonania konkretnej metody odpowiadjącej konkretnemu TestCase;
    */
    @Test
    void Test1 () {
        homePage.GoToSignUp();
        registerPage.firstViewRegister(generatePhoneNumber());
    }

     /**Adnotacja @AfterClass ustawia różne konfiguracje, które będą wykonane po wykonaniu każdego testu;
     W tym przypadku adnotacja odnosi się do metody turnDown(), która powoduje zamknięcie Drivera;
     */
    @AfterTest
    void turnDown () {
        sleep(5000);
        driver.close();
    }

}
