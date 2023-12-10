package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class siteHomepage {
    private SHAFT.GUI.WebDriver driver;

    String sitehomePageURL= "https://automationexercise.com/";

    // Locators
    private final By signupButton = By.xpath("//i[@class=\"fa fa-lock\"]");

    public siteHomepage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public void navigateToHomePage() {
        driver.browser().navigateToURL(sitehomePageURL);
    }
    public void pressonSignup() {
        driver.element().click(signupButton);
    }
    public void asserthomepage(String expecteResult){
        driver.browser().assertThat().url().isEqualTo(expecteResult);
    }

}
