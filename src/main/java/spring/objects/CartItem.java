package spring.objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.entities.Product;

/**
 * Created by Eoller on 20-Sep-17.
 */

public class CartItem {

    private Product product;

    private int quantity;

    public void increaseQuantity(int quantity){
        this.quantity += quantity;
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
