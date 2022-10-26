package codegym.model;


import javax.persistence.*;

@Entity
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int code ;

    private String date ;

    @ManyToOne
    @JoinColumn(name = "id_book" , referencedColumnName = "id")
    private Book book ;

    public Borrowed() {
    }

    public Borrowed(int id, int code, String date, Book book) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.book = book;
    }

    public Borrowed(int code, String date, Book book) {
        this.code = code;
        this.date = date;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBooks(Book books) {
        this.book = book;
    }
}
