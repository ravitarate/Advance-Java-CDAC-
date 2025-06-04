package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public ModelAndView sayHello() {
		String msg="welcome to Spring MVC";
		return new ModelAndView("hellomsg","mymsg",msg);
		
	}
	
	//@RequestMapping(path="/welcome",method=RequestMethod.GET)
    @GetMapping("/welcome")
	public String sayWelcome(Model ob) {
		ob.addAttribute("message", "Hello From Spring MVC");
		ob.addAttribute("name", "IET students");
		return "welcome";
		
	}

}
