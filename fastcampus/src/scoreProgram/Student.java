package scoreProgram;

import java.util.ArrayList;

public class Student {

    private static int idNum = 1000;

    private String studentName;
    private int studentId;
    private int courseCount;


    ArrayList<Subject> course = new ArrayList<>();

    public Student(String studentName) {
        this.studentName = studentName;
        this.studentId = ++idNum;
    }

    public void take(String name, int score) {
        Subject subject = new Subject(name, score);
        course.add(subject);
        courseCount++;
    }
    public void totalScore() {
        int total = 0;
        System.out.println(studentName + "학생이 수강한 과목은 " + courseCount + "개 입니다.");
        for (Subject i : course) {
            total += i.getScore();
            System.out.println(studentName + "학생의 '" + i.getSubjectName() + "' 과목 성적은 " + i.getScore() + "점 입니다.");
        }
        System.out.println(studentId + "학번 " + studentName + "학생의 과목 총점은 " + total + "점 입니다.");
    }
}
