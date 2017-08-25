package spring.entities;

import java.util.Arrays;

/**
 * Created by Eoller on 24-Aug-17.
 */
public class Product implements java.io.Serializable{
    private Long id;
    private String name;
    private Long price;
    private String dscr;
    private byte[] photo;
    private String uniqueNumber;
    private Category categoryId;
    private Producer producerId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (dscr != null ? !dscr.equals(product.dscr) : product.dscr != null) return false;
        if (!Arrays.equals(photo, product.photo)) return false;
        if (uniqueNumber != null ? !uniqueNumber.equals(product.uniqueNumber) : product.uniqueNumber != null)
            return false;
        if (!categoryId.equals(product.categoryId)) return false;
        return producerId.equals(product.producerId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (dscr != null ? dscr.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (uniqueNumber != null ? uniqueNumber.hashCode() : 0);
        result = 31 * result + categoryId.hashCode();
        result = 31 * result + producerId.hashCode();
        return result;
    }
}
