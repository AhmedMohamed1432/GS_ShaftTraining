package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class signupPage {
    private SHAFT.GUI.WebDriver driver;
    private final By signupPageTitle = By.xpath("//h2[contains(text(),\"New User\")]");
    private final By nameField = By.xpath("//input[@name=\"name\"]");
    private final By emailField = By.xpath("//input[@data-qa= \"signup-email\"]");
    private final By submitSignUpButton = By.xpath("//button[@data-qa= \"signup-button\"]");
    ////////////
    private final By loginNameField = By.xpath("//input[@data-qa= \"login-email\"]");
    private final By loginPasswordField= By.xpath("//input[@data-qa= \"login-password\"]");
    private final By submitLoginButton = By.xpath("//button[@data-qa= \"login-button\"]");

    public signupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void fillSignupFormandSubmit(String Name, String Email){
        driver.element().type(nameField,Name);
        driver.element().type(emailField,Email);
        driver.element().click(submitSignUpButton);
    }
    public void assertSignUppage(String expecteResult){
        driver.element().assertThat(signupPageTitle).text().isEqualTo(expecteResult);
    }
    public void fillLoginFormSubmit(String Name, String Password){
        driver.element().type(loginNameField,Name);
        driver.element().type(loginPasswordField,Password);
        driver.element().click(submitLoginButton);
    }


}
