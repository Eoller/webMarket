package spring.entities;

import java.util.Arrays;

/**
 * Created by Eoller on 24-Aug-17.
 */
public class Product implements java.io.Serializable{
    private int id;
    private String name;
    private int price;
    private String dscr;
    private byte[] photo;
    private String uniqueNumber;
    private int categoryId;
    private int producerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        if (categoryId != product.categoryId) return false;
        if (producerId != product.producerId) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (dscr != null ? !dscr.equals(product.dscr) : product.dscr != null) return false;
        if (!Arrays.equals(photo, product.photo)) return false;
        if (uniqueNumber != null ? !uniqueNumber.equals(product.uniqueNumber) : product.uniqueNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (dscr != null ? dscr.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (uniqueNumber != null ? uniqueNumber.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + producerId;
        return result;
    }
}
