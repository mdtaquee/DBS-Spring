package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.sunsoft.model.InsuranceData;
import com.sunsoft.repository.InsuranceRepository;

@Service
public class InsuranceDao {
	
	@Autowired
	InsuranceRepository insuranceRespository;
	public void insertData(InsuranceData insuranceObj) {
		insuranceRespository.save(insuranceObj);
	}
	
	public void deleteRecord(int id) {
		insuranceRespository.deleteById(id);
	}
	
	public List<InsuranceData> displayAll() {
		List<InsuranceData>insuranceList = (List<InsuranceData>) insuranceRespository.findAll();
		return insuranceList;
	}

}
