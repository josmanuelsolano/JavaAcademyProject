package com.softtek.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.services.CartService;

@Controller
@RequestMapping("carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@RequestMapping(value = "/")
	public ModelAndView carts() {
		logger.info("LIST CART CONTROLLER");
		ModelAndView model = new ModelAndView("carts/carts");
		List<CartEntity> carts = cartService.findAllCarts();
		model.addObject("carts", carts);
		return model;
	}

}
