package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ProductService;

@Controller
public class HomeController {
	private ProductService productService;
	
	@Autowired(required=true)
	@Qualifier(value="productService")
	public void setPersonService(ProductService ps){
		this.productService = ps;
	}
	
	@RequestMapping(value={"/","/main"}, method = RequestMethod.GET)
	public String mainPage(Model model) {
		return "home";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());
		return "products";
	}
}
