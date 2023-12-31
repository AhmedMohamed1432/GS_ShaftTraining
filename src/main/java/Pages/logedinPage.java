package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class logedinPage {
    private SHAFT.GUI.WebDriver driver;
    private final By accountLogoutButton = By.xpath("//a[contains(text(),\" Logout\")]");


    public logedinPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void assertloggedInuser(String username, String expectedResult){
        By usernameLoggedinElement = By.xpath("//b[contains(text(),\""+username+"\")]");
        driver.element().assertThat(usernameLoggedinElement).text().isEqualTo(expectedResult).perform();

    }
    public void logout(){
        driver.element().click(accountLogoutButton);

    }

}
