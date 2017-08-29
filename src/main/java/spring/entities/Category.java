package spring.entities;

/**
 * Created by Eoller on 24-Aug-17.
 */
public class Category implements java.io.Serializable{
    private Long id;
    private String name;

    public Category(){}

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
