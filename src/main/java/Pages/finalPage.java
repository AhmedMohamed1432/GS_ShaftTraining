package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class finalPage {
    private SHAFT.GUI.WebDriver driver;
    private final By accountPageTitle= By.xpath("//b[contains(text(),\"Account Created\")]");
    private final By accountContinueButton = By.xpath("//a[contains(text(),\"Continue\")]");
    public finalPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void assertsuccess(String expectedResult){
        driver.element().assertThat(accountPageTitle).text().isEqualTo(expectedResult).perform();
    }
    public void pressContinueButton(){
        driver.element().click(accountContinueButton);
    }

}
