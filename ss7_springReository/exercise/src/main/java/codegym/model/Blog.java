package codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id ;
    private String blogCreator ;
    private String blogName ;
    @Column(columnDefinition = "date")
    private String date ;
    @Column(columnDefinition = "text")
    private String content ;

    @ManyToOne
    @JoinColumn(name = "category",referencedColumnName = "id")
    private Category category ;

    public Blog() {
    }

    public Blog(int id, String blogCreator, String blogName, String date, String content) {
        this.id = id;
        this.blogCreator = blogCreator;
        this.blogName = blogName;
        this.date = date;
        this.content = content;
    }

    public Blog(int id, String blogCreator, String blogName, String date, String content, Category category) {
        this.id = id;
        this.blogCreator = blogCreator;
        this.blogName = blogName;
        this.date = date;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogCreator() {
        return blogCreator;
    }

    public void setBlogCreator(String blogCreator) {
        this.blogCreator = blogCreator;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
