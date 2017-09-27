package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.entities.Category;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;

import javax.validation.Valid;

/**
 * Created by Eoller on 11-Sep-17.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceInterface categoryService;

    @Autowired
    private ProducerServiceInterface producerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCategory(ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        modelMap.addAttribute("producerList", producerService.getProducers());
        modelMap.addAttribute("category", new Category());
        return "admin/categoryAdding";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategoryPost(@Valid @ModelAttribute("category") Category category , Errors errors, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        if(errors.hasErrors()){
            return "admin/categoryAdding";
        }
        categoryService.addCategory(category);
        return "redirect:/all";
    }

    /**
     * Remove category by id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Long id, ModelMap modelMap){
        categoryService.deleteCategory(id);
        return "redirect:/admin";
    }
}
