package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;
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
    public String addProducer(ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        modelMap.addAttribute("producerList", producerService.getProducers());
        modelMap.addAttribute("producer", new Producer());
        return "admin/producerAdding";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProducerPost(@ModelAttribute("producer")Producer producer, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        producerService.addProducer(producer);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProducer(ModelMap modelMap, @PathVariable Long id){
        producerService.deleteProducer(id);
        return "redirect:/admin";
    }
}
