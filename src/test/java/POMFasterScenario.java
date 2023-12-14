import Pages.accountInfoPage;
import Pages.finalPage;
import Pages.signupPage;
import Pages.siteHomepage;
import Pages.logedinPage;
import Pages.registerUserAPI;
import com.shaft.driver.SHAFT;
import org.testng.annotations.*;


public class POMFasterScenario {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    private siteHomepage siteHomepage;
    private signupPage signupPage;
    private  finalPage finalPage;
    private  accountInfoPage accountInfoPage;
    private logedinPage logedinPage;
    private registerUserAPI registerUserAPI;


    ///Tests
 /*   @Test
    public void test1() {
        siteHomepage.asserthomepage(testData.getTestData("homepagelink"));
    }
*/
   @Test (description = "registering using API")
    public void testRegistrationAPI() {
        String timeUpdatedUsername = testData.getTestData("signupPage.Name")+"API"+System.currentTimeMillis();
        String timeUpdatedEmail = testData.getTestData("signupPage.Email")+"API"+System.currentTimeMillis();
        String passwordTestData = testData.getTestData("accountInfoPage.form.password");
        //
        //signup***********************************
        registerUserAPI.registerAPI(timeUpdatedUsername,timeUpdatedEmail,passwordTestData);
        //siteHomepage.navigateToHomePage();
        siteHomepage.pressonSignup();
        //
        signupPage.fillLoginFormSubmit(timeUpdatedEmail,passwordTestData);
        //
        logedinPage.assertloggedInuser(timeUpdatedUsername,timeUpdatedUsername);
        //logedinPage.logout();
    }

    @Test (description = "registering using UI")
    public void testRegistrationGUI() {
        //siteHomepage.navigateToHomePage();
        siteHomepage.pressonSignup();
        signupPage.assertSignUppage(testData.getTestData("signupPage.title"));
        //
        String timeUpdatedEmail = testData.getTestData("signupPage.Email")+System.currentTimeMillis();
        String name = testData.getTestData("signupPage.Name");
        signupPage.fillSignupFormandSubmit(name, timeUpdatedEmail);
        //
        accountInfoPage.assertEnterAccountInfoPage(testData.getTestData("accountInfoPage.title"));
        accountInfoPage.fillAccountInfoForm(testData.getTestData("accountInfoPage.form.password"), testData.getTestData("accountInfoPage.form.Day"),
                testData.getTestData("accountInfoPage.form.Month"), testData.getTestData("accountInfoPage.form.Year"),
                testData.getTestData("accountInfoPage.form.FirstName"), testData.getTestData("accountInfoPage.form.LastName"),
                testData.getTestData("accountInfoPage.form.Company"), testData.getTestData("accountInfoPage.form.Address1"),
                testData.getTestData("accountInfoPage.form.Address2"), testData.getTestData("accountInfoPage.form.Country"),
                testData.getTestData("accountInfoPage.form.State"), testData.getTestData("accountInfoPage.form.City"),
                testData.getTestData("accountInfoPage.form.Zipcode"), testData.getTestData("accountInfoPage.form.mobileNumber"));
        finalPage.assertsuccess(testData.getTestData("accountInfoPage.FianlPageTitle"));
        finalPage.pressContinueButton();
        logedinPage.assertloggedInuser(name,name);
        //logedinPage.logout();
    }

    @BeforeMethod
    public void openbrowserNavigateToHomePage() {
        driver = new SHAFT.GUI.WebDriver();
        siteHomepage = new siteHomepage(driver);
        signupPage = new signupPage(driver);
        accountInfoPage= new accountInfoPage(driver);
        finalPage= new finalPage(driver);
        logedinPage = new logedinPage(driver);
        siteHomepage.navigateToHomePage();
        ////////
        testData= new SHAFT.TestData.JSON("src/test/resources/Test Data/TestData.json");

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}