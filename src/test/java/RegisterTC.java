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
public class RegisterTC extends Register {


    /**Konstruktor klasy RegisterTC, który przechowuje w parametrze zmienną driver, która jest obiektu typu WebDriver;*/
    public RegisterTC() {
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
    @Test void RegisterAsLabourer_SUCCESS() { register(labourer); }

    @Test void RegisterAsContractor_SUCCESS() { register(contractor); }

    @Test void RegisterAsEmployer_SUCCESS() { register(employer); }

    @Test void AddOffer_SUCCESS () {}

    @Test void SignUpWithNoPhoneNumber() {
        signUp_WithNoPhoneNumber();
    }

    @Test void SignUpWithTooManyPhoneDigits() {
        signUp_WithTooManyPhoneDigits();
    }

    @Test void SignUpWithTooLittlePhoneDigits() {
        signUp_WithTooLittlePhoneDigits();
    }

    @Test void SignUpWithLettersInPhoneInput() {
        signUp_WithLettersInPhoneInput();
    }

    @Test void SignUpWithSuperLongPassword() {
        signUp_WithSuperLongPassword();
    }

    @Test void SignUpWithTooShortPasswordCode() {
        signUp_WithTooShortPassword();
    }

    @Test void SignUpPasswordsAreNotTheSame() { signUp_PasswordsAreNotTheSame(); }

    @Test void OnlyFirstPasswordFilledOut() {
        signUp_WithOnlyFirstPasswordFilledOut();
    }

    @Test void OnlySecondPasswordFilledOut() {
        signUp_WithOnlySecondPasswordFilledOut();
    }

    @Test void EmptyPasswordFields() {
        signUp_WithEmptyPasswordFields();
    }

    @Test void SignUpWithoutGender(){
        signUp_WithoutGender();
    }

    @Test void SignUptWithoutFullNameField() {
        signUp_WithoutFullName();
    }

    @Test void SignUpWithoutDateOfBirth() {
        signUp_WithoutDateOfBirth();
    }

    @Test void SignUpWithoutCity() {
        signUp_WithoutCity();
    }

    @Test void SignUpWithoutAddress() {
        signUp_WithoutAddress();
    }

    @Test void SignUpWithoutPolicies() {
        signUp_WithoutPolicies();
    }

    @Test void SignUpWithoutMoreAboutYourself() {
        signUp_WithoutMoreAboutYourself();
    }

    @Test void SignUpWithoutHeightAndWeight(){
        signUp_withoutHeightAndWeight();
    }

    @Test void SignUpWithoutSkillsets(){
        signUp_withoutSkillsets();
    }

    @Test void SignUpLicensesAndCertificates(){
        signUp_withoutLicensesAndCertificates();
    }

    @Test void SignUpWithoutEducation(){
        signUp_withoutEducation();
    }

    @Test void SignUpWithoutLanguages(){
        signUp_withoutLanguages();
    }

    @Test void SignUpWithoutBiography(){
        signUp_withoutBiography();
    }

    @Test void SignUpWithoutProfilePicture() {
        signUp_WithoutProfilePicture();
    }

    @Test void SignUpWithJPGProfilePicture() {
        signUp_WithJpgProfilePicture();
    }

    @Test void PNGProfilePicture() {
        signUp_WithPngProfilePicture();
    }

    @Test void DocumentsUploadOnlyWithIdCard() {
        signUp_DocumentsUploadedOnlyWithIdCard();
    }

    @Test void DocumentsUploadOnlyWithCertificates() {
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
