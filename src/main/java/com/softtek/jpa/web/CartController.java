package com.softtek.jpa.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		logger.info("FIND BY CART KEY: " +  cartService.findByCartKey(cartId).getAudit().getUpdateDate());
		return cartService.findByCartKey(cartId);
	 }
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public @ResponseBody ModelAndView update(@RequestParam("id") Long cartId,
			@RequestParam("linesAmount") double linesAmount,
			@RequestParam("shippingAmount") double shippingAmount,
			@RequestParam("cartAmount") double cartAmount,
			@RequestParam("shipTo") Long shipToId,
			@RequestParam("status") Long statusId) {
		
		
		
		CartEntity cart = cartService.findByCartKey(cartId);
		cart.getCartDetails().setCartAmount(cartAmount);
		cart.getCartDetails().setLinesAmount(linesAmount);
		cart.getCartDetails().setShippingAmount(shippingAmount);
		cart.getCartDetails().setShipTo(new ShipToEntity(shipToId));
		cart.getCartDetails().setStatus(new StatusEntity(statusId));
		Calendar cal = Calendar.getInstance();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
		cart.getAudit().setUpdateDate(timestamp);
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
	
//	public String editUser(@RequestParam Long cartId, @RequestParam String status, Model model) {
//		Cart cart = cartService.cart(cartId);
//		List<Status> cartStatus = statusService.statusList("CART");
//		List<ShipTo> shipTos = shipToService.shipToList();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("cart", cart);
//		map.put("cartStatus", cartStatus);
//
//		map.put("shipTos", shipTos);
//		map.put("status", status);
//		model.addAttribute("map", map);
//		return "editCart";
//
//	}

}