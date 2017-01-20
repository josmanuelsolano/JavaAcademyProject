package com.softtek.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String carts() {
		return "carts";
	}
	
	@RequestMapping(value = "carts")
	public @ResponseBody List<CartEntity> cartsData() {
		return cartService.findAllCarts();
	}
	
	@RequestMapping(value = "/edit/{cartId}", method=RequestMethod.GET)
	public String edit(@PathVariable("cartId") Long cartId) {		
		return "cartEdit";
	 }
	
	@RequestMapping(value = "/edit/{cartId}/getData", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CartEntity editCart(@PathVariable("cartId") Long cartId) {
		logger.info("FIND BY CART KEY: ", cartService.findByCartKey(cartId));
		return cartService.findByCartKey(cartId);
	 }
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("id") Long cartId,
			@ModelAttribute("shipToId") Long shipTo,
			@ModelAttribute("statusId") Long statusId) {
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