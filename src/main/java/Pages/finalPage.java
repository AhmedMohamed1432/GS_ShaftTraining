package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class finalPage {
    private SHAFT.GUI.WebDriver driver;
    private final By accountPageTitle= By.xpath("//b[contains(text(),\"Account Created\")]");
    public finalPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void assertAccountCreated(String expectedResult){
        driver.element().assertThat(accountPageTitle).text().isEqualTo(expectedResult).perform();
    }
}
