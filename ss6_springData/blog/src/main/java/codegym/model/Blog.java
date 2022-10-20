package codegym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private int id ;
    private String blogCreator ;
    private String blogName ;
    @Column(columnDefinition = "date")
    private String date ;
    @Column(columnDefinition = "text")
    private String content ;

    public Blog() {
    }

    public Blog(int id, String blogCreator, String blogName, String date, String content) {
        this.id = id;
        this.blogCreator = blogCreator;
        this.blogName = blogName;
        this.date = date;
        this.content = content;
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
}
