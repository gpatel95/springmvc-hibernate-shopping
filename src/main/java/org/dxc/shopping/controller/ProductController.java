package org.dxc.shopping.controller;

import java.util.List;

import org.dxc.shopping.entity.Product;
import org.dxc.shopping.service.ProductService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ProductController {
	@Autowired
	private ProductService productService;

	public Logger logger = Logger.getLogger(ProductController.class.getName());

	@RequestMapping("/")
	public String showIndexPage() {
		logger.info("=========showIndexPage() called==============");
		return "index";
	}

	@RequestMapping("/addproduct")
	public String showAddProductPage(@ModelAttribute("product") Product product) {
		logger.info("==========showAddProductPage===============");
		return "add-product";

	}

	@RequestMapping(value = "/addnewproduct", method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") Product product, BindingResult result, Model model) {
		logger.info("==========addNewProduct===============");
		if (result.hasErrors()) {
			logger.info("==========Binding error===============");
			return "add-product";
		} else {
			logger.info("==========Binding success===============");
			productService.saveProduct(product);
			model.addAttribute("product", product);
			return "success";

		}
	}

	@RequestMapping("/displayproduct")
	public ModelAndView showAllProduct() {
		logger.info("=========showAllProduct() called==============");
		List<Product> allproduct = productService.getProducts();
		ModelAndView modelAndView = new ModelAndView("view-product");
		modelAndView.addObject("listOfProduct", allproduct);
		return modelAndView;

	}
    @RequestMapping("/update")
	public String updateProduct(@RequestParam("id") int id, Model model) {
		logger.info("=========updateProduct() called==============");
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "add-product";

	}
    @RequestMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id, Model model) {
    	logger.info("=========deleteproduct() called==============");
    	productService.deleteProduct(id);
		return "redirect:/displayproduct";
    	
    	
    }

}
