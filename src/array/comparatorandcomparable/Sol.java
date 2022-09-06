package array.comparatorandcomparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sol {
    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Effective Java", "Joshua Bloch", 32));
        listOfBooks.add(new Book("Java Puzzlers", "Joshua Bloch", 22));
        listOfBooks.add(new Book("Java Concurrency in Practice", "Brian Goetz", 42));
        listOfBooks.add(new Book("Java SE 8 for Really Impatient", "Cay S. Horstmann", 34));
        listOfBooks.add(new Book("Core Java", "Cay S. Horstmann",32));

       System.out.println("By Price using method reference");

        listOfBooks.sort(Comparator.comparing(Book::getPrice));
        for(Book book:listOfBooks)
        {
            System.out.println(book);
        }

        System.out.println("Multiple fields sorting");
        listOfBooks.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getPrice));
        for(Book book:listOfBooks)
        {
            System.out.println(book);
        }

    }
}
