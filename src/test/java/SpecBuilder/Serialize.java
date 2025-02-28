package SpecBuilder;

import lombok.Data;

import java.util.List;

@Data
public class Serialize
{
    private int accuracy;
    private String name;
    private String  phone_number;
    private String address;
    private String website;
    private String language;
    private List<String> types;
    private location location;

    @Data
    public static class location
    {
        private double lat;
        private double lng;

    }

}
