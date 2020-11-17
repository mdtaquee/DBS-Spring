package com.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import java.util.HashMap;
//import com.model.UserLogin;
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public ResponseEntity<String> validate(@RequestParam ("Username") String Username,@RequestParam ("Password") String Password)
	{
		HashMap<String, String> users = new HashMap<String, String>();
		users.put("Taqueeuddin", "pwd@123");
		users.put("Pranay", "pra@986");		
		users.put("Keerthi", "keer@321");
		users.put("Sachin", "sac@456");
		
		if(users.containsKey(Username))
		{
			if(users.get(Username).equals(Password))
			{
				return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			}
			else
			{
				return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
			}
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	

}
