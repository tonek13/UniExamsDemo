import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
	
	private JComboBox<String> SpecialtyCMBX;
    private JComboBox<String> YearCMBX;
    private JComboBox<String> Specialty2CMBX;
    private JComboBox<String> CourseCMBX;
    private JComboBox<String> ExamCMBX ;
    private JComboBox <String> ExerciseCMBX2 ;
    private JComboBox <String> ExamCMBX3 ;
    private JComboBox <Object> CourseCMBX3;
    private JComboBox<String> Teacher2CMBX;
    private JComboBox<String> Teacher2CMBX3;
    private JComboBox<String> Student2CMBX ;
    private JComboBox<String> Student2CMBX3 ;
    private JComboBox<String> Student2CMBX4 ;
    private JComboBox<String> Course2CMBX ;
    private JComboBox<String> Course2CMBX3;
    private JComboBox <String> ExerciseCMBX3;
    private JComboBox<String> Exercise2CMBX ;
    private JComboBox<Object> Course4CMBX;
    private JComboBox <String> Exam3CMBX;
    private TreeMap<String, List<Specialty>> yearSpecialtiesMap;
	private TreeMap<String, List<Course>> specialtiesCourseMap;
	private TreeMap<String, List<Exam>> CourseExamMap;
	private TreeMap<String, List<Exercise>> ExamExerciseMap;
	private TreeMap<String, List<Question>> ExerciseQuestionMap;
	private Map<String, Map<String, String>> studentExerciseAnswersMap;
	private Map<String, Map<String, String>> studentAnswersMap;
	private JPanel contentPane;
	private JComboBox <String> StudentCMBX = new JComboBox<>();
	private static final long serialVersionUID = 1L;
	

    public static void main(String[] args) {
 
     
             MainFrame frame = new MainFrame();
             frame.setVisible(true);
            

    }
    


    public MainFrame () {
    	
        yearSpecialtiesMap = new TreeMap<>();
        specialtiesCourseMap = new TreeMap<>();
        CourseExamMap = new TreeMap<>();
        ExamExerciseMap = new TreeMap<>();
        ExerciseQuestionMap = new TreeMap<>();
        studentAnswersMap =new HashMap<>();
        studentExerciseAnswersMap =new HashMap<>();
        CourseCMBX = new JComboBox<String>();
        ExerciseCMBX2 =new JComboBox<String>();
        CourseCMBX3 =new JComboBox<Object>();
        ExamCMBX3 =new JComboBox<String>();
        Teacher2CMBX = new JComboBox<String>();
        Teacher2CMBX3 =new JComboBox<String>();
        Student2CMBX =new JComboBox<String>();
        Student2CMBX3 =new JComboBox<String>();
        Student2CMBX4 =new JComboBox<String>();
        Course2CMBX =new JComboBox<String>();
        Course2CMBX3 =new JComboBox<String>();
        ExerciseCMBX3= new JComboBox<String>();
        Exercise2CMBX = new JComboBox<String>();
        Course4CMBX = new JComboBox<Object>();
        Exam3CMBX = new JComboBox<String>();
        
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton employeeBtn = new JButton("Employee");
        employeeBtn.setBounds(135, 35, 150, 20);
        contentPane.add(employeeBtn);

        employeeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEmployeeFrame();
            }
        });

        JButton teacherBtn1 = new JButton("Teacher 1");
        teacherBtn1.setBounds(135, 110, 150, 20);
        contentPane.add(teacherBtn1);

        teacherBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTeacher1Frame();
            }
        });
        
        JButton teacherBtn2 = new JButton("Teacher 2");
        teacherBtn2.setBounds(135, 145, 150, 20);
        contentPane.add(teacherBtn2);

        teacherBtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTeacher2Frame();
            }
        });

        JButton studentBtn = new JButton("Student");
        studentBtn.setBounds(135, 75, 150, 20);
        contentPane.add(studentBtn);

        studentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openStudentFrame();
            }
        });

        JButton notesBtn = new JButton("Notes");
        notesBtn.setBounds(135, 180, 150, 20);
        contentPane.add(notesBtn);

        notesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openNotesFrame();
            }
        });
    }
    
    JPanel Year = new JPanel();
    JPanel Course = new JPanel();
    JPanel Exercice = new JPanel();
    JPanel Questions = new JPanel();
    JPanel Students = new JPanel();
    JTextField YearTXT =new JTextField();
    JTextField SIdTXT =new JTextField();
    JTextField SNameTXT =new JTextField();
    JTextField CourseNameTXT =new JTextField();
    JTextField CourseIdTXT =new JTextField();
    JTextField ExamIdTXT =new JTextField();
    JTextField ExamNameTXT =new JTextField();
    JTextField ExamDateTXT =new JTextField();
    JTextField ExerciseIdTXT =new JTextField();
    JTextField ExerciseValueTXT =new JTextField();
    JTextField QuestionIdTXT =new JTextField();
    JTextField QuestionContentTXT =new JTextField();
    JTextField QuestionNotesTXT =new JTextField();
    JTextField TeacherIdTXT =new JTextField();
    JTextField TeacherNameTXT =new JTextField();
    JTextField StudentIdTXT =new JTextField();
    JTextField StudentNameTXT =new JTextField();
    JTextField ExamTypeTXT =new JTextField();
    JTextArea ExerciseTAREA = new JTextArea();
    JTextArea QuestionsTAREA = new JTextArea();
    JTextField FirstGradeTXT =new JTextField();
    String[] CoursecolumnNames = {"Exam Id", "Exam Name", "Type", "Date"};
    String[] TeachercolumnNames = {"Id", "Teacher Name"};
    String[] StudentcolumnNames = {"Id", "Student Name" ,"Gender"};
    String[] QAndAColumn = {"Question", "Answer"};
    String[] QAndAAndNColumn = {"Question", "Answer" };
    DefaultTableModel model = new DefaultTableModel(CoursecolumnNames, 0);
    DefaultTableModel model2 = new DefaultTableModel(TeachercolumnNames, 0);
    DefaultTableModel model3 = new DefaultTableModel(StudentcolumnNames, 0);
    DefaultTableModel model4 = new DefaultTableModel(QAndAColumn, 0);
    DefaultTableModel model5 = new DefaultTableModel(QAndAAndNColumn, 0);
    DefaultTableModel model6 = new DefaultTableModel(QAndAAndNColumn, 0);
    JTextField SecGradeTXT =new JTextField();/// 3alemet l final taba3 second corrector
    JTextField FGradeTXT =new JTextField();/// 3alemet l final bl fahsen tb3 first corrector
    JTextField FCourseTXT =new JTextField();/// 3alemet ekher note l final
    JTextField FristGrade1TXT =new JTextField();/// 3alemet l first corrector partiel
    JTextField SecGrade1TXT =new JTextField();/// 3alemegt l second corrector partiel
    JTextField FirstGrade1TXT =new JTextField();/// 3alemet l final bl fahsen tb3 sec corrector
    
    
    
    
    
    private void updateSpecialtyComboBox() {
    	
        SpecialtyCMBX.removeAllItems();
        
        String selectedYear = (String) YearCMBX.getSelectedItem();
        List<Specialty> specialties = yearSpecialtiesMap.get(selectedYear);

        if (specialties != null) {
            for (Specialty specialty : specialties) {
            	String specialtyInfo = selectedYear + " " + specialty.getSpid() + " " + specialty.getSpName();
            	SpecialtyCMBX.addItem(specialtyInfo);
            }
        }
    }
	
    private void updateSpecialty2ComboBox() {
        Specialty2CMBX.removeAllItems();
        Course2CMBX.removeAllItems();
        Course2CMBX3.removeAllItems();
        
        String selectedYear = (String) YearCMBX.getSelectedItem();
        List<Specialty> specialties = yearSpecialtiesMap.get(selectedYear);

        if (specialties != null) {
            for (Specialty specialty : specialties) {
                String specialtyInfo = selectedYear + " " + specialty.getSpid() + " " + specialty.getSpName();
                Specialty2CMBX.addItem(specialtyInfo);
            }
        }
    }
    private void updateCourseComboBox() {
        CourseCMBX.removeAllItems(); // Clear existing course options
        String selectedSpecialty = (String) Specialty2CMBX.getSelectedItem();
        List<Course> courses = specialtiesCourseMap.get(selectedSpecialty);

        
        if(courses != null) {
        	for (Course Course : courses) {
        		String courseInfo =Course.getCid() + " " + Course.getCName();
                CourseCMBX.addItem(courseInfo);
                Course2CMBX.addItem(courseInfo);
                Course2CMBX3.addItem(courseInfo);
        }
        	
        	
        }
        
        
        
        
    }
    
    private void updateExamCMBX() {
     
        ExamCMBX.removeAllItems();

        for (int row = 0; row < model.getRowCount(); row++) {
            String examId = model.getValueAt(row, 0).toString();
            String examName = model.getValueAt(row, 1).toString();
            String examType = model.getValueAt(row, 2).toString();
            String examDate = model.getValueAt(row, 3).toString();

            String comboBoxItem = examId +" "+ examName +" "+ examType +" " +examDate;

            ExamCMBX.addItem(comboBoxItem);
        }
    }

    public void updateExamTable() {
        model.setRowCount(0);

        String selectedCourseId = (String) CourseCMBX.getSelectedItem();


        List<Exam> exams = CourseExamMap.get(selectedCourseId);
        if (exams != null) {
        
            for (Exam exam : exams) {
                String examId = exam.getExamId();
                String examName = exam.getEname();
                String examType = exam.getEType();
                String examDate = exam.getDate();

                Object[] rowData = { examId, examName, examType, examDate };

                model.addRow(rowData);
            }
        }

        model.fireTableDataChanged();
    }
    
    public void updateExerciseTAREA() {
        StringBuilder exerciseText = new StringBuilder();
        
        String selectedExamId = (String) ExamCMBX.getSelectedItem();
        
        List<Exercise> exercises = ExamExerciseMap.get(selectedExamId);
        if (exercises != null) {
            exerciseText.append("Exam ID: ").append(selectedExamId).append("\n");
            for (Exercise exercise : exercises) {
                exerciseText.append("Exercise ID: ").append(exercise.getExerciseId())
                           .append(" Exercise Value: ").append(exercise.getExerciseValue())
                           .append("\n");
            }
        }
        
        ExerciseTAREA.setText(exerciseText.toString());
        
        String exerciseTextAreaValue = ExerciseTAREA.getText();
        
        ExerciseCMBX2.setSelectedItem(exerciseTextAreaValue);
    }
    
    
    public void updateExerciseCMBX2() {
        String exerciseTextAreaValue = ExerciseTAREA.getText();
        
        String[] lines = exerciseTextAreaValue.split("\\n");
        
        ExerciseCMBX2.removeAllItems();
        
        for (String line : lines) {
            ExerciseCMBX2.addItem(line);
        }
    }

    public void updateQuestionArea() {
        QuestionsTAREA.setText("");

        for (Map.Entry<String, List<Question>> entry : ExerciseQuestionMap.entrySet()) {
            String exercise = entry.getKey();
            List<Question> questions = entry.getValue();


            QuestionsTAREA.append("Exercise: " + exercise + "\n");
            for (Question question : questions) {
                String questionText = question.getQid() + ") " + question.getQcontent() + " (" + question.getPoints() + ")\n";
                QuestionsTAREA.append(questionText);
            }
            QuestionsTAREA.append("\n");
        }
    }

    private void populateStudentComboBox() {

        StudentCMBX.removeAllItems();
        Student2CMBX.removeAllItems();
        Student2CMBX3.removeAllItems();
        Student2CMBX4.removeAllItems();

        int rowCount = model3.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String studentId = model3.getValueAt(i, 0).toString();
            String studentName = model3.getValueAt(i, 1).toString();
            String gender = model3.getValueAt(i, 2).toString();
            String studentDetails = studentId + " - " + studentName + " - " + gender;
            StudentCMBX.addItem(studentDetails);
            Student2CMBX.addItem(studentDetails);
            Student2CMBX3.addItem(studentDetails);
            Student2CMBX4.addItem(studentDetails);
        }
    }
        
        private void populateTeacherComboBox() {

        	Teacher2CMBX.removeAllItems();
        	Teacher2CMBX3.removeAllItems();

          
            int rowCount = model2.getRowCount();


            for (int i = 0; i < rowCount; i++) {
                String TeacherId = model2.getValueAt(i, 0).toString();
                String TeacherName = model2.getValueAt(i, 1).toString();
                String TeacherDetails = TeacherId + " - " + TeacherName ;
                Teacher2CMBX.addItem(TeacherDetails);
                Teacher2CMBX3.addItem(TeacherDetails);
            }
    }
    
    
    public void updateCourseCMBX3() {

        CourseCMBX3.removeAllItems();

        int itemCount = CourseCMBX.getItemCount();

        for (int i = 0; i < itemCount; i++) {
            Object item = CourseCMBX.getItemAt(i);
            CourseCMBX3.addItem(item);
        }
    }
    
    public void updateCourse4CMBX() {

    	Course4CMBX.removeAllItems();

   
        int itemCount = CourseCMBX.getItemCount();

      
        for (int i = 0; i < itemCount; i++) {
            Object item = CourseCMBX.getItemAt(i);
            Course4CMBX.addItem(item);
        }
    }
    
    
    
   
    
    public String getStudentAnswerForQuestion(String studentName, String exerciseId, String questionId) {

        Map<String, String> exerciseAnswers = studentExerciseAnswersMap.getOrDefault(exerciseId, new HashMap<>());
        Map<String, String> studentAnswers = studentAnswersMap.getOrDefault(studentName, new HashMap<>());

      
        if (exerciseAnswers.containsKey(questionId)) {

            return exerciseAnswers.get(questionId);
        }

    
        if (studentAnswers.containsKey(questionId)) {
      
            return studentAnswers.get(questionId);
        }

 
        return "";
    }
    
    private void saveAnswersToFile(String student, String exercise, List<String> answers) {
        try {
            File file = new File("answers.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(student + "," + exercise);

            for (String answer : answers) {
                String[] parts = answer.split(",");
                String question = parts[0];
                String value = parts[1];
                bw.write("," + question + "," + value);
            }

            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void saveYearSpecToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, List<Specialty>> entry : yearSpecialtiesMap.entrySet()) {
                String year = entry.getKey();
                writer.write("Year," + year);
                writer.newLine();

                List<Specialty> specialties = entry.getValue();
                for (Specialty specialty : specialties) {
                    String specialtyId = specialty.getSpid();
                    String specialtyName = specialty.getSpName();
                    writer.write("Specialty," + year + "," + specialtyId + "," + specialtyName);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    }
    String filePath = "years.txt";

    private void loadYearSpecFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String dataType = data[0];

                if (dataType.equals("Year")) {
                    String year = data[1];
                    YearCMBX.addItem(year);
                    yearSpecialtiesMap.put(year, new ArrayList<>()); // Initialize empty list for the year
                } else if (dataType.equals("Specialty")) {
                    if (data.length >= 3) { // Check if the data array has enough elements
                        String year = data[1];
                        String specialtyId = data[2];
                        String specialtyName = data[3];

                        List<Specialty> specialties = yearSpecialtiesMap.get(year);
                        Specialty specialty = new Specialty(specialtyId, specialtyName);
                        if (specialties != null) {
                            specialties.add(specialty);
                        }
                    } else {
                        // Handle invalid data format
                        System.out.println("Invalid data format: " + line);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }
    
    private void saveCourseDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"))) {
            for (Map.Entry<String, List<Course>> entry : specialtiesCourseMap.entrySet()) {
                String specialty = entry.getKey();
                List<Course> courses = entry.getValue();
                writer.write(specialty + "\n");
                for (Course course : courses) {
                    writer.write(course.getCid() + "," + course.getCName() + "\n");
                }
                writer.write("---\n"); // separator between specialties
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadCourseDataFromFile() {
        specialtiesCourseMap.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
            String line;
            String specialty = null;
            List<Course> courses = null;

            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    if (specialty != null && courses != null) {
                        specialtiesCourseMap.put(specialty, courses);
                    }
                    specialty = null;
                    courses = null;
                } else if (specialty == null) {
                    specialty = line;
                    courses = new ArrayList<>();
                } else {
                    String[] parts = line.split(",");
                    String courseId = parts[0];
                    String courseName = parts[1];
                    Course course = new Course(courseId, courseName);
                    courses.add(course);
                }
            }

            if (specialty != null && courses != null) {
                specialtiesCourseMap.put(specialty, courses);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void saveExamDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("exams.txt"))) {
            for (Map.Entry<String, List<Exam>> entry : CourseExamMap.entrySet()) {
                String courseId = entry.getKey();
                List<Exam> exams = entry.getValue();
                writer.write(courseId + "\n");
                for (Exam exam : exams) {
                    writer.write(exam.getExamId() + "," + exam.getEname() + "," + exam.getEType() + "," + exam.getDate() + "\n");
                }
                writer.write("---\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadExamDataFromFile() {
        CourseExamMap.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("exams.txt"))) {
            String line;
            String courseId = null;
            List<Exam> exams = null;

            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    if (courseId != null && exams != null) {
                        CourseExamMap.put(courseId, exams);
                    }
                    courseId = null;
                    exams = null;
                } else if (courseId == null) {
                    courseId = line;
                    exams = new ArrayList<>();
                } else {
                    String[] parts = line.split(",");
                    String examId = parts[0];
                    String examName = parts[1];
                    String examType = parts[2];
                    String examDate = parts[3];
                    Exam exam = new Exam(examId, examName, examType, examDate);
                    exams.add(exam);
                }
            }

            if (courseId != null && exams != null) {
                CourseExamMap.put(courseId, exams);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void saveExercisesToFile() {
        try {
   
            FileWriter writer = new FileWriter("exercises.txt");

            for (String examId : ExamExerciseMap.keySet()) {
          
                writer.write("Exam ID: " + examId + "\n");

       
                List<Exercise> exercises = ExamExerciseMap.get(examId);

            
                for (Exercise exercise : exercises) {
                    writer.write("Exercise ID: " + exercise.getExerciseId() + "\n");
                    writer.write("Exercise Value: " + exercise.getExerciseValue() + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadExercisesFromFile() {
        try {
            File file = new File("exercises.txt");
            Scanner scanner = new Scanner(file);

            String examId = null;
            List<Exercise> exercises = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Exam ID: ")) {
                    if (examId != null && exercises != null) {
                        ExamExerciseMap.put(examId, exercises);
                    }

                    examId = line.substring("Exam ID: ".length());
                    exercises = new ArrayList<>();
                }
                else if (line.startsWith("Exercise ID: ")) {
                    String exerciseId = line.substring("Exercise ID: ".length());
                    String exerciseValue = scanner.nextLine().substring("Exercise Value: ".length());

                    Exercise exercise = new Exercise(exerciseValue, exerciseId);
                    exercises.add(exercise);
                }
            }

            if (examId != null && exercises != null) {
                ExamExerciseMap.put(examId, exercises);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public void saveQuestionsToFile() {
        try {
            FileWriter writer = new FileWriter("questions.txt");

            for (String exerciseId : ExerciseQuestionMap.keySet()) {
         
                writer.write("Exercise ID: " + exerciseId + "\n");

                List<Question> questions = ExerciseQuestionMap.get(exerciseId);

                for (Question question : questions) {
                    writer.write("Question ID: " + question.getQid() + "\n");
                    writer.write("Question Content: " + question.getQcontent() + "\n");
                    writer.write("Question Point: " + question.getPoints() + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadQuestionsFromFile() {
        try {
            File file = new File("questions.txt");
            Scanner scanner = new Scanner(file);

            String exerciseId = null;
            List<Question> questions = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Exercise ID: ")) {
                    if (exerciseId != null && questions != null) {
                        ExerciseQuestionMap.put(exerciseId, questions);
                    }

                    exerciseId = line.substring("Exercise ID: ".length());
                    questions = new ArrayList<>();
                }
                else if (line.startsWith("Question ID: ")) {
                    String questionId = line.substring("Question ID: ".length());

                    String content = scanner.nextLine().substring("Question Content: ".length());
                    String point = scanner.nextLine().substring("Question Point: ".length());

                    Question question = new Question(questionId, content, point);
                    questions.add(question);
                }
            }

            if (exerciseId != null && questions != null) {
                ExerciseQuestionMap.put(exerciseId, questions);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void saveStudentsToFile() {
        try {
            FileWriter writer = new FileWriter("students.txt");

            for (int row = 0; row < model3.getRowCount(); row++) {
        
                String studentId = model3.getValueAt(row, 0).toString();
                String studentName = model3.getValueAt(row, 1).toString();
                String gender = model3.getValueAt(row, 2).toString();

             
                writer.write("Student ID: " + studentId + "\n");
                writer.write("Student Name: " + studentName + "\n");
                writer.write("Gender: " + gender + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadStudentsFromFile() {
        try {
            File file = new File("students.txt");
            Scanner scanner = new Scanner(file);

            model3.setRowCount(0);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Student ID: ")) {
                   
                    String studentId = line.substring("Student ID: ".length());
                    String studentName = scanner.nextLine().substring("Student Name: ".length());
                    String genderLine = scanner.nextLine();
                    String gender = genderLine.substring("Gender: ".length());

                    model3.addRow(new Object[]{studentId, studentName, gender});
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void saveTeachersToFile() {
        try {
            FileWriter writer = new FileWriter("teachers.txt");

            for (int row = 0; row < model2.getRowCount(); row++) {
                String teacherId = model2.getValueAt(row, 0).toString();
                String teacherName = model2.getValueAt(row, 1).toString();

                writer.write("Teacher ID: " + teacherId + "\n");
                writer.write("Teacher Name: " + teacherName + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTeachersFromFile() {
        try {
            File file = new File("teachers.txt");
            Scanner scanner = new Scanner(file);

            model2.setRowCount(0);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Teacher ID: ")) {
            
                    String teacherId = line.substring("Teacher ID: ".length());
                    String teacherName = scanner.nextLine().substring("Teacher Name: ".length());

                    model2.addRow(new Object[]{teacherId, teacherName});
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    private void saveFinalSCGrade(String studentName, String examName, String grade) {
        try {
            String filePath = "FinalSCGrade.txt"; // Modify the file path if needed
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(studentName + "," + examName + "," + grade + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void loadFinalSCGrade(String studentName, String examName) {
        try {
            File file = new File("FinalSCGrade.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean gradeFound = false;
            String grade = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String savedStudentName = parts[0];
                String savedExamName = parts[1];
                String savedGrade = parts[2];

                if (savedStudentName.equals(studentName) && savedExamName.equals(examName)) {
                    grade = savedGrade;
                    gradeFound = true;
                    break; 
                }
            }

            br.close();
            fr.close();

            if (gradeFound) {
            	SecGradeTXT.setText(grade);
            } else {
            	SecGradeTXT.setText("No grade found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePartielSCGrade(String studentName, String examName, String grade) {
        try {
            String filePath = "PartielSCGrade.txt"; // Modify the file path if needed
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(studentName + "," + examName + "," + grade + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPartielSCGrade(String studentName, String examName) {
        try {
            File file = new File("PartielSCGrade.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean gradeFound = false;
            String grade = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String savedStudentName = parts[0];
                String savedExamName = parts[1];
                String savedGrade = parts[2];

                if (savedStudentName.equals(studentName) && savedExamName.equals(examName)) {
                    grade = savedGrade;
                    gradeFound = true;
                    break; 
                }
            }

            br.close();
            fr.close();

            if (gradeFound) {
            	SecGrade1TXT.setText(grade);
            } else {
            	SecGrade1TXT.setText("No grade found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void savePartielFCGrade(String studentName, String examName, String grade) {
        try {
            String filePath = "PartielFCGrade.txt";
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(studentName + "," + examName + "," + grade + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPartielFCGrade(String studentName, String examName) {
        try {
            File file = new File("PartielFCGrade.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean gradeFound = false;
            String grade = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String savedStudentName = parts[0];
                String savedExamName = parts[1];
                String savedGrade = parts[2];

                if (savedStudentName.equals(studentName) && savedExamName.equals(examName)) {
                    grade = savedGrade;
                    gradeFound = true;
                    break; 
                }
            }

            br.close();
            fr.close();

            if (gradeFound) {
            	FristGrade1TXT.setText(grade);
            } else {
            	FristGrade1TXT.setText("No grade found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveFinalFCGrade(String studentName, String examName, String grade) {
        try {
            String filePath = "FinalFCGrade.txt"; 
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(studentName + "," + examName + "," + grade + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFinalFCGrade(String studentName, String examName) {
        try {
            File file = new File("FinalFCGrade.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean gradeFound = false;
            String grade = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String savedStudentName = parts[0];
                String savedExamName = parts[1];
                String savedGrade = parts[2];

                if (savedStudentName.equals(studentName) && savedExamName.equals(examName)) {
                    grade = savedGrade;
                    gradeFound = true;
                    break; 
                }
            }

            br.close();
            fr.close();

            if (gradeFound) {
            	FirstGradeTXT.setText(grade);
            } else {
            	FirstGradeTXT.setText("No grade found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void calculateFinalGrade() {
        String firstGradeText = FirstGradeTXT.getText();
        String firstGrade1Text = SecGradeTXT.getText();

        try {
            double firstGrade = Double.parseDouble(firstGradeText);
            double firstGrade1 = Double.parseDouble(firstGrade1Text);

            double finalGrade = (firstGrade+firstGrade1)/2;
            FGradeTXT.setText(String.valueOf(finalGrade));
        } catch (NumberFormatException e) {
        	FGradeTXT.setText("Invalid input");
        }
    }
    
    private void calculatePartielGrade() {
        String firstGradeText = FristGrade1TXT.getText();
        String firstGrade1Text = SecGrade1TXT.getText();

        try {
            double firstGrade = Double.parseDouble(firstGradeText);
            double firstGrade1 = Double.parseDouble(firstGrade1Text);

            double finalGrade = (firstGrade+firstGrade1)/2;

            FirstGrade1TXT.setText(String.valueOf(finalGrade));
        } catch (NumberFormatException e) {
        	FirstGrade1TXT.setText("Invalid input");
        }
    }
    
    private void calculateFinalCourseGrade() {
        String firstGrade1Text = FirstGrade1TXT.getText();
        String fGradeText = FGradeTXT.getText();

        try {
        	double firstGrade = Double.parseDouble(fGradeText);
            double firstGrade1 = Double.parseDouble(firstGrade1Text);



            double finalCourseGrade = (0.6 * firstGrade) + (0.4 * firstGrade1);

            FCourseTXT.setText(String.valueOf(finalCourseGrade));
        } catch (NumberFormatException e) {
            FCourseTXT.setText("Invalid input");
        }
    }






    private void openEmployeeFrame() {
    	
        JFrame employeeFrame = new JFrame();
        employeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        employeeFrame.setTitle("Employee Frame");
        employeeFrame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        SpecialtyCMBX = new JComboBox<>();
        YearCMBX = new JComboBox<>();
        
        tabbedPane.addTab("Year", Year);
        
        Year.setLayout(null);
        
        JLabel YearLBL = new JLabel("Year");
		YearLBL.setBounds(10, 75, 125, 30);
		Year.add(YearLBL);
		
		
		YearTXT.setBounds(145, 85, 110, 20);
		Year.add(YearTXT);
		YearTXT.setColumns(10);
		
		JLabel SpecialtyIdLBL = new JLabel("Specialty ID");
		SpecialtyIdLBL.setBounds(10, 200, 125, 30);
		Year.add(SpecialtyIdLBL);
		
		JLabel SpecialtyNameLBL = new JLabel("Specialty Name");
		SpecialtyNameLBL.setBounds(10, 245, 125, 30);
		Year.add(SpecialtyNameLBL);
		
		SIdTXT.setColumns(10);
		SIdTXT.setBounds(145, 210, 110, 20);
		Year.add(SIdTXT);
		
		
		SNameTXT.setColumns(10);
		SNameTXT.setBounds(145, 250, 110, 20);
		Year.add(SNameTXT);
		
	
		YearCMBX.setBounds(440, 85, 138, 20);
		Year.add(YearCMBX);
		
		
		
		JButton AddYearBTN = new JButton("Add"); ////add year to the combobox
		AddYearBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String year = YearTXT.getText();
                YearCMBX.addItem(year);
                YearTXT.setText("");
                saveYearSpecToFile();
            }
        });

		AddYearBTN.setBounds(145, 120, 85, 20);
		Year.add(AddYearBTN);
		loadYearSpecFromFile();
		updateSpecialtyComboBox();
		
		JButton AddSpecialtyBTN = new JButton("Add");
		AddSpecialtyBTN.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	saveYearSpecToFile();
		        String selectedYear = (String) YearCMBX.getSelectedItem();
		        String specialtyId = SIdTXT.getText();
		        String specialtyName = SNameTXT.getText();
		        Specialty specialty = new Specialty(specialtyId,specialtyName);
		        List<Specialty> specialties = yearSpecialtiesMap.get(selectedYear);
		        if (specialties == null) {
		            specialties = new ArrayList<>();
		            yearSpecialtiesMap.put(selectedYear, specialties);
		        }
		        specialties.add(specialty);
		        UniversityYear universityYear = new UniversityYear(selectedYear);
		        universityYear.addSpecialty(specialty);
		        updateSpecialtyComboBox();
		        SIdTXT.setText("");
		        SNameTXT.setText("");
		        saveYearSpecToFile();
		    }
		});
		
		
		
		
		AddSpecialtyBTN.setBounds(145, 290, 85, 20);
		SpecialtyCMBX.setBounds(440, 210, 250, 20);
		Year.add(SpecialtyCMBX);
		SpecialtyCMBX.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            updateSpecialty2ComboBox();
	        }
	    });
		
		Year.add(AddSpecialtyBTN);
        
        tabbedPane.addTab("Courses", Course);
        Course.setLayout(null);
        
        Specialty2CMBX = new JComboBox<>();
        
        Specialty2CMBX.setBounds(228, 25, 230, 30);
        Course.add(Specialty2CMBX);
        
        JLabel CourseIdLBL = new JLabel("Course Id");
        CourseIdLBL.setBounds(10, 90, 150, 30);
        Course.add(CourseIdLBL);
        
        JLabel CourseNameLBL = new JLabel("Course Name");
        CourseNameLBL.setBounds(10, 145, 150, 30);
        Course.add(CourseNameLBL);
        
        JLabel ExamIdLBL = new JLabel("Exam Id");
        ExamIdLBL.setBounds(10, 270, 150, 30);
        Course.add(ExamIdLBL);
        
        JLabel ExamNameLBL = new JLabel("Exam Name");
        ExamNameLBL.setBounds(10, 320, 150, 30);
        Course.add(ExamNameLBL);
        
        JLabel ExamDateLBL = new JLabel("Exam Date");
        ExamDateLBL.setBounds(10, 425, 150, 30);
        Course.add(ExamDateLBL);
        
        JLabel ExamTypeLBL = new JLabel("Exam Type");
        ExamTypeLBL.setBounds(10, 380, 150, 30);
        Course.add(ExamTypeLBL);
        
        CourseNameTXT.setBounds(170, 150, 125, 20);
        Course.add(CourseNameTXT);
        CourseNameTXT.setColumns(10);
        
        
        CourseIdTXT.setColumns(10);
        CourseIdTXT.setBounds(170, 100, 125, 20);
        Course.add(CourseIdTXT);
        
        
        ExamIdTXT.setColumns(10);
        ExamIdTXT.setBounds(170, 275, 125, 20);
        Course.add(ExamIdTXT);
        
       
        ExamNameTXT.setColumns(10);
        ExamNameTXT.setBounds(170, 328, 125, 20);
        Course.add(ExamNameTXT);
        
        ExamTypeTXT.setColumns(10);
        ExamTypeTXT.setBounds(170, 385, 125, 20);
        Course.add(ExamTypeTXT);
        
        
        ExamDateTXT.setColumns(10);
        ExamDateTXT.setBounds(170, 435, 125, 20);
        Course.add(ExamDateTXT);
        
   /*     JButton GetSpecBTN = new JButton("Get Specialties");
        
        GetSpecBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 updateSpecialty2ComboBox();
            }
        });
        
        GetSpecBTN.setBounds(35, 25, 150, 30);
        Course.add(GetSpecBTN);
  */      
        updateSpecialty2ComboBox();
        
        CourseCMBX = new JComboBox<>();
        CourseCMBX.setBounds(515, 95, 230, 30);
        Course.add(CourseCMBX);
        
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(355, 275, 400, 200);
        Course.add(scrollPane);
        
        
        JButton AddCourseBTN = new JButton("Add");
        
        AddCourseBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String selectedSpecialty =(String) Specialty2CMBX.getSelectedItem();
                String courseId = CourseIdTXT.getText();
                String courseName = CourseNameTXT.getText();
                Course course =new Course(courseId, courseName);
                List <Course> Courses =specialtiesCourseMap.get(selectedSpecialty);
                if(Courses == null) {
                	Courses =new ArrayList<>();
                	specialtiesCourseMap.put(selectedSpecialty, Courses);
                }
                Courses.add(course);
                updateCourseComboBox();
                CourseIdTXT.setText("");
                CourseNameTXT.setText("");
                updateCourseCMBX3();
                saveCourseDataToFile();
            }
        });
        
        AddCourseBTN.setBounds(170, 200, 85, 20);
        Course.add(AddCourseBTN);
        
        JButton GetCourseBTN = new JButton("Get Courses");
        
        GetCourseBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadCourseDataFromFile();
            	updateCourseComboBox();
            	updateCourseCMBX3();
            }
        });
        loadCourseDataFromFile();
    	updateCourseComboBox();
    	updateCourseCMBX3();
        GetCourseBTN.setBounds(300, 200, 140, 20);
        Course.add(GetCourseBTN);
        
        
        
        
        
        JButton AddExamBTN = new JButton("Add");
        
        AddExamBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourseId = (String) CourseCMBX.getSelectedItem();
                String examId = ExamIdTXT.getText();
                String examName = ExamNameTXT.getText();
                String examType = ExamTypeTXT.getText();
                String examDate = ExamDateTXT.getText();
                Exam exam = new Exam(examId, examName, examType, examDate);

                List<Exam> exams = CourseExamMap.get(selectedCourseId);
                if (exams == null) {
                    exams = new ArrayList<>();
                    CourseExamMap.put(selectedCourseId, exams);
                }

                exams.add(exam);
                updateExamTable();
                updateExamCMBX();
                ExamIdTXT.setText("");
                ExamNameTXT.setText("");
                ExamTypeTXT.setText("");
                ExamDateTXT.setText("");
                saveExamDataToFile();
            }
        });
        
        




        
        AddExamBTN.setBounds(170, 490, 85, 20);
        Course.add(AddExamBTN);
        
        JButton GetExamBTN = new JButton("Get Exams");
        
        GetExamBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadExamDataFromFile();
            	updateExamTable();
            	updateExamCMBX();
            }
        });
        
        GetExamBTN.setBounds(300, 490, 140, 20);
        Course.add(GetExamBTN);
        
        tabbedPane.addTab("Exercice", Exercice);
        Exercice.setLayout(null);
        
        ExamCMBX = new JComboBox<>();
        ExamCMBX.setBounds(515, 40, 230, 30);
        Exercice.add(ExamCMBX);
        loadExamDataFromFile();
    	updateExamTable();
    	updateExamCMBX();
        
        JLabel ExerciseLBL = new JLabel("Exercise ID");
        ExerciseLBL.setBounds(20, 212, 150, 30);
        Exercice.add(ExerciseLBL);
        
        JLabel ExerciseValueLBL = new JLabel("Exercise Value");
        ExerciseValueLBL.setBounds(20, 252, 150, 30);
        Exercice.add(ExerciseValueLBL);
        
        
        ExerciseIdTXT.setColumns(10);
        ExerciseIdTXT.setBounds(170, 220, 125, 20);
        Exercice.add(ExerciseIdTXT);
        
        ExerciseValueTXT.setColumns(10);
        ExerciseValueTXT.setBounds(170, 260, 125, 20);
        Exercice.add(ExerciseValueTXT);
        
        JButton AddExerciseBTN = new JButton("Add");
        
        AddExerciseBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SelectedExamId = (String) ExamCMBX.getSelectedItem();
                String exerciseId = ExerciseIdTXT.getText();
                String exerciseVal = ExerciseValueTXT.getText();
                
                Exercise exercise= new Exercise (exerciseVal,exerciseId);
                List<Exercise> exercises = ExamExerciseMap.get(SelectedExamId);
                if (exercises == null) {
                    exercises = new ArrayList<>();
                    ExamExerciseMap.put(SelectedExamId, exercises);
                }
                
                exercises.add(exercise);
                saveExercisesToFile();
                updateExerciseTAREA();
                updateExerciseCMBX2();
               
            }
        });

        
        
        AddExerciseBTN.setBounds(170, 288, 85, 20);
        Exercice.add(AddExerciseBTN);
        
        JButton GetExerciseBTN = new JButton("Get Exercises");
        
        GetExerciseBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loadExercisesFromFile();
            	updateExerciseTAREA();
                updateExerciseCMBX2();
                
            }
        });

        
        
        GetExerciseBTN.setBounds(260, 288, 140, 20);
        Exercice.add(GetExerciseBTN);
        
        
        
        ExerciseTAREA.setBounds(425, 222, 300, 170);
        ExerciseTAREA.setLineWrap(true);
        ExerciseTAREA.setWrapStyleWord(true); 
        Exercice.add(ExerciseTAREA);
        loadExercisesFromFile();
    	updateExerciseTAREA();
        updateExerciseCMBX2();
        tabbedPane.addTab("Question", Questions);
        Questions.setLayout(null);
        
        
        
        ExerciseCMBX2.setBounds(415, 40, 330, 30);
        Questions.add(ExerciseCMBX2);
        
        JLabel QuestionContentLBL = new JLabel("Question Content");
        QuestionContentLBL.setBounds(10, 195, 150, 30);
        Questions.add(QuestionContentLBL);
        
        
        QuestionIdTXT.setColumns(10);
        QuestionIdTXT.setBounds(170, 160, 125, 20);
        Questions.add(QuestionIdTXT);
        
        JButton AddQuestionBTN = new JButton("Add");
        
        AddQuestionBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedExercise = (String) ExerciseCMBX2.getSelectedItem();
                String questionId = QuestionIdTXT.getText();
                String questionValue = QuestionContentTXT.getText();
                String questionPoint = QuestionNotesTXT.getText();

                Question question = new Question(questionId, questionValue, questionPoint);

                // Find the selected exercise
                List<Question> exerciseQuestions = ExerciseQuestionMap.get(selectedExercise);
                if (exerciseQuestions == null) {
                    exerciseQuestions = new ArrayList<>();
                    ExerciseQuestionMap.put(selectedExercise, exerciseQuestions);
                }

                // Add the question to the selected exercise
                exerciseQuestions.add(question);

                // Add the question to the QuestionsTAREA text area
                String questionText = questionId + ") " + questionValue + " (" + questionPoint + ")\n";
                QuestionsTAREA.append(questionText);
                updateQuestionArea();
                saveQuestionsToFile();
            }
        });



        
        
        AddQuestionBTN.setBounds(170, 375, 85, 20);
        Questions.add(AddQuestionBTN);
        
        JButton GetQuestionBTN = new JButton("Get Question");

        GetQuestionBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadQuestionsFromFile();
                updateQuestionArea();
            }
        });


        
        GetQuestionBTN.setBounds(260, 375, 140, 20);
        Questions.add(GetQuestionBTN);
        
        QuestionsTAREA.setBounds(425, 222, 300, 172);
        QuestionsTAREA.setLineWrap(true); // Enable line wrapping
        QuestionsTAREA.setWrapStyleWord(true); // Wrap at word boundaries
        Questions.add(QuestionsTAREA );
        
        JLabel QuestionIdLBL = new JLabel("Question Id");
        QuestionIdLBL.setBounds(10, 156, 150, 30);
        Questions.add(QuestionIdLBL);
        
        JLabel QuestionNoteLBL = new JLabel("Question Note");
        QuestionNoteLBL.setBounds(10, 290, 150, 30);
        Questions.add(QuestionNoteLBL);
        
        
        QuestionContentTXT.setColumns(10);
        QuestionContentTXT.setBounds(170, 200, 125, 20);
        Questions.add(QuestionContentTXT);
        
        
        QuestionNotesTXT.setColumns(10);
        QuestionNotesTXT.setBounds(170, 300, 125, 20);
        Questions.add(QuestionNotesTXT);
        loadQuestionsFromFile();
        updateQuestionArea();
        
        tabbedPane.addTab("Stud/Teach", Students);
        Students.setLayout(null);
        
//        JComboBox <String> Specialty3CMBX = new JComboBox<>();
//        Specialty3CMBX.setBounds(440, 250, 230, 30);
//        Students.add(Specialty3CMBX);
        
        JLabel TeacherNameLBL = new JLabel("Teacher Name");
        TeacherNameLBL.setBounds(12, 155, 148, 30);
        Students.add(TeacherNameLBL);
        
       
        TeacherIdTXT.setColumns(10);
        TeacherIdTXT.setBounds(170, 107, 125, 20);
        Students.add(TeacherIdTXT);
        
        JRadioButton MaleRDBTN = new JRadioButton("M");
        MaleRDBTN.setBounds(170, 408, 50, 20);
        Students.add(MaleRDBTN);
        
        JRadioButton FemaleRDBTN = new JRadioButton("F");
        FemaleRDBTN.setBounds(245, 408, 50, 20);
        Students.add(FemaleRDBTN);
        
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(MaleRDBTN);
        genderButtonGroup.add(FemaleRDBTN);
        
        JButton AddStudentBTN = new JButton("Add");
        
        AddStudentBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String StudentId = StudentIdTXT.getText();
                String StudentName = StudentNameTXT.getText();
                String gender = MaleRDBTN.isSelected() ? "M" : "F";

                model3.addRow(new Object[]{StudentId, StudentName, gender});

                // Clear the input fields and gender selection
                StudentIdTXT.setText("");
                StudentNameTXT.setText("");
                genderButtonGroup.clearSelection();
                populateStudentComboBox();
                saveStudentsToFile();
            }
        });
        
        AddStudentBTN.setBounds(170, 478, 85, 20);
        Students.add(AddStudentBTN);
        
//        JTextArea StudentTAREA = new JTextArea();
//        StudentTAREA.setBounds(639, 300, 222, 172);
//        Students.add(StudentTAREA);
        
        JTable StudentTable = new JTable(model3);
        JScrollPane StudentscrollPane = new JScrollPane(StudentTable);
        StudentscrollPane.setBounds(440, 300, 320, 172);
        Students.add(StudentscrollPane);
        loadStudentsFromFile();
        populateStudentComboBox();
        
        JLabel TeacherIdLBL = new JLabel("Teacher Id");
        TeacherIdLBL.setBounds(10, 100, 147, 30);
        Students.add(TeacherIdLBL);
        
        JLabel StudentIdLBL = new JLabel("Student Id");
        StudentIdLBL.setBounds(10, 294, 147, 30);
        Students.add(StudentIdLBL);
        
        
        TeacherNameTXT.setColumns(10);
        TeacherNameTXT.setBounds(170, 162, 125, 20);
        Students.add(TeacherNameTXT);
        
   
        StudentIdTXT.setColumns(10);
        StudentIdTXT.setBounds(170, 300, 125, 20);
        Students.add(StudentIdTXT);
        
//        JTextArea TeacherTAREA = new JTextArea();
//        TeacherTAREA.setBounds(640, 40, 222, 172);
//        Students.add(TeacherTAREA);
        
        JTable Teachertable = new JTable(model2);
        JScrollPane TeacherscrollPane = new JScrollPane(Teachertable);
        TeacherscrollPane.setBounds(440, 40, 222, 172);
        Students.add(TeacherscrollPane);
        
        
        JLabel StudentNameLBL = new JLabel("Student Name");
        StudentNameLBL.setBounds(12, 350, 148, 30);
        Students.add(StudentNameLBL);
        
        JLabel GenderLBL = new JLabel("Gender");
        GenderLBL.setBounds(12, 403, 148, 30);
        Students.add(GenderLBL);
        
     
        StudentNameTXT.setColumns(10);
        StudentNameTXT.setBounds(170, 355, 125, 20);
        Students.add(StudentNameTXT);
        
        JButton AddTeacherBTN = new JButton("Add");
        
        AddTeacherBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String teacherId = TeacherIdTXT.getText();
                String teacherName = TeacherNameTXT.getText();

                // Add the teacher to the table model
                model2.addRow(new Object[]{teacherId, teacherName});

                // Clear the input fields
                TeacherIdTXT.setText("");
                TeacherNameTXT.setText("");
                populateTeacherComboBox();
                saveTeachersToFile();
                
            }
        });
        
        AddTeacherBTN.setBounds(170, 220, 85, 20);
        Students.add(AddTeacherBTN);
        loadTeachersFromFile();
        populateTeacherComboBox();
        
        
        
        
        employeeFrame.getContentPane().add(tabbedPane);

        employeeFrame.setVisible(true);
        
        
        
        
        
    }
    
    private void openStudentFrame() {
        JFrame studentFrame = new JFrame();
        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentFrame.setTitle("Student Frame");
        studentFrame.setSize(800, 600);
        studentFrame.setVisible(true);
        studentFrame.setLayout(null);
        
        
        JLabel StudentNameLBL = new JLabel("Student Name");
        StudentNameLBL.setBounds(35, 40, 150, 30);
        studentFrame.add(StudentNameLBL);
        
        
        Student2CMBX.setBounds(35, 62, 229, 21);
        studentFrame.add(Student2CMBX);
        
        
        JLabel CourseLBL = new JLabel("Select Course");
        CourseLBL.setBounds(35, 110, 150, 30);
        studentFrame.add(CourseLBL);
        
        CourseCMBX3.setBounds(35, 133, 229, 21);
        studentFrame.add(CourseCMBX3);
        
        JLabel ExamLBL = new JLabel("Select Exam");
        ExamLBL.setBounds(35, 200, 150, 30);
        studentFrame.add(ExamLBL);
        
        ExamCMBX3.setBounds(35, 225, 229, 21);
        studentFrame.add(ExamCMBX3);
        
        JLabel ExerciceLBL = new JLabel("Select Exercice");
        ExerciceLBL.setBounds(35, 285, 150, 30);
        studentFrame.add(ExerciceLBL);
        
       
        ExerciseCMBX3.setBounds(35, 310, 300, 21);
        studentFrame.add(ExerciseCMBX3);
        
//        JTextArea ExamTXTAREA = new JTextArea();
//        ExamTXTAREA.setBounds(400, 62, 337, 269);
//        studentFrame.add(ExamTXTAREA);
        
        
        
        JTable QAndATBT = new JTable(model4);
        JScrollPane QAndATBTscrollPane = new JScrollPane(QAndATBT);
        QAndATBTscrollPane.setBounds(400, 62, 337, 269);
        studentFrame.add(QAndATBTscrollPane);
        
        
        
        
        
        
        
        JButton GetExams = new JButton("Get Exams");
        
        GetExams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the items in ExamCMBX3
                ExamCMBX3.removeAllItems();
                
                // Get the selected course
                String selectedCourse = CourseCMBX3.getSelectedItem().toString();
                
                // Retrieve the list of exams for the selected course
                List<Exam> exams = CourseExamMap.get(selectedCourse);
                
                // Add each exam to ExamCMBX3
                if (exams != null) {
                    for (Exam exam : exams) {
                        ExamCMBX3.addItem(exam.getExamId()+" "+exam.getEname()+" "+exam.getEType()+" "+exam.getDate());
                    }
                }
            }
        });


        
        GetExams.setBounds(35, 402, 150, 35);
        studentFrame.add(GetExams);
        
        JButton GetExercices = new JButton("Get Exercices");
        
        GetExercices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                
                ExerciseCMBX3.removeAllItems();
                
                String selectedExam = ExamCMBX3.getSelectedItem().toString();
                
                List<Exercise> exercises = ExamExerciseMap.get(selectedExam);
                
                if (exercises != null) {
                    for (Exercise exercise : exercises) {
                        ExerciseCMBX3.addItem("Exercise ID: "+exercise.getExerciseId()+" Exercise Value: "+exercise.getExerciseValue());
                    }
                }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
            });

        
        GetExercices.setBounds(35, 450, 150, 35);
        studentFrame.add(GetExercices);
    
    
    JButton GetQuestions= new JButton("Get Questions");
    
    GetQuestions.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) QAndATBT.getModel();
            model.setRowCount(0);

            String selectedExercise = ExerciseCMBX3.getSelectedItem().toString();

            List<Question> questions = ExerciseQuestionMap.get(selectedExercise);

            if (questions != null) {
                for (Question question : questions) {
                    model.addRow(new Object[]{question.getQcontent(), ""}); 
                    
                    
                    Map<String, String> exerciseAnswers = studentExerciseAnswersMap.getOrDefault(selectedExercise, new HashMap<>());
                    exerciseAnswers.put(question.getQid(), ""); 
                    studentExerciseAnswersMap.put(selectedExercise, exerciseAnswers);
                }
            }
        }
    });
    
    GetQuestions.setBounds(35, 500, 150, 35);
    studentFrame.add(GetQuestions);

    
    
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String selectedStudent = Student2CMBX.getSelectedItem().toString();
            String selectedExercise = ExerciseCMBX3.getSelectedItem().toString();

            DefaultTableModel model4 = (DefaultTableModel) QAndATBT.getModel();

            List<String> answers = new ArrayList<>();
            int rowCount = model4.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String question = model4.getValueAt(i, 0).toString();
                String answer = model4.getValueAt(i, 1).toString();

                answers.add(question + "," + answer);
            }

            saveAnswersToFile(selectedStudent, selectedExercise, answers);

            JOptionPane.showMessageDialog(null, "Answers saved successfully.");
        }
    });
    submitButton.setBounds(500, 500, 150, 35);
    studentFrame.add(submitButton);




    
}

    private void openTeacher1Frame() {
        JFrame teacherFrame1 = new JFrame();
        teacherFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        teacherFrame1.setTitle("Teacher 1 Frame");
        teacherFrame1.setSize(800, 600);
        teacherFrame1.setVisible(true);
        teacherFrame1.setLayout(null);
        
        JTextField EGradeTXT =new JTextField();
        JTextField ExeGradeTXT =new JTextField();
        
        JLabel TeacherLBL = new JLabel("Select Corrector");
        TeacherLBL.setBounds(35, 40, 150, 30);
        teacherFrame1.add(TeacherLBL);
        
        Teacher2CMBX.setBounds(35, 65, 200, 21);
        teacherFrame1.add(Teacher2CMBX);
        
        JLabel StudentNameLBL = new JLabel("Student Name");
        StudentNameLBL.setBounds(35, 100, 150, 30);
        teacherFrame1.add(StudentNameLBL);

        Student2CMBX.setBounds(35, 125, 200, 21);
        teacherFrame1.add(Student2CMBX);
        
        JLabel CourseLBL = new JLabel("Select Course");
        CourseLBL.setBounds(35, 155, 150, 30);
        teacherFrame1.add(CourseLBL);

        
        Course2CMBX.setBounds(35, 180, 200, 21);
        teacherFrame1.add(Course2CMBX);
        
        
        JLabel ExamLBL = new JLabel("Select Exam");
        ExamLBL.setBounds(35, 210, 200, 30);
        teacherFrame1.add(ExamLBL);

        JComboBox<String> Exam2CMBX = new JComboBox<>();
        
        
        Exam2CMBX.setBounds(35, 235, 240, 21);
        teacherFrame1.add(Exam2CMBX);
        
        JLabel ExerciseLBL = new JLabel("Select Exercise");
        ExerciseLBL.setBounds(35, 270, 150, 30);
        teacherFrame1.add(ExerciseLBL);

        
        Exercise2CMBX.setBounds(35, 295, 350, 21);
        teacherFrame1.add(Exercise2CMBX);

        
        
        
        
        
        JButton GetExams = new JButton("Get Exams");
        
        GetExams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            	Exam2CMBX.removeAllItems();
                
                String selectedCourse = CourseCMBX3.getSelectedItem().toString();
                
                List<Exam> exams = CourseExamMap.get(selectedCourse);
                
                if (exams != null) {
                    for (Exam exam : exams) {
                    	Exam2CMBX.addItem(exam.getExamId()+" "+exam.getEname()+" "+exam.getEType()+" "+exam.getDate());
                    }
                }
            }
        });
        
        JButton GetExercices = new JButton("Get Exercices");
        
        GetExercices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		Exercise2CMBX.removeAllItems();
                
            	String selectedExam = Exam2CMBX.getSelectedItem().toString();
                
                List<Exercise> exercises = ExamExerciseMap.get(selectedExam);
                
                if (exercises != null) {
                    for (Exercise exercise : exercises) {
                    	Exercise2CMBX.addItem("Exercise ID: "+exercise.getExerciseId()+" Exercise Value: "+exercise.getExerciseValue());
                    }
                }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
            });
        
        

        
        GetExercices.setBounds(35, 450, 150, 35);
        teacherFrame1.add(GetExercices);
        
        GetExams.setBounds(35, 402, 150, 35);
        teacherFrame1.add(GetExams);
        
        JTable QAndAAndN = new JTable(model5);
        JScrollPane QAndAAndNscrollPane = new JScrollPane(QAndAAndN);
        QAndAAndNscrollPane.setBounds(428, 75, 344, 222);
        teacherFrame1.add(QAndAAndNscrollPane);
        
        
         
  
        JButton getStudentAnswer = new JButton("Get Answers");
        getStudentAnswer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = Student2CMBX.getSelectedItem().toString();
                String selectedExercise = Exercise2CMBX.getSelectedItem().toString();

                try {
                    File file = new File("answers.txt");
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    String line;
                    boolean answerFound = false;
                    List<String[]> answers = new ArrayList<>();

                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",", 5);
                        String student = parts[0];
                        String exercise = parts[1];
                        String question = parts[2];
                        String answer = parts[3];

                        // Print the values for debugging
                   //     System.out.println("Student: " + student);
                   //     System.out.println("Exercise: " + exercise);
                   //     System.out.println("Question: " + question);
                   //    System.out.println("Answer: " + answer);

                        if (student.equals(selectedStudent) && exercise.equals(selectedExercise)) {
                            // Add the answer to the list
                            answers.add(new String[]{question, answer});
                            answerFound = true;
                        }
                    }

                    br.close();
                    fr.close();

                    DefaultTableModel model = (DefaultTableModel) QAndAAndN.getModel();
                    model.setRowCount(0); 

                    for (String[] answer : answers) {
                        model.addRow(new Object[]{ answer[0], answer[1]});
                    }

                    if (!answerFound) {
                    	EGradeTXT.setText("No answer found.");
                    }
                    else {
                    	EGradeTXT.setText("True")
                    	;}
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        getStudentAnswer.setBounds(35, 500, 150, 35);
        teacherFrame1.add(getStudentAnswer);

  

   /*     JButton ACalcBTN = new JButton("Submit Ex grade");
        ACalcBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        ACalcBTN.setBounds(428, 358, 153, 19);
        teacherFrame1.add(ACalcBTN);
*/
        JCheckBox finalExamCheckBox = new JCheckBox();
        finalExamCheckBox.setBounds(650, 500, 153, 21);
        teacherFrame1.add(finalExamCheckBox);
        

        JCheckBox partielExamCheckBox = new JCheckBox();
        partielExamCheckBox.setBounds(650, 530, 153, 21);
        teacherFrame1.add(partielExamCheckBox);
        
        JButton ECalcBTN = new JButton("Submit Exam Grade");
        ECalcBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = Student2CMBX.getSelectedItem().toString();
                String examName = Exam2CMBX.getSelectedItem().toString();
                String grade = ExeGradeTXT.getText();
                String examType = "";

                if (finalExamCheckBox.isSelected()) {
                    examType = "Final";

   //                 System.out.println("Student Name: " + studentName);
   //                 System.out.println("Exam Name: " + examName);
   //                 System.out.println("Grade: " + grade);
   //                 System.out.println("Exam Type: " + examType);

                    // Save the grade only if the exam type is "Final"
                    saveFinalFCGrade(studentName, examName, grade);
                } else if (partielExamCheckBox.isSelected()) {
                    examType = "Partiel";
                    savePartielFCGrade(studentName,examName,grade);
                } 
            }
        });
        ECalcBTN.setBounds(428, 427, 153, 21);
        teacherFrame1.add(ECalcBTN);

        
        ExeGradeTXT.setColumns(10);
        ExeGradeTXT.setBounds(683, 428, 96, 19);
        teacherFrame1.add(ExeGradeTXT);
        
        EGradeTXT.setBounds(683, 358, 96, 19);
        teacherFrame1.add(EGradeTXT);
        EGradeTXT.setColumns(10);
        
//        JTextArea QANTEREA = new JTextArea();
//        QANTEREA.setBounds(428, 75, 344, 222);
//        teacherFrame1.add(QANTEREA);
        
        
        
        JLabel finalExamLBL = new JLabel("Final");
        finalExamLBL.setBounds(600, 500, 153, 21);
        teacherFrame1.add(finalExamLBL);

        
        
        
        JLabel partielExamLBL = new JLabel("Partiel");
        partielExamLBL.setBounds(600, 530, 153, 21);
        teacherFrame1.add(partielExamLBL);
        
        
        
    }
    
    private void openTeacher2Frame() {
        JFrame teacherFrame2 = new JFrame();
        teacherFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        teacherFrame2.setTitle("Teacher Frame");
        teacherFrame2.setSize(800, 600);
        teacherFrame2.setVisible(true);
        teacherFrame2.setLayout(null);
        
        JTextField EGradeTXT3 =new JTextField();
        JTextField ExeGradeTXT3 =new JTextField();
        
        JLabel TeacherLBL = new JLabel("Select Corrector");
        TeacherLBL.setBounds(35, 40, 150, 30);
        teacherFrame2.add(TeacherLBL);
        
        Teacher2CMBX3.setBounds(35, 66, 193, 21);
        teacherFrame2.add(Teacher2CMBX3);

        JLabel StudentNameLBL = new JLabel("Student Name");
        StudentNameLBL.setBounds(35, 100, 150, 30);
        teacherFrame2.add(StudentNameLBL);
        
        Student2CMBX3.setBounds(35, 125, 193, 21);
        teacherFrame2.add(Student2CMBX3);

        JLabel CourseLBL = new JLabel("Select Course");
        CourseLBL.setBounds(35, 155, 150, 30);
        teacherFrame2.add(CourseLBL);
        
        Course2CMBX3.setBounds(35, 182, 193, 21);
        teacherFrame2.add(Course2CMBX3);
        
        JLabel ExamLBL = new JLabel("Select Exam");
        ExamLBL.setBounds(35, 210, 150, 30);
        teacherFrame2.add(ExamLBL);

        JComboBox<String> Exam2CMBX3 = new JComboBox<>();
        Exam2CMBX3.setBounds(35, 235, 193, 21);
        teacherFrame2.add(Exam2CMBX3);
        
        JLabel ExerciseLBL = new JLabel("Select Exercise");
        ExerciseLBL.setBounds(35, 270, 150, 30);
        teacherFrame2.add(ExerciseLBL);

        JComboBox<String> Exercise2CMBX3 = new JComboBox<>();
        Exercise2CMBX3.setBounds(35, 295, 350, 21);
        teacherFrame2.add(Exercise2CMBX3);

        
        EGradeTXT3.setBounds(683, 358, 96, 19);
        teacherFrame2.add(EGradeTXT3);
        EGradeTXT3.setColumns(10);
        
        JTable QAndAAndN2 = new JTable(model6);
        JScrollPane QAndAAndNscrollPane2 = new JScrollPane(QAndAAndN2);
        QAndAAndNscrollPane2.setBounds(428, 75, 344, 222);
        teacherFrame2.add(QAndAAndNscrollPane2);
        
        
        JButton GetExams = new JButton("Get Exams");
        GetExams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            	Exam2CMBX3.removeAllItems();
                
               
                String selectedCourse = CourseCMBX3.getSelectedItem().toString();
              
                List<Exam> exams = CourseExamMap.get(selectedCourse);
                
                if (exams != null) {
                    for (Exam exam : exams) {
                    	Exam2CMBX3.addItem(exam.getExamId()+" "+exam.getEname()+" "+exam.getEType()+" "+exam.getDate());
                    }
                }
            }
        });
        
        GetExams.setBounds(35, 402, 150, 35);
        teacherFrame2.add(GetExams);
        
       JButton GetExercices = new JButton("Get Exercices");
        
        GetExercices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		Exercise2CMBX3.removeAllItems();
                
                String selectedExam = ExamCMBX3.getSelectedItem().toString();
                
                List<Exercise> exercises = ExamExerciseMap.get(selectedExam);
                
                if (exercises != null) {
                    for (Exercise exercise : exercises) {
                    	Exercise2CMBX3.addItem("Exercise ID: "+exercise.getExerciseId()+", Exercise Value: "+exercise.getExerciseValue());
                    }
                }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
            });

        
        GetExercices.setBounds(35, 450, 150, 35);
        teacherFrame2.add(GetExercices);
        
        JButton GetStudentAnswer2= new JButton("Get Answers");
        GetStudentAnswer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                String selectedStudent = Student2CMBX.getSelectedItem().toString();
                String selectedExercise = Exercise2CMBX.getSelectedItem().toString();

                try {
                    File file = new File("answers.txt");
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    String line;
                    boolean answerFound = false;
                    List<String[]> answers = new ArrayList<>();

                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",", 5);
                        String student = parts[0];
                        String exercise = parts[1];
                        String question = parts[2];
                        String answer = parts[3];

                        // Print the values for debugging
                   //     System.out.println("Student: " + student);
                   //     System.out.println("Exercise: " + exercise);
                   //     System.out.println("Question: " + question);
                   //    System.out.println("Answer: " + answer);

                        if (student.equals(selectedStudent) && exercise.equals(selectedExercise)) {
                            // Add the answer to the list
                            answers.add(new String[]{question, answer});
                            answerFound = true;
                        }
                    }

                    br.close();
                    fr.close();

                    DefaultTableModel model = (DefaultTableModel) QAndAAndN2.getModel();
                    model.setRowCount(0);

                    for (String[] answer : answers) {
                        model.addRow(new Object[]{ answer[0], answer[1]});
                    }

                    if (!answerFound) {
                    	EGradeTXT3.setText("No answer found.");
                    }
                    else {EGradeTXT3.setText("True");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        GetStudentAnswer2.setBounds(35, 500, 150, 35);
        teacherFrame2.add(GetStudentAnswer2);
        

   /*     JButton ACalcBTN3 = new JButton("Submit Ex grade");
        ACalcBTN3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        ACalcBTN3.setBounds(428, 358, 153, 19);
        teacherFrame2.add(ACalcBTN3);
*/
        
        

        JCheckBox partielExamCheckBox = new JCheckBox();
        partielExamCheckBox.setBounds(650, 530, 153, 21);
        teacherFrame2.add(partielExamCheckBox);
        
        JCheckBox finalExamCheckBox = new JCheckBox();
        finalExamCheckBox.setBounds(650, 500, 153, 21);
        teacherFrame2.add(finalExamCheckBox);
        
        
        
      
       

       
        JButton ECalcBTN3 = new JButton("Submit Exam Grade");
        ECalcBTN3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = Student2CMBX3.getSelectedItem().toString();
                String examName = Exam2CMBX3.getSelectedItem().toString();
                String grade = ExeGradeTXT3.getText();
                String examType = "";

                if (finalExamCheckBox.isSelected()) {
                    examType = "Final";

   //                 System.out.println("Student Name: " + studentName);
   //                 System.out.println("Exam Name: " + examName);
   //                 System.out.println("Grade: " + grade);
   //                 System.out.println("Exam Type: " + examType);

                    // Save the grade only if the exam type is "Final"
                    saveFinalSCGrade(studentName, examName, grade);
                } else if (partielExamCheckBox.isSelected()) {
                    examType = "Partiel";
                    savePartielSCGrade(studentName,examName,grade);
                } 
            }
        });
        ECalcBTN3.setBounds(428, 427, 153, 21);
        teacherFrame2.add(ECalcBTN3);

    
        ExeGradeTXT3.setColumns(10);
        ExeGradeTXT3.setBounds(683, 428, 96, 19);
        teacherFrame2.add(ExeGradeTXT3);
        
//        JTextArea QANTEREA3 = new JTextArea();
//        QANTEREA3.setBounds(428, 75, 344, 222);
//        teacherFrame2.add(QANTEREA3);
        
        
        JLabel finalExamLBL = new JLabel("Final");
        finalExamLBL.setBounds(600, 500, 153, 21);
        teacherFrame2.add(finalExamLBL);

        
        
        
        JLabel partielExamLBL = new JLabel("Partiel");
        partielExamLBL.setBounds(600, 530, 153, 21);
        teacherFrame2.add(partielExamLBL);
        
        
        
    }

    

    private void openNotesFrame() {
        JFrame notesFrame = new JFrame();
        notesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        notesFrame.setTitle("Notes Frame");
        notesFrame.setSize(800, 600);
        notesFrame.setVisible(true);
        notesFrame.setLayout(null);
        
        
        
     //   JTextField FCourse1TXT =new JTextField();
        updateCourse4CMBX();
        
        Student2CMBX4.setBounds(538, 62, 229, 21);
        notesFrame.add(Student2CMBX4);
        
      
        Course4CMBX.setBounds(538, 137, 229, 21);
        notesFrame.add(Course4CMBX);
        
        
        Exam3CMBX.setBounds(538, 225, 229, 21);
        notesFrame.add(Exam3CMBX);
        
       JButton GetExams2 = new JButton("Get Exams");
        
       GetExams2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            	Exam3CMBX.removeAllItems();
      
                String selectedCourse = CourseCMBX3.getSelectedItem().toString();
                

                List<Exam> exams = CourseExamMap.get(selectedCourse);
                
                if (exams != null) {
                    for (Exam exam : exams) {
                    	Exam3CMBX.addItem(exam.getExamId()+" "+exam.getEname()+" "+exam.getEType()+" "+exam.getDate());
                    }
                }
            }
        });


        
       GetExams2.setBounds(40, 450, 150, 35);
       notesFrame.add(GetExams2);
        
       JButton GradeBTN = new JButton("Final Grade");
       GradeBTN.setBounds(41, 306, 150, 35);
       notesFrame.add(GradeBTN);

       
        
        
       
        FCourseTXT.setColumns(10);
        FCourseTXT.setBounds(280, 240, 96, 19);
        notesFrame.add(FCourseTXT);
        
//        FCourse1TXT.setColumns(10);
//        FCourse1TXT.setBounds(370, 180, 96, 19);
//        notesFrame.add(FCourse1TXT);
        
        
        FirstGradeTXT.setBounds(234, 60, 96, 19);
        notesFrame.add(FirstGradeTXT);
        FirstGradeTXT.setColumns(10);
        
        FristGrade1TXT.setBounds(370, 60, 96, 19);
        notesFrame.add(FristGrade1TXT);
        FristGrade1TXT.setColumns(10);
        
        JLabel Final = new JLabel("Final");
        Final.setBounds(240, 40, 96, 19);
        notesFrame.add(Final);
        
        JLabel Partiel = new JLabel("Partiel");
        Partiel.setBounds(374, 40, 96, 19);
        notesFrame.add(Partiel);
        
        JLabel FirstCorrectorLBL = new JLabel("First Corrector Grade");
        FirstCorrectorLBL.setBounds(41, 60, 158, 21);
        notesFrame.add(FirstCorrectorLBL);
        
        JLabel SecondCorrectorLBL = new JLabel("Second Corrector Grade");
        SecondCorrectorLBL.setBounds(41, 100, 158, 21);
        notesFrame.add(SecondCorrectorLBL);
        
        JLabel FinalGradeLBL = new JLabel("Final Exam Grade");
        FinalGradeLBL.setBounds(41, 140, 158, 21);
        notesFrame.add(FinalGradeLBL);
        
        JLabel FinalCourseLBL = new JLabel("Final Course Grade");
        FinalCourseLBL.setBounds(41, 240, 158, 21);
        notesFrame.add(FinalCourseLBL);
        
        SecGrade1TXT.setColumns(10);
        SecGrade1TXT.setBounds(370, 100, 96, 19);
        notesFrame.add(SecGrade1TXT);
        
  
        SecGradeTXT.setColumns(10);
        SecGradeTXT.setBounds(234, 100, 96, 19);
        notesFrame.add(SecGradeTXT);
        
  
        FirstGrade1TXT.setColumns(10);
        FirstGrade1TXT.setBounds(370, 140, 96, 19);
        notesFrame.add(FirstGrade1TXT);
        
        FGradeTXT.setColumns(10);
        FGradeTXT.setBounds(234, 140, 96, 19);
        notesFrame.add(FGradeTXT);
        
        GradeBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = Student2CMBX4.getSelectedItem().toString();
                String selectedExam = Exam3CMBX.getSelectedItem().toString();

                loadFinalSCGrade(selectedStudent, selectedExam);
 //               loadPartielSCGrade(selectedStudent,selectedExam);
 //               loadPartielFCGrade(selectedStudent,selectedExam);
                loadFinalFCGrade(selectedStudent,selectedExam);
                calculateFinalGrade();
  //              calculatePartielGrade();
    //            calculateFinalCourseGrade();
            }
        });
        
        JButton GradeBTN2 = new JButton("Partiel Grades");
        GradeBTN2.setBounds(40, 350, 150, 35);
        notesFrame.add(GradeBTN2);
        
        GradeBTN2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = Student2CMBX4.getSelectedItem().toString();
                String selectedExam = Exam3CMBX.getSelectedItem().toString();

  //              loadFinalSCGrade(selectedStudent, selectedExam);
                loadPartielSCGrade(selectedStudent,selectedExam);
                loadPartielFCGrade(selectedStudent,selectedExam);
  //              loadFinalFCGrade(selectedStudent,selectedExam);
  //              calculateFinalGrade();
                  calculatePartielGrade();
  //              calculateFinalCourseGrade();
            }
        });
        JButton GradeBTN3 = new JButton("Course Grades");
        GradeBTN3.setBounds(40, 400, 150, 35);
        notesFrame.add(GradeBTN3);
        
        GradeBTN3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
  //              String selectedStudent = Student2CMBX4.getSelectedItem().toString();
  //              String selectedExam = Exam3CMBX.getSelectedItem().toString();

  //              loadFinalSCGrade(selectedStudent, selectedExam);
  //              loadPartielSCGrade(selectedStudent,selectedExam);
   //             loadPartielFCGrade(selectedStudent,selectedExam);
  //              loadFinalFCGrade(selectedStudent,selectedExam);
  //              calculateFinalGrade();
  //              calculatePartielGrade();
                calculateFinalCourseGrade();
            }
        });
    }
  
}
