import JsonData.JsonParser;
import JsonData.JsonParser_Notification;
import Pages.HomePageFactory.HomePage;
import Pages.LoginFactory.LoginPage;
import Pages.RegisterFactory.RegisterPage;
import RestAPI.REST_Methods;
import TestCaseBuilders.Register;
import TestMethods.BaseMethods;
import TestMethods.ConfigureMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static Pages.RegisterFactory.RegisterWebElements.*;

import static TestMethods.ConfigureMethods.browserPicker;
import static TestMethods.ConfigureMethods.sleep;

/**Klasa RegisterTC przechowuje TestCasy wraz z adnotacjami dotyczącymi wykonywania testów;*/
public class RegisterTest extends Register {


    /**Konstruktor klasy RegisterTC, który przechowuje w parametrze zmienną driver, która jest obiektu typu WebDriver;*/
    public RegisterTest() {
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
        driver.get("https://test.lm.l4a.dev/");
//        setUpUser(REST_Methods.DataEnum.labourer);
    }

    /**Adnotacja @Test jest to konkretny TestCase;
     Adnotacja odnosi się do wykonania konkretnej metody odpowiadjącej konkretnemu TestCase;
     */
    @Test void registerAsLabourer_SUCCESS() { register(labourer); }

    @Test void registerAsContractor_SUCCESS() { register(contractor); }

    @Test void registerAsEmployer_SUCCESS() { register(employer); }


    @Test void signUpWithNoPhoneNumber() {
        signUp_WithNoPhoneNumber();
    }

//    @Test void SignUpWithTooManyPhoneDigits() {
//        signUp_WithTooManyPhoneDigits();
//    }

    @Test void signUpWithTooLittlePhoneDigits() {
        signUp_WithTooLittlePhoneDigits();
    }

    @Test void signUpWithLettersInPhoneInput() {
        signUp_WithLettersInPhoneInput();
    }

    @Test void signUpWithSuperLongPassword() {
        signUp_WithSuperLongPassword();
    }

    @Test void signUpWithTooShortPasswordCode() {
        signUp_WithTooShortPassword();
    }

    @Test void signUpPasswordsAreNotTheSame() { signUp_PasswordsAreNotTheSame(); }

    @Test void onlyFirstPasswordFilledOut() {
        signUp_WithOnlyFirstPasswordFilledOut();
    }

    @Test void onlySecondPasswordFilledOut() {
        signUp_WithOnlySecondPasswordFilledOut();
    }

    @Test void emptyPasswordFields() {
        signUp_WithEmptyPasswordFields();
    }

    @Test void signUpWithoutGender(){
        signUp_WithoutGender();
    }

    @Test void signUptWithoutFullNameField() {
        signUp_WithoutFullName();
    }

    @Test void signUpWithoutDateOfBirth() {
        signUp_WithoutDateOfBirth();
    }

    @Test void signUpWithoutCity() {
        signUp_WithoutCity();
    }

    @Test void signUpWithoutAddress() {
        signUp_WithoutAddress();
    }

    @Test void signUpWithoutPolicies() {
        signUp_WithoutPolicies();
    }

    @Test void signUpWithoutMoreAboutYourself() {
        signUp_WithoutMoreAboutYourself();
    }

    @Test void signUpWithoutHeightAndWeight(){
        signUp_withoutHeightAndWeight();
    }

    @Test void signUpWithoutSkillsets(){
        signUp_withoutSkillsets();
    }

    @Test void signUpLicensesAndCertificates(){
        signUp_withoutLicensesAndCertificates();
    }

    @Test void signUpWithoutEducation(){
        signUp_withoutEducation();
    }

    @Test void signUpWithoutLanguages(){
        signUp_withoutLanguages();
    }

    @Test void signUpWithoutBiography(){
        signUp_withoutBiography();
    }

    @Test void signUpWithoutProfilePicture() {
        signUp_WithoutProfilePicture();
    }

    @Test void signUpWithJPGProfilePicture() throws Exception{
        signUp_WithJpgProfilePicture();
    }

    @Test void signUpWithPNGProfilePicture() throws Exception {
        signUp_WithPngProfilePicture();
    }

    @Test void documentsUploadOnlyWithIdCard() {
        signUp_DocumentsUploadedOnlyWithIdCard();
    }

    @Test void documentsUploadOnlyWithCertificates() {
        signUp_DocumentsUploadedOnlyWithCertificates();
    }


    @AfterMethod (alwaysRun = true)
    void clearLastTestCase () {
        driver.manage().deleteAllCookies();
    }

    /**Adnotacja @AfterTest ustawia różne konfiguracje, które będą wykonane po wykonaniu każdego testu;
     W tym przypadku adnotacja odnosi się do metody turnDown(), która powoduje zamknięcie Drivera;
     */
    @AfterTest (alwaysRun = true)
    void turnDown () {
        sleep(1000);
        driver.manage().deleteAllCookies();
        driver.quit();

    }

}
