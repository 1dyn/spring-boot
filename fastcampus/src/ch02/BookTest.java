package ch02;

public class BookTest {

    public static void main(String[] args) {

        Book[] library = new Book[5];
        Book[] copyLibrary = new Book[5];

        for (int i = 0; i < library.length; i++) {
            library[i] = new Book("운영체제 " + (i + 1), "오희국");
            System.out.println(library[i]);
            library[i].bookInfo();
        }
        System.arraycopy(library, 0, copyLibrary, 0, library.length);

        System.out.println("카피한 Library");
        for (int i = 0; i < copyLibrary.length; i++) {
            System.out.println(copyLibrary[i]);
            copyLibrary[i].bookInfo();
        }

        library[0].setAuthor("강경태");
        library[0].setTitle("운영체제론 1");
        System.out.println(library[0] + ", " + copyLibrary[0]);
        library[0].bookInfo();
        copyLibrary[0].bookInfo();

    }
}
