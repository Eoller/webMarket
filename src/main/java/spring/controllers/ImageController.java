package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.entities.Product;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eoller on 30-Aug-17.
 */
@Controller
public class ImageController {
    @Autowired
    private ShopServiceInterface shopServiceInterface;

    @RequestMapping(value = "/productImage/{id}", method = RequestMethod.GET)
    public void showImage(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = shopServiceInterface.searchProductById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(product.getPhoto());
        response.getOutputStream().close();
    }
}
