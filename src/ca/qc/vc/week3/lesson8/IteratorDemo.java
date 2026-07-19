package ca.qc.vc.week3.lesson8;

import java.util.Iterator;

class BookShelf implements Iterable<String> {
    private String[] books;

    public BookShelf(String[] books) {
        this.books = books;
    }

    @Override
    public Iterator<String> iterator() {
        return new BookIterator();
    }

    private class BookIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public String next() {
            return books[index++];
        }
    }
}



public class IteratorDemo {
    public class BookShelfDemo {
        public static void main(String[] args) {
            BookShelf shelf = new BookShelf(new String[] {
                    "Clean Code",
                    "Effective Java",
                    "Design Patterns"
            });

            for (String book : shelf) {
                System.out.println(book);
            }
        }
    }

}
