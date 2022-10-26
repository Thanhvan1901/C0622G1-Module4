package codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String bookName ;

    private int totalBook ;

    @OneToMany(mappedBy = "book")
    private Set<Borrowed> borrowed ;

    public Book() {
    }

    public Book(int id, String bookName, int totalBook, Set<Borrowed> borrowed) {
        this.id = id;
        this.bookName = bookName;
        this.totalBook = totalBook;
        this.borrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    public Set<Borrowed> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Set<Borrowed> borrowed) {
        this.borrowed = borrowed;
    }
}
