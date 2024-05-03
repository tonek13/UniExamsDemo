import java.util.ArrayList;
import java.util.List;

public class Exam {
    private String Eid;
    private String Ename;
    private String EType;
    private Course course;
    private List<Exercise> exercises;
    private String date;
   // private Modality modality;
    private double examGrade1 = 0;
    private double examGrade2 = 0;

    public Exam(String examId, String examName, String EType, String date) {
        this.Eid = examId;
        this.Ename = examName;
        this.EType = EType;
        this.date = date;
   //     this.course = course;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public String getExamId() {
        return Eid;
    }
    
    public String getEname() {
    	return Ename;
    }
    public void setEname(String Ename) {
    	this.Ename =Ename;    }
    
    public String getEType() {
    	return EType;
    }
    
    public void setEType(String EType) {
    	this.EType =EType;    }
    
    public Course getCourse() {
        return course;
    }
    public String getDate() {
        return date;
    }

	public double getExamGrade1() {
		return this.examGrade1;
	}
	
	public double getExamGrade2() {
		return this.examGrade2;
	}

	public void setExamGrade1(double g) {
		this.examGrade1 = g;
	}
	public void setExamGrade2(double g) {
		this.examGrade2 = g;
	}
	
	public void calculateExamGrade1() {
		double sum = 0;
    	for (Exercise e : exercises) {
	        sum += e.getExerciseGrade();
	    }
    	setExamGrade1(sum);
	}
	public void calculateExamGrade2() {
		double sum = 0;
    	for (Exercise e : exercises) {
	        sum += e.getExerciseGrade();
	    }
    	setExamGrade2(sum);
	}

/*	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
	}
  */  
	public void setCourse(Course course) {
        this.course = course;
    }
}
