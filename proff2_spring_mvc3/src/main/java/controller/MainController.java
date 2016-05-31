package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String mainPage(Model model) {
		return "main";
	}

	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public String listPersons(Model model) {
		//
		List<String> products = new ArrayList<String>();
		products.add("Рыба");
		products.add("Мясо");
		products.add("Колбаса");
		model.addAttribute("products", products);
		//
		model.addAttribute("nameUser", "Ivanov");
		return "forms";
	}


}
