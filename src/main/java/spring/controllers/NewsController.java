package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.dao.CategoryDaoInterface;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.NewsServiceInterface;

/**
 * Created by Eoller on 11-Sep-17.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsServiceInterface newsService;

    @Autowired
    private CategoryServiceInterface categoryService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String showNews(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, ModelMap modelMap ){
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        modelMap.addAttribute("news", newsService.getAllNews());
        return "news";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteNews(@PathVariable("id") Long id, @ModelAttribute("searchCriteria") SearchCriteria searchCriteria, ModelMap modelMap){
        newsService.deleteNews(id);
        return "redirect:/news/getAll";
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public String readNews(@PathVariable("id") Long id, @ModelAttribute("searchCriteria") SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("news", newsService.getNewsById(id));
        modelMap.addAttribute("categoryList", categoryService.getCategories());
        return "read";
    }


    @ModelAttribute
    public SearchCriteria searchCriteria(){
        return new SearchCriteria();
    }

}
