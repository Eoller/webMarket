package spring.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Eoller on 24-Aug-17.
 */
public class Producer {
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 15)
    private String name;

    public Producer(){}

    public Producer(Long id){
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
