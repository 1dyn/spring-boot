package scoreProgram;

public class ScoreTest {

    public static void main(String[] args) {

        Student studentLee = new Student("Lee");
        Student studentKim = new Student("Kim");

        studentLee.take("국어", 100);
        studentLee.take("수학", 50);

        studentKim.take("국어", 70);
        studentKim.take("수학", 85);
        studentKim.take("영어", 100);

        studentLee.totalScore();
        System.out.println("===================");
        studentKim.totalScore();

    }
}
