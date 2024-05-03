import java.util.ArrayList;
import java.util.List;

public class Course {
    private String Cid;
    private String CName;
    private String Spid;
    private List<Exam> exams;

    public Course(String Cid, String CName  ) {
        this.Cid = Cid;
        this.CName = CName;
       // this.Spid =Spid;
        this.exams = new ArrayList<>();
    }

    public String getCid() {
        return Cid;
    }

    public String getCName() {
        return CName;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }
    
    public void RemoveExam(Exam exam) {
        exams.remove(exam);
    }
    
    public String getSpid() {
        return Spid;
    }

    public void setSpid(String Spid) {
        this.Spid = Spid;
    }

    public List<Exam> getExams() {
        return exams;
    }
    
}