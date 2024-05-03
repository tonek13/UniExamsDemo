/*
public class FinalGrade {
	private Course Course;
	private Exam Exam;
	private double finalGrade;
	
	public FinalGrade(Course course, Exam exam ) {
		this.Course = course;
		this.Exam = exam;
		this.calculateFinalGrade();
	}
	
	public String toString() {
		return "Final Grade: " + this.finalGrade;
	}
	
	public void setFinalGrade(double grade) {
		this.finalGrade = grade;
	}
	
	public double getFinalGrade() {
		return this.finalGrade;
	}
	 public Course getCourse() {
	        return this.Course;
	    }
	    
	    public Exam getExam() {
	        return this.Exam;
	    }
	    
	
	public void calculateFinalGrade() {
		double result = 0;
		for(Exam e : Course.getExams()) {
			if(e.getEname().equals(Exam.getEname())) {
				result = (e.getExamGrade1() + e.getExamGrade2())/2;
			}
		}
		setFinalGrade(result);
	}
	

}
*/