package spring.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eoller on 20-Sep-17.
 */
public class Cart implements Serializable {


    private List<CartItem> productList = new ArrayList<CartItem>();

    private Long totalPrice;

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<CartItem> getProductList() {
        return productList;
    }

    public void setProductList(List<CartItem> productList) {
        this.productList = productList;
    }


    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart(List<CartItem> productList) {
        this.productList = productList;
    }

    public Cart() {
        totalPrice = 0l;
        size = 0;
    }

    public void addItem(CartItem cartItem) {
        for (CartItem item : this.productList) {
            if (cartItem.getProduct().getId() == item.getProduct().getId()) {
                item.increaseQuantity(cartItem.getQuantity());
                totalPrice += cartItem.getProduct().getPrice();
                size++;
                return;
            }
        }
        this.productList.add(cartItem);
        size++;
        totalPrice += cartItem.getProduct().getPrice();
    }

    public void removeItem(Long id){
        for(int i=0; i < productList.size(); i++){
            if(productList.get(i).getProduct().getId() == id){
                CartItem cartItem = productList.get(i);
                totalPrice = totalPrice - (cartItem.getProduct().getPrice()*cartItem.getQuantity());
                size = size - cartItem.getQuantity();
                productList.remove(i);
                return;
            }
        }
    }
}
