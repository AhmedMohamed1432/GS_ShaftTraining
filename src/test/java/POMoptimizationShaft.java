import Pages.accountInfoPage;
import Pages.finalPage;
import Pages.signupPage;
import Pages.siteHomepage;
import com.shaft.driver.SHAFT;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class POMoptimizationShaft {

    SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
    SHAFT.TestData.JSON testData;
    private siteHomepage siteHomepage;
    private signupPage signupPage;
    private  finalPage finalPage;
    private  accountInfoPage accountInfoPage;



    ///Tests
    @Test
    public void test1() {
        siteHomepage.asserthomepage(testData.getTestData("homepagelink"));
    }

    @Test
    public void test2() {
        siteHomepage.pressonSignup();
        signupPage.assertSignUppage(testData.getTestData("signupPage.title"));
        //
        signupPage.fillSignupFormandSubmit(testData.getTestData("signupPage.Name"), testData.getTestData("signupPage.Email"));
        //
        accountInfoPage.assertEnterAccountInfoPage(testData.getTestData("accountInfoPage.title"));

    }
    @Test
    public void test3(){
        accountInfoPage.fillAccountInfoForm(testData.getTestData("accountInfoPage.form.password"), testData.getTestData("accountInfoPage.form.Day"),
                testData.getTestData("accountInfoPage.form.Month"), testData.getTestData("accountInfoPage.form.Year"),
                testData.getTestData("accountInfoPage.form.FirstName"), testData.getTestData("accountInfoPage.form.LastName"),
                testData.getTestData("accountInfoPage.form.Company"), testData.getTestData("accountInfoPage.form.Address1"),
                testData.getTestData("accountInfoPage.form.Address2"), testData.getTestData("accountInfoPage.form.Country"),
                testData.getTestData("accountInfoPage.form.State"), testData.getTestData("accountInfoPage.form.City"),
                testData.getTestData("accountInfoPage.form.Zipcode"), testData.getTestData("accountInfoPage.form.mobileNumber"));
        finalPage.assertAccountCreated(testData.getTestData("accountInfoPage.FianlPageTitle"));
    }

    @BeforeClass
    public void openbrowserNavigateToHomePage() {

        siteHomepage = new siteHomepage(driver);
        signupPage = new signupPage(driver);
        accountInfoPage= new accountInfoPage(driver);
        finalPage= new finalPage(driver);
        siteHomepage.navigateToHomePage();
        ////////
        testData= new SHAFT.TestData.JSON("src/test/resources/Test Data/TestData.json");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}