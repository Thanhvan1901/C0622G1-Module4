package codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nameCategory ;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blog ;

    public Category() {
    }

    public Category(int id, String nameCategory, Set<Blog> blogs) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.blog = blogs;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Blog> getBlogs() {
        return blog;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blog = blog;
    }
}
