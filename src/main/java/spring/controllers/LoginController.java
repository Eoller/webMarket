package spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import spring.dao.CategoryDaoImpl;
import spring.dao.CategoryDaoInterface;
import spring.dao.ProductDaoInterface;
import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;
import spring.objects.SearchCriteria;
import spring.objects.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private ShopServiceInterface shopServiceInterface;
	@Autowired
	private CategoryDaoInterface categoryDaoInterface;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session) {

		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());

		return new ModelAndView("login", "user", new User());
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("user") User user) {
		return new ModelAndView("main", "user", user);
	}

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String jump(ModelMap modelMap){
		modelMap.addAttribute("searchCriteria", new SearchCriteria());
		modelMap.addAttribute("genres", categoryDaoInterface.getCategories());
		return "main";
	}

	@RequestMapping(value = "/a", method = RequestMethod.POST)
	public String answer(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, ModelMap modelMap){
		modelMap.addAttribute("genres", categoryDaoInterface.getCategories());
		modelMap.addAttribute("list", shopServiceInterface.searchProductBySearchString(searchCriteria.getSearchString()));
		return "main";
	}

	@RequestMapping(value = "/aa", method = RequestMethod.GET)
	public String jumpa(ModelMap modelMap){
		Category random = categoryDaoInterface.getCategories().get(1);
		modelMap.addAttribute("product", random);
		return "main";
	}
	@RequestMapping(value = "/gen", method = RequestMethod.GET)
	public String genrSearch(ModelMap modelMap){
		modelMap.addAttribute("searchCriteria", new SearchCriteria());
		modelMap.addAttribute("genres", categoryDaoInterface.getCategories());
		return "main";
	}

	@RequestMapping(value = "/gen/{id}/{name}", method = RequestMethod.GET)
	public String genrSearch(@ModelAttribute("id") Long id, @ModelAttribute("name") String name, ModelMap modelMap){
		modelMap.addAttribute("searchCriteria", new SearchCriteria());
		modelMap.addAttribute("genres", categoryDaoInterface.getCategories());
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		modelMap.addAttribute("list", shopServiceInterface.searchProductByCategory(category));
		return "main";
	}

	@RequestMapping(value = "/gen/{genre}", method = RequestMethod.GET)
	public String genrSearchNew(@ModelAttribute("genre") Category category, ModelMap modelMap){
		modelMap.addAttribute("searchCriteria", new SearchCriteria());
		modelMap.addAttribute("list", shopServiceInterface.searchProductByCategory(category));
		return "main";
	}

}
