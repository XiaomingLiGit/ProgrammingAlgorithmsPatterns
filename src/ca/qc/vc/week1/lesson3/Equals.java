package ca.qc.vc.week1.lesson3;

public class Equals {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics");
        Book b2 = new Book("Java Basics");
        Book b3 = new Book("Advanced Java");

        System.out.println(b1.equals(b2)); // true
        System.out.println(b1.equals(b3)); // false
        System.out.println(b1 == b2);      // false (different references)
    }
}

//class Book {
//    String title;
//
//    Book(String title) {
//        this.title = title;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;  // Same object
//        }
//
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        Book other = (Book) obj;
//
//        return title.equals(other.title);  // Logical comparison
//    }
//}