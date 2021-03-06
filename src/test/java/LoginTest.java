import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import RestAPI.REST_Methods;
import TestCaseBuilders.Login;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static TestMethods.ConfigureMethods.browserPicker;
import static TestMethods.ConfigureMethods.sleep;

/**Klasa LoginTC przechowuje TestCasy wraz z adnotacjami dotyczącymi wykonywania testów;*/
public class LoginTest extends Login{

    /**Konstruktor klasy LoginTC, który przechowuje w parametrze zmienną driver, która jest obiektu typu WebDriver;*/
    public LoginTest() {
        PageFactory.initElements(driver, this);
    }

    /**Adnotacja @BeforeClass ustawia różne konfigurację które będą wykonane przez wykonaniem każdego testu;
     Adnotacja odnosi się do metody setUpBrowser(), która setupuje Driver w odpowiedni sposób;
     */
    @BeforeClass ()
    private void setUpBrowser() {
        JsonParser.parseJson();
        JsonParser_Notification.parseJson();
        jsonParser = new JsonParser();
        jsonParser_notification = new JsonParser_Notification();
        baseMethods = new BaseMethods();
        configureMethods = new ConfigureMethods(driver);
        driver = browserPicker("chrome");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        rest_methods = new REST_Methods();
    }

    /**Adnotacja @BeforeMethod ustawia rózne konfiguracje które będą wykokane przed wykonaniem każdej metody;
     Adnotacja odnosi się do metody setUp(), która setpuje Driver w odpowiedni sposób;
     */
    @BeforeMethod(alwaysRun =  true)
    void setUp(){
        driver.manage().deleteAllCookies();
        driver.get("https://aws.lm-l4a-soft.ninja:3101/");
//        setUpUser(REST_Methods.DataEnum.labourer);
    }

    /**Adnotacja @Test jest to konkretny TestCase;
     Adnotacja odnosi się do wykonania konkretnej metody odpowiadjącej konkretnemu TestCase;
     */
    @Test
    void login_SUCCES(){
        login_SUCCESS();
    }

    @Test
    void login_EmptyPhoneNumberInput(){
        login_emptyPhoneNumberInput();
    }

    @Test
    void login_TooShortPhoneNumber(){
        login_tooShortPhoneNumber();
    }

    @Test
    void login_IncorrectPassword(){
        login_incorrectPassword();
    }

    @Test
    void login_EmptyPasswordInput(){
        login_emptyPasswordInput();
    }


    @AfterMethod(alwaysRun = true)
    void clearLastTestCase () {
        driver.manage().deleteAllCookies();
    }

    /**Adnotacja @AfterTest ustawia różne konfiguracje, które będą wykonane po wykonaniu każdego testu;
     W tym przypadku adnotacja odnosi się do metody turnDown(), która powoduje zamknięcie Drivera;
     */
    @AfterTest(alwaysRun = true)
    void turnDown () {
        sleep(1000);
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
