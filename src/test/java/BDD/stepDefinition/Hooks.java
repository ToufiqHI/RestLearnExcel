package BDD.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.StepDefinitionAnnotation;

public class Hooks
{
    @Before("@DeletePlace")
    public void beforeScenario() throws Exception
    {
        //write a code that will provide placeid
        // execute this when  placeid is null
        if (stepDefinition.place_id == null)
        {
            stepDefinition call = new stepDefinition();
            call.add_place_payload("", "Hindi", "Delhi");
            call.user_calls_with_http_request("AddPlaceAPI", "POST");
            call.verify_placeId_created_maps_to_using("", "GetPlaceAPI");
        }
    }


}
