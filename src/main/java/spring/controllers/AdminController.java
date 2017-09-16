package spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;
import spring.services.ShopServiceInterface;

/**
 * Created by Eoller on 11-Sep-17.
 Admin account controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ShopServiceInterface shopService;
    @Autowired
    private CategoryServiceInterface categoryService;
    @Autowired
    private ProducerServiceInterface producerServiceInterface;

    /**
     * Shows admin menu
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
        modelMap.addAttribute("active", "admin");
        return "admin/menu";
    }

}
