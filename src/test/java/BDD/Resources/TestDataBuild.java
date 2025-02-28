package BDD.Resources;

import SpecBuilder.Serialize;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild
{
    public Serialize addPlacePayload(String name,String Language,String Address )
    {
        Serialize se = new Serialize();
//        se.setName("Frontline");
        se.setName(name);

        se.setAccuracy(60);
//        se.setAddress("Kormangala 6th block ");
        se.setAddress(Address);
//        se.setLanguage("English");
        se.setLanguage(Language);
        se.setPhone_number("(+91) 983 893 3937");
        se.setWebsite("http://google.com");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        se.setTypes(myList);
        Serialize.location loc = new Serialize.location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        se.setLocation(loc);
        return se;

    }

    public String deletePlacePayload(String place_id)
    {
        return "{\n" +
                "    \"place_id\":\""+place_id+"\"\n" +
                "}";
    }
}
