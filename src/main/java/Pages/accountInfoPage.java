package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class accountInfoPage {
    private SHAFT.GUI.WebDriver driver;
    private final By accountInfopageTitle = By.xpath("//b[contains(text(),\"Enter Account\")]");
    private final By accountGender = By.id("id_gender1");
    private final By accountPassword= By.id("password");
    private final By daysDate=By.id("days");
    private final By monthsDate=By.id("months");
    private final By yearsDate= By.id("years");
    private final By newsLetter=By.id("newsletter");
    private final By option=By.id("optin");
    private final By firstName=By.id("first_name");
    private final By lastName=By.id("last_name");
    private final By companyName=By.id("company");
    private final By address1Name=By.id("address1");
    private final By address2Name=By.id("address2");
    private final By countryList=By.id("country");
    private final By stateName=By.id("state");
    private final By cityName=By.id("city");
    private final By zipcodeName=By.id("zipcode");
    private final By mobileNumber=By.id("mobile_number");
    private final By submitButton= By.xpath("//button[contains(text(),\"Create Account\")]");
    public accountInfoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void fillAccountInfoForm(String password, String Day, String month, String year, String firstname,
                                    String lastname, String company, String address1, String address2,
                                    String country, String state, String city, String zipcode, String mobilenumber){
        driver.element().click(accountGender);
        driver.element().type(accountPassword, password);
        driver.element().select(daysDate, Day);
        driver.element().select(monthsDate, month);
        driver.element().select(yearsDate, year);
        driver.element().click(newsLetter);
        driver.element().click(option);
        driver.element().type(firstName, firstname);
        driver.element().type(lastName, lastname);
        driver.element().type(companyName, company);
        driver.element().type(address1Name, address1);
        driver.element().type(address2Name, address2);
        driver.element().select(countryList, country);
        driver.element().type(stateName, state);
        driver.element().type(cityName, city);
        driver.element().type(zipcodeName, zipcode);
        driver.element().type(mobileNumber, mobilenumber);
        driver.element().click(submitButton);
    }
    public void assertEnterAccountInfoPage(String expectedResult){
        driver.element().assertThat(accountInfopageTitle).text().isEqualTo(expectedResult).perform();
    }
}
