package ch02;


public class Student {

        int studentId;
        String studentName;

        Subject korea;
        Subject math;

        Student(int studentId, String studentName) {
                this.studentId = studentId;
                this.studentName = studentName;

                korea = new Subject();
                math = new Subject();
        }
        public void setKoreaSubject(String subjectName, int score) {
                korea.subjectName = subjectName;
                korea.score = score;
        }
        public void setMathSubject(String name, int score) {
                math.subjectName = name;
                math.score = score;
        }

        public void showScore() {
                int total = korea.score + math.score;
                System.out.println(studentName + "학생의 총점은 " + total + " 입니다.");
        }
}
