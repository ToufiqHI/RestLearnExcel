package __4_PojoSample;

public class GetCourse {
    private String linkedIn;
    private String url;
    private Course courses; // This must match JSON's "courses"

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourses() { // Must match "courses" in JSON
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }
}