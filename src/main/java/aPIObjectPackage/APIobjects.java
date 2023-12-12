package aPIObjectPackage;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

public class APIobjects {
    public static SHAFT.API api;
    public APIobjects(SHAFT.API api) {
        this.api = api;
    }

    static String token;
    ///srevices names:

    private static final String booking_serviceName="/booking" ;

    public static void createBooking(String firstName, String lastname, String additinalneeds){
        String bookingBody= """
                {
                    "firstname" : "{FIRSTNAME}",
                    "lastname" : "{LASTNAME}",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "{ADDITIONALNEEDS}"
                }
                """
                .replace("{FIRSTNAME}",firstName)
                .replace("{LASTNAME}",lastname)
                .replace("{ADDITIONALNEEDS}",additinalneeds);
        api.post(booking_serviceName)
                .setContentType(ContentType.JSON).setRequestBody(bookingBody)
                .setTargetStatusCode(ApiCommon.success_statusCode).perform();

    }
    public static void deleteBooking(String username, String password){
        String bookingiD = getBookingID(username, password);
        api.delete(booking_serviceName+"/"+bookingiD).setContentType(ContentType.JSON)
                .setTargetStatusCode(ApiCommon.delete_statusCode).perform();
    }
    public static String getBookingID(String firstname, String lastname){
        api.get(booking_serviceName).setUrlArguments("firstname"+firstname+ "lastname"+lastname).perform();
        return api.getResponseJSONValue("$[0].bookingid");
    }
    public static void validateBookingCreation(String expectedfirstName, String expectedlastname, String expectedadditinalneeds){
        api.verifyThatResponse().extractedJsonValue("booking.firstname")
                .isEqualTo(expectedfirstName).perform();
        api.verifyThatResponse().extractedJsonValue("booking.lastname")
                .isEqualTo(expectedlastname).perform();
        api.verifyThatResponse().extractedJsonValue("booking.additionalneeds")
                .isEqualTo(expectedadditinalneeds).perform();
        api.verifyThatResponse().body().contains("\"bookingid\":").perform();
    }
    public static void validatedBookingDeletion(){
        api.assertThatResponse().body().contains("Created").perform();
    }
}
