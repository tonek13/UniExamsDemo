class Grade {
    private Teacher teacher;
    private Answer answer;
    private double grade;

    public Grade(Teacher teacher, Answer answer, int grade) {
        this.teacher = teacher;
        this.answer = answer;
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Answer getAnswer() {
        return answer;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
}