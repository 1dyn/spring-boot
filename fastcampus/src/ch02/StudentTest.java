package ch02;

public class StudentTest {
    public static void main(String[] args) {

        Student studentLee = new Student(1234, "Lee");
        studentLee.setKoreaSubject("국어", 100);
        studentLee.setMathSubject("수학", 90);

        Student studentKim = new Student(4321, "Kim");
        studentKim.setKoreaSubject("국어", 50);
        studentKim.setMathSubject("수학", 30);

        studentLee.showScore();
        studentKim.showScore();
    }
}
