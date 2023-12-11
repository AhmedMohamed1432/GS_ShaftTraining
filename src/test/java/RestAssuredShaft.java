import com.shaft.api.RequestBuilder;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.python.antlr.ast.Str;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredShaft {
    SHAFT.API api;
    String token;
    String iD;

    @Test (groups = "group1")
    public void getTokenTest(){
        String tokenBody= """
                {
                    "username" : "admin",
                    "password" : "password123"
                }
                """;
        api.post("/auth").setContentType(ContentType.JSON).setRequestBody(tokenBody)
                .setTargetStatusCode(200).perform();
        api.assertThatResponse().body().contains("\"token\":").perform();
        token = api.getResponseJSONValue("token");
    }
    @Test (groups = "group1")
    public void CreateBookingTest(){
        String bookingBody= """
                {
                    "firstname" : "Jim",
                    "lastname" : "Brown",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
                """;
        api.post("/booking").setContentType(ContentType.JSON).setRequestBody(bookingBody)
                .setTargetStatusCode(200).perform();
        api.verifyThatResponse().extractedJsonValue("booking.lastname")
                .isEqualTo("Brown").perform();
        api.verifyThatResponse().extractedJsonValue("booking.additionalneeds")
                .isEqualTo("Breakfast").perform();
        api.verifyThatResponse().body().contains("\"bookingid\":").perform();
        iD = api.getResponseJSONValue("bookingid");

    }

    @Test (dependsOnGroups= {"group1"} )
    public void DeleteBooking(){

        api.delete("/booking/"+iD).setContentType(ContentType.JSON)
                .addHeader("Cookie", "token="+token)
                //.setAuthentication("admin","password123", RequestBuilder.AuthenticationType.BASIC)
                .setTargetStatusCode(201).perform();





    }

    @BeforeClass
    public void beforeClass(){
        api = new SHAFT.API("https://restful-booker.herokuapp.com");

    }
}
