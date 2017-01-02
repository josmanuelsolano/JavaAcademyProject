package com.softtek.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.jpa.domain.CartDetails;
import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.domain.ShipToEntity;
import com.softtek.jpa.domain.StatusEntity;
import com.softtek.jpa.services.CartService;
import com.softtek.jpa.services.ShipToService;
import com.softtek.jpa.services.StatusService;

@Controller
@RequestMapping("carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ShipToService shipToService;
	
	@Autowired
	private StatusService statusService;
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@RequestMapping(value = "")
	public ModelAndView carts() {
		logger.info("LIST CART CONTROLLER");
		ModelAndView model = new ModelAndView("carts");
		List<CartEntity> carts = cartService.findAllCarts();
		model.addObject("carts", carts);
		return model;
	}
	
	@RequestMapping(value = "/edit/{cartId}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("cartId") Long cartId) {
		ModelAndView model = new ModelAndView("carts/edit");
		CartEntity cart = cartService.findByCartKey(cartId);
		model.addObject("cart", cart);
		List<ShipToEntity> shipTos = shipToService.findAllShipTos();
		model.addObject("shipTos", shipTos);
		List<StatusEntity> cartStatus = statusService.findAllStatus();
		model.addObject("cartStatus", cartStatus);
		return model;
	 }
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("cart") CartEntity cartModel, 
			@ModelAttribute("id") Long cartId,
			@ModelAttribute("shipToId") Long shipTo,
			@ModelAttribute("statusId") Long statusId) {
		logger.info("UPDATE METHOD LOGGER: " + cartModel.getCartKey().getCartId().toString());
		CartEntity cart = cartService.findByCartKey(cartId);
		logger.info("UPDATE METHOD CONTROLLER: ", cart.getCartKey().getCartId());
		cart.setCartDetails(new CartDetails(new ShipToEntity(shipTo), new StatusEntity(statusId)));
		if (cartService.update(cart)) {
			ModelAndView model = new ModelAndView("redirect:/carts");
			return model;
		}
	
		ModelAndView model = new ModelAndView("carts/edit");
		List<ShipToEntity> shipTos = shipToService.findAllShipTos();
		model.addObject("shipTos", shipTos);
		List<StatusEntity> cartStatus = statusService.findAllStatus();
		model.addObject("cartStatus", cartStatus);
		model.addObject("cart", cart);
		model.addObject("msg", new String("Please check the required fields."));
		return model;
	}

}