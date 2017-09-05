package spring.dto;


/**
 * Created by Eoller on 05-Sep-17.
 */
public class ProductDto {
    private String name;
    private Long price;
    private String dscr;
    private byte[] photo;
    private String uniqueNumber;
    private Long categoryId;
    private Long producerId;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
}
