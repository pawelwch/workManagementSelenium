import Pages.HomePageFactory.HomePage;
import Pages.RegisterFactory.RegisterPage;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static TestMethods.BaseMethods.*;
import static TestMethods.ConfigureMethods.browserPicker;
import static TestMethods.ConfigureMethods.sleep;

public class BaseClass extends Base{

    public BaseClass () {
        PageFactory.initElements(driver, this);
    }


    @BeforeClass
    private void setUpBrowser() {
        baseMethods = new BaseMethods();
        configureMethods = new ConfigureMethods(driver);
        driver = browserPicker("chrome");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }


    @BeforeMethod
    void setUp(){
        driver.get("http://18.196.86.213:3005/");
}

    @Test
    void Test1 () {
        homePage.GoToSignUp();
        registerPage.firstViewRegister(generatePhoneNumber());

}




    @AfterClass
    void turnDown () {
        sleep(5000);
        driver.close();
    }






}
