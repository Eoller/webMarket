package spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import spring.dao.CategoryDaoImpl;
import spring.dao.CategoryDaoInterface;
import spring.dao.ProductDaoInterface;
import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;
import spring.objects.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private ProductDaoInterface productDaoInterface;
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
		return "main";
	}

	@RequestMapping(value = "/aa", method = RequestMethod.GET)
	public String jumpa(ModelMap modelMap){
		Category random = categoryDaoInterface.getCategories().get(1);
		Product noaw = productDaoInterface.getProducts(random).get(0);
		modelMap.addAttribute("product", noaw);
		return "main";
	}
}
