package ch02;

public class CharArrTest {

    public static void main(String[] args) {

        char arr[] = new char[26];
        char ch = 'A';

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ch++;
        }
        for (char i : arr) {
            System.out.println(i);
        }

    }
}
