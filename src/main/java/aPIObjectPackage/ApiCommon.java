package aPIObjectPackage;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

import static aPIObjectPackage.APIobjects.token;

public class ApiCommon {
     private static SHAFT.API api;

    public ApiCommon(SHAFT.API api) {
        this.api = api;
    }

    public static  String baseUrl = System.getProperty("baseUrl");
    static final String authentication_serviceName = "/auth";
    public static final int success_statusCode= 200;
    public static final int delete_statusCode = 201;

    public static void login(String username, String password){
        String tokenBody= """
                {
                    "username" : "{USERNAME}",
                    "password" : "{PASSWORD}"
                }
                """
                .replace("{USERNAME}",username)
                .replace("{PASSWORD}", password);
        api.post(authentication_serviceName).setContentType(ContentType.JSON).setRequestBody(tokenBody)
                .setTargetStatusCode(ApiCommon.success_statusCode).perform();
        token = api.getResponseJSONValue("token");
        api.addHeader("Cookie", "token="+token);
    }

}
