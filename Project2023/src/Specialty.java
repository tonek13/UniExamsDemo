import java.util.ArrayList;
import java.util.List;


public class Specialty {
    private String Spid;
    private String SpName;
    private List<Course> courseList;

    public Specialty(String Spid ,String SpName) {
        this.Spid = Spid;
        this.SpName = SpName;
        this.courseList = new ArrayList<>();
    }

    public String getSpid() {
        return Spid;
    }

    public void setSpid(String Spid) {
        this.Spid = Spid;
    }

    public String getSpName() {
        return SpName;
    }

    public void setSpName(String SpName) {
        this.SpName = SpName;
    }

    public void addCourse(Course course) {
    	courseList.add(course);
    }

    public List<Course> getCourses() {
        return courseList;
    }

    public List<Course> getCoursesBySpecialty(String Spid) {
        List<Course> specialtyCourses = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getSpid().equals(Spid)) {
                specialtyCourses.add(course);
            }
        }
        return specialtyCourses;
    }
    

}