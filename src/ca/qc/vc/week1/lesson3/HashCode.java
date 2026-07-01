package ca.qc.vc.week1.lesson3;

import java.util.HashSet;

class Book {
    String title;
    String author;

    Book(String title) {
        this.title = title;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book other = (Book) obj;
        return title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode(); // use String's hashCode
    }

    @Override
    public String toString() {
        return "Book[title=\"" + title + "\", author=\"" + author + "\"]";
    }
}

public class HashCode {

    public static void main(String[] args) {
        Book b1 = new Book("Java");
        Book b2 = new Book("Java");

        System.out.println(b1.equals(b2));   // true
        System.out.println(b1.hashCode());   // same hash code
        System.out.println(b2.hashCode());

        HashSet<Book> set = new HashSet<>();

        set.add(b1);
        set.add(b2); // will not add a duplicate because equals() and hashCode() are aligned

        System.out.println(set.size()); // 1
    }
}

