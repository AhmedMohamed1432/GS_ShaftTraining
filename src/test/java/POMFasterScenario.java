import Pages.accountInfoPage;
import Pages.finalPage;
import Pages.signupPage;
import Pages.siteHomepage;
import Pages.logedinPage;
import Pages.registerUserAPI;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class POMFasterScenario {

    SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
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
    @Test
    public void test2() {
        String usernamtestData ="Ahmed90905";
        String emailTestDaata="ahmed8080805@gmail.com";
        String passwordTestData = "asdfghjkl123";
        //
        //signup***********************************
        registerUserAPI.registerAPI(usernamtestData,emailTestDaata,passwordTestData);
        siteHomepage.navigateToHomePage();
        siteHomepage.pressonSignup();
        //
        signupPage.fillLoginFormSubmit(emailTestDaata,passwordTestData);
        //
        logedinPage.assertloggedInuser(usernamtestData,usernamtestData);
        logedinPage.logout();
    }
    @Test
    public void test3() {
        siteHomepage.navigateToHomePage();
        siteHomepage.pressonSignup();
        signupPage.assertSignUppage(testData.getTestData("signupPage.title"));
        //
        signupPage.fillSignupFormandSubmit(testData.getTestData("signupPage.Name"), testData.getTestData("signupPage.Email")+System.currentTimeMillis());
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
        logedinPage.logout();
    }

    @BeforeClass
    public void openbrowserNavigateToHomePage() {

        siteHomepage = new siteHomepage(driver);
        signupPage = new signupPage(driver);
        accountInfoPage= new accountInfoPage(driver);
        finalPage= new finalPage(driver);
        logedinPage = new logedinPage(driver);
        //siteHomepage.navigateToHomePage();
        ////////
        testData= new SHAFT.TestData.JSON("src/test/resources/Test Data/TestData.json");

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}