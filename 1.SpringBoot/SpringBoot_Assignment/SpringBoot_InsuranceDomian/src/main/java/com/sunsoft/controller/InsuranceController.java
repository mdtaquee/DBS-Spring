package com.sunsoft.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunsoft.dao.InsuranceDao;
import com.sunsoft.model.InsuranceData;
//import com.sunsoft.repository.StudentRepository;

@RestController
public class InsuranceController {
	@Autowired
	InsuranceDao insuranceDao;
	@RequestMapping ("/insert")
	public String insertData()
	{
		InsuranceData insuranceObj = new InsuranceData ();
		insuranceObj.setId(11);
		insuranceObj.setName("Mohammed");
		insuranceObj.setTenure(75);
		insuranceObj.setAmount(2500);
		
		InsuranceData insuranceObj2 = new InsuranceData ();
		insuranceObj2.setId(12);
		insuranceObj2.setName("Taqueeuddin");
		insuranceObj2.setTenure(5);
		insuranceObj2.setAmount(5000);
		
		insuranceDao.insertData(insuranceObj);
		insuranceDao.insertData(insuranceObj2);
		return "Data Inserted Successfully";
	}
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable ("id") int id)
	{
		insuranceDao.deleteRecord(id);
		return "Record deleted successfully";
	}
	@RequestMapping("/updaate")
	public String updateData()
	{
		return "";
	}
	
	@RequestMapping("/displayAll")
	public List<InsuranceData> displaydata()
	{
		List<InsuranceData> insuranceList = insuranceDao.displayAll();
		return insuranceList;
	}

}
