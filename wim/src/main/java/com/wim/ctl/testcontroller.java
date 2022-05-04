package com.wim.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testcontroller {
	
    @RequestMapping(value = "/testcall",method = RequestMethod.GET)
	public String test() {
		return "testcall Success";
	}

}
