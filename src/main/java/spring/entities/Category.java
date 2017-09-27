package spring.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Eoller on 24-Aug-17.
 */
public class Category implements java.io.Serializable{
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 15, message = "{categoryName.size}")
    private String name;

    public Category(){}

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }


    public Category(Long id){
        this.id = id;
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
