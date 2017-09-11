package spring.controllers;

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

    @Autowired
    private ShopServiceInterface shopService;
    @Autowired
    private CategoryServiceInterface categoryService;
    @Autowired
    private ProducerServiceInterface producerService;

    /**
     * Shows admin menu
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories() );
        return "admin/menu";
    }



    @ModelAttribute
    public SearchCriteria searchCriteria(){
        return new SearchCriteria();
    }
}
