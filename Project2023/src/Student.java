import java.util.ArrayList;
import java.util.List;

public class Student {
	private String Sid;
	private String Sname;
	private String Sspecialty;
	private String Sgender;
	private Course course;

	private List<Answer> answers;
//	private List<FinalGrade> finalGrades;
	
	public Student(String studentId, String studentName, String studentSpecialty, String studentGender) {
        this.Sid = studentId;
        this.Sname = studentName;
        this.Sspecialty = studentSpecialty;
        this.Sgender = studentGender;
        this.answers = new ArrayList<>();
//        this.finalGrades = new ArrayList<>();
    }
	
/*	public double getFinalGrade(Course course, Exam exam) {
        for (FinalGrade finalGrade : finalGrades) {
            if (finalGrade.getCourse().equals(course) && finalGrade.getExam().equals(exam)) {
                return finalGrade.getFinalGrade();
            }
        }
        return -1; // Return -1 if no matching FinalGrade is found
    }
	 
	public void setFinalGrade(FinalGrade finalGrade) {
		this.finalGrades.add(finalGrade);

	}
	*/
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	 public String getSid() {
		 return Sid;
	 }
	 
	 public void setSid(String studentId) {
		 this.Sid=studentId;
	 }
	 
	 public String getSname() {
		 return Sname;
	 }
	 
	 public void setSname(String studentName) {
		 this.Sid=studentName;
	 }
	 
	 public String getStudentSpecialty() {
	        return Sspecialty;
	    }
	    
	    public void setStudentSpecialty(String studentSpecialty) {
	        this.Sspecialty = studentSpecialty;
	    }
	    
	    public String getStudentGender() {
	        return Sgender;
	    }
	    
	    public void setStudentGender(String studentGender) {
	        this.Sgender = studentGender;
	    }
	    
	    public List<Answer> getAnswers() {
	        return answers;
	    }
	    
	    public void addAnswer(Answer answer) {
	        answers.add(answer);
	    }
	    public void enrollInCourse(Course course) {
	        this.course = course;
	    }

	    public Course getCourse() {
	        return course;
	    }
	    
	    
	 


}

