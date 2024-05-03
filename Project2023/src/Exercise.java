import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String exerciseNumber;
    private double exerciseGrade = 0;
    private String exerciseId;
    private List<Question> questions;

    public Exercise(String exerciseNumber, String exerciseId) {
        this.exerciseNumber = exerciseNumber;
        this.exerciseId = exerciseId;
        this.questions = new ArrayList<>();
    }

    public String getExerciseValue() {
        return exerciseNumber;
    }

    public String getExerciseId() {
        return exerciseId;
   }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    
    public double getExerciseGrade() {
    	return this.exerciseGrade;
    }
    
    public void setExerciseGrade(double g) {
    	this.exerciseGrade = g;
    }
    
    public void calculateExerciseGrade() {
    	double sum = 0;
    	for (Question q : questions) {
	        sum += q.getAnswer().getGrade();	    }
    	setExerciseGrade(sum);
    }
}
