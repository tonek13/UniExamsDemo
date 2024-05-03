class Teacher {
    private String id;
    private String name;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    

    public void gradeAnswer(Answer answer, double grade) {
//        Grade answerGrade = new Grade(this, answer, grade);
        answer.setGrade(grade);
        System.out.println("Grading answer for student: " + answer.getStudent().getSname());
        System.out.println("Question: " + answer.getQuestion().getQcontent());
        System.out.println("Answer: " + answer.getAnswer());
        System.out.println("Grade: " + grade);
    }
}