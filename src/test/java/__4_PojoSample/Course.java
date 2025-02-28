package __4_PojoSample;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Course {
    @JsonProperty("webAutomation") // Maps "webAutomation" from JSON
    private List<ApiCourse> webAutomation;

    @JsonProperty("api") // Maps "api" from JSON
    private List<ApiCourse> api;

    @JsonProperty("mobile") // Maps "mobile" from JSON
    private List<ApiCourse> mobile;


    public List<ApiCourse> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<ApiCourse> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<ApiCourse> getApi() {
        return api;
    }

    public void setApi(List<ApiCourse> api) {
        this.api = api;
    }

    public List<ApiCourse> getMobile() {
        return mobile;
    }

    public void setMobile(List<ApiCourse> mobile) {
        this.mobile = mobile;
    }
}