package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.entities.Category;
import spring.entities.Producer;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;

/**
 * Created by Eoller on 11-Sep-17.
 */

@Controller
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerServiceInterface producerService;

    @Autowired
    private CategoryServiceInterface categoryService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProducer(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        modelMap.addAttribute("producer", new Producer());
        return "categoryAdding";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProducerPost(@ModelAttribute SearchCriteria searchCriteria,@ModelAttribute("producer") Category category , ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        categoryService.addCategory(category);
        return "redirect:/all";
    }

    @ModelAttribute
    public SearchCriteria searchCriteria(){
        return new SearchCriteria();
    }
}
