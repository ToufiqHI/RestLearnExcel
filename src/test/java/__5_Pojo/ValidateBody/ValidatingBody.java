package __5_Pojo.ValidateBody;

import lombok.Data;

import java.util.List;

@Data
public class ValidatingBody
{
    private String instructor;
    private String url;
    private String services;
    private String expertise;
    private Course courses;
    private String linkedIn;

    @Data
    public static class Course
    {
        private List<WebAutomation> webAutomation;
        private List<Api> api;
        private List<Mobile> mobile;
    }
    @Data
    public static class WebAutomation
    {
        private String courseTitle;
        private String price;
    }
    @Data
    public static class Api
    {
        private String courseTitle;
        private String price;
    }
    @Data
    public static class Mobile
    {
        private String courseTitle;
        private String price;
    }

}
