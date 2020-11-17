package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_details")
public class User_Details {
	@RequestMapping(value="/submit", method=RequestMethod.GET)
	public String getStatus(@RequestParam ("firstname") String fname, @RequestParam ("lastname") String lname) {
		if(fname.equals("Mohammed") && lname.equals("Taqueeuddin")) 
		{
			return "\n FirstName:" +fname +"\n LastName: " +lname;
		}
		
		else 
		{
			return "Invalid User_Details";
		}
	}

}
