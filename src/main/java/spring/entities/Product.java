package spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 * Created by Eoller on 24-Aug-17.
 */
public class Product implements java.io.Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotEmpty
    @Size(min = 3, max = 15)
    private String name;

    @JsonProperty("price")
    @Min(100)
    private Long price;

    @JsonIgnore
    @NotEmpty
    private String dscr;

    @JsonIgnore
    private byte[] photo;
    @JsonIgnore
    @NotEmpty
    @Size(min = 3, max = 30)
    private String uniqueNumber;
    @JsonIgnore
    private Category categoryId;
    @JsonIgnore
    private Producer producerId;

    public Product() {
    }

    public Product(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.dscr = product.getDscr();
        this.photo = product.getPhoto();
        this.uniqueNumber = product.getUniqueNumber();
        this.categoryId = product.getCategoryId();
        this.producerId = product.getProducerId();
    }

    public void changeVar(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.dscr = product.getDscr();
        if (product.getPhoto() != null) {
            this.photo = product.getPhoto();
        }
        if(product.getUniqueNumber() != null){
            this.uniqueNumber = product.getUniqueNumber();
        }
        if(product.getCategoryId() != null){
            this.categoryId = product.getCategoryId();
        }
        if(product.producerId != null){
            this.producerId = product.getProducerId();
        }
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDscr() {
        return dscr;
    }

    public void setDscr(String dscr) {
        this.dscr = dscr;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Producer getProducerId() {
        return producerId;
    }

    public void setProducerId(Producer producerId) {
        this.producerId = producerId;
    }

}
