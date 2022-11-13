package com.moho;

public class dd {

    public static void main(String[] args) {
        Book[] bookArray1 = new Book[3];
        Book[] bookArray2 = new Book[3];

        bookArray1[0] = new Book("태백1", "조정래");
        bookArray1[1] = new Book("태백2", "조정래");
        bookArray1[2] = new Book("태백3", "조정래");

        System.arraycopy(bookArray1, 0, bookArray2, 0, 3);

        for (int i = 0; i < bookArray2.length; i++) {
            bookArray2[i].toString1();
        }

        bookArray1[0].setBookName("나목");
        bookArray1[0].setName("박규");

        for (int i = 0; i < bookArray1.length; i++) {
            bookArray1[i].toString1();
        }

        for (int i = 0; i < bookArray2.length; i++) {
            bookArray2[i].toString1();
        }

    }

    static class Book {
        String bookName;
        String name;

        public Book() {
        }

        public Book(String bookName, String name) {
            this.bookName = bookName;
            this.name = name;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void toString1() {
            System.out.println(bookName + ", " + name);
        }
    }
}
