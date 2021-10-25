import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.CreatedOffersFactory.CreatedOffersPage;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import RestAPI.REST_Methods;
import TestCaseBuilders.Jobs;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static TestMethods.ConfigureMethods.browserPicker;

/**Klasa JobsTC przechowuje TestCasy wraz z adnotacjami dotyczącymi wykonywania testów;*/
public class JobsTest extends Jobs {

    /**Konstruktor klasy JobsTC, który przechowuje w parametrze zmienną driver, która jest obiektu typu WebDriver;*/
    public JobsTest() {
        PageFactory.initElements(driver, this);
    }

    /**Adnotacja @BeforeClass ustawia różne konfigurację które będą wykonane przez wykonaniem każdego testu;
     Adnotacja odnosi się do metody setUpBrowser(), która setupuje Driver w odpowiedni sposób;
     */
    @BeforeClass()
    private void setUpBrowser() {
        JsonParser.parseJson();
        JsonParser_Notification.parseJson();
        jsonParser = new JsonParser();
       // jsonParser_notification = new JsonParser_Notification();
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
    void createJob_SUCCESS() {
        addJob_SUCCESS();
    }

    @Test
    void createJobWithoutTitle(){
        withoutTitleJob();
    }

    @Test
    void createJobWithoutDescription(){
        withoutDescriptionJob();
    }

    @Test
    void createJobWithoutLocationJob(){
        withoutLocationJob();
    }

    @Test
    void createJobWithoutStartDateJob(){
        withoutStartDateJob();
    }

    @Test
    void createJobWithoutEndDateJob(){
        withoutEndDateJob();
    }

    @Test
    void createJobWithoutEmploymentType(){
        withoutEmploymentType();
    }

    @Test
    void createJobWithoutMinNumberOfWorkers(){
        withoutMinNumberOfWorkers();
    }

    @Test
    void createJobWithoutMinWage(){
        withoutMinWage();
    }

    @Test
    void createJobWithoutMaxWage(){
        withoutMaxWage();
    }

    @Test
    void createJobWithoutPaymentFrequency(){
        withoutPaymentFrequency();
    }

    @Test
    void createJobMinWageIsBiggerThanMaxWage(){
        minWageIsBiggerThanMaxWage();
    }





}
