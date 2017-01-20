package com.softtek.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtek.jpa.domain.StatusEntity;
import com.softtek.jpa.services.StatusService;

@Controller
@RequestMapping("status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = "status", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<StatusEntity> status() {
		return statusService.findAllStatus();
	}

}
