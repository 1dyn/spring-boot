package ch02;

import java.util.ArrayList;

public class ArrListTest {

    public static void main(String[] args) {

        ArrayList<Book> library = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        library.add(new Book("운영체제" + (i + 1), "오희국"));

        for (int i = 0; i < library.size(); i++) {
            library.get(i).bookInfo();
        }

    }
}
