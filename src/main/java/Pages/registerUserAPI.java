package Pages;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import java.util.Arrays;
import java.util.List;

public class registerUserAPI {

    //private String registerUrl= "https://automationexercise.com";
    static SHAFT.API api = new SHAFT.API(siteHomepage.sitehomePageURL);
    static String createAccountService= "api/createAccount";
    private static final int success_statusCode= 200;
    public static void registerAPI(String username, String email, String pass){
        List <List<Object>> formInputs = Arrays.asList(
                Arrays.asList("name", username),
                Arrays.asList("email", email),
                Arrays.asList("password", pass),
                Arrays.asList("title", "Mr."),
                Arrays.asList("birth_date", "04"),
                Arrays.asList("birth_month", "sep"),
                Arrays.asList("birth_year", "1999"),
                Arrays.asList("firstname", username),
                Arrays.asList("lastname", username),
                Arrays.asList("company", "company"),
                Arrays.asList("address1", "address1"),
                Arrays.asList("address2", "address2"),
                Arrays.asList("country", "India"),
                Arrays.asList("zipcode", "0000"),
                Arrays.asList("state", "state"),
                Arrays.asList("city", "city"),
                Arrays.asList("mobile_number", "01111111")
        );

        api.post(createAccountService)
                .setParameters(formInputs, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(success_statusCode)
                .perform();
    }
}
