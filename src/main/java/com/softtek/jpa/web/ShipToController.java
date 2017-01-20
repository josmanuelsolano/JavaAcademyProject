package com.softtek.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtek.jpa.domain.ShipToEntity;
import com.softtek.jpa.services.ShipToService;

@Controller
@RequestMapping("shipTos")
public class ShipToController {
	
	@Autowired
	private ShipToService shipToService;
	
	@RequestMapping(value = "shipTos", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ShipToEntity> shipTos() {
		return shipToService.findAllShipTos();
	}

}
