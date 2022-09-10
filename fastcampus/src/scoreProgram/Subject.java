package scoreProgram;

public class Subject {


    private String subjectName;
    private int score;


    public Subject(String subjectName, int score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
