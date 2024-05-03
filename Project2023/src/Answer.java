

public class Answer {
    private Student student;
    private Question question;
    private String answer;
    private double grade;
//    private Grade Grade;

    public Answer(Student student, Question question, String answer ) {
        this.student = student;
        this.question = question;
        this.answer = answer;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Question getQuestion() {
        return question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public double getGrade() {
    	return this.grade;
    }
    
}