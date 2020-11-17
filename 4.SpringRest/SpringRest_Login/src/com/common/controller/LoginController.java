package com.common.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value="/submit", method=RequestMethod.GET)
	public String getStatus(@RequestParam ("username") String name, @RequestParam ("Password") String password) {
		if(password.equals("admin")) {
			return "Valid user  " +name;
		}
		else
		{
			return "Invalid User " +name;
		}
	}

}
