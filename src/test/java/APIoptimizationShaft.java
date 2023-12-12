import aPIObjectPackage.APIobjects;
import aPIObjectPackage.ApiCommon;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APIoptimizationShaft {
    private SHAFT.API api;

    @Test
    public void createBookingTest(){
        APIobjects.createBooking("Jim","Brown","Breakfast");
        APIobjects.validateBookingCreation("Jim","Brown","Breakfast");
    }

    @Test
    public void deleteBookingTest(){
        APIobjects.deleteBooking("Jim", "Brown");
        APIobjects.validatedBookingDeletion();
    }

    @BeforeClass
    public void beforeClass(){
        api = new SHAFT.API(ApiCommon.baseUrl);
        ApiCommon ApiCommon = new ApiCommon(api);
        APIobjects APIobjects = new APIobjects(api);
        ApiCommon.login("admin","password123");


    }


}
