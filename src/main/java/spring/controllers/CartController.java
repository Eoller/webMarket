package spring.controllers;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.objects.Cart;
import spring.objects.CartItem;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eoller on 20-Sep-17.
 */
@Controller
public class CartController {

    @Autowired
    ShopServiceInterface shopServiceInterface;

    @RequestMapping(value = "/cart/add/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable("id") Long id , ModelMap modelMap, HttpSession httpSession){
        if(httpSession.getAttribute("cart") == null){
            Cart cart = new Cart();
            cart.addItem(new CartItem(shopServiceInterface.getProductById(id), 1));
            httpSession.setAttribute("cart", cart);
            httpSession.setAttribute("cartSize", cart.getSize());
        }else{
            Cart cart = (Cart) httpSession.getAttribute("cart");
            cart.addItem(new CartItem(shopServiceInterface.getProductById(id),1));
            httpSession.setAttribute("cart", cart);
            httpSession.setAttribute("cartSize", cart.getSize());
        }

        //Cart cart = (Cart) httpSession.getAttribute("cart");
        //modelMap.addAttribute("cartList", cart.getProductList());
        return "redirect:/showDetails/" + id;
    }

    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.GET)
    public String deleteFromCart(@PathVariable("id") Long id, ModelMap modelMap, HttpSession httpSession){
        Cart cart = (Cart)httpSession.getAttribute("cart");
        cart.removeItem(id);
        httpSession.setAttribute("cart", cart);
        httpSession.setAttribute("cartSize", cart.getSize());
        return "redirect:/all";
    }

    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFromCartAjax(@PathVariable Long id,HttpSession httpSession){
        Cart cart = (Cart)httpSession.getAttribute("cart");
        cart.removeItem(id);
        httpSession.setAttribute("cart", cart);
        httpSession.setAttribute("cartSize", cart.getSize());
        return id.toString();
    }



    @RequestMapping(value = "/ajax/test/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cart ajaxTest(@PathVariable Long id,HttpSession httpSession){
        Cart cart = new Cart();
        cart.addItem(new CartItem(shopServiceInterface.getProductById(id),1));
        return cart;
    }




}
