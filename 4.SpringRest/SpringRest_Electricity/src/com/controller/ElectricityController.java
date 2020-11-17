package com.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Electricity;

@RestController
@RequestMapping("/bill")
public class ElectricityController {
	
	@RequestMapping(value = "/{meterno}", method = RequestMethod.GET)
	public String getMovie(@PathVariable int meterno) {
		
		HashMap<Integer, Electricity> hml = new HashMap<Integer, Electricity>();
		hml.put(1, new Electricity(1, "Tolichowki",1250, 1200,20,"20th of Every Month"));
		hml.put(2, new Electricity(2, "Gachibowli",1500, 1410,20,"20th of Every Month"));
		hml.put(3, new Electricity(3, "Koti",1250, 1100,20,"20th of Every Month"));
		
		Electricity emp=null;
		if(hml.containsKey(meterno))
		{
			emp = hml.get(meterno);
		}
		emp.setconsumedunits((int)(emp.getcurrentreading() - emp.getinitialreading()));
		//emp.setFinal_deductions((int) (emp.getDeductions() + (emp.getGross_sal()*0.2)));
		emp.settotal_amount(emp.getconsumedunits() * emp.getcostperunit());
	
		return emp.toString();
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name)
	{
		System.out.println(name);
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	

}
