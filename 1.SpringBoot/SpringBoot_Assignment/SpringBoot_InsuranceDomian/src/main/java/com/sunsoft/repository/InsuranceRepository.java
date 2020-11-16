package com.sunsoft.repository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
//import com.sunsoft.dao.StudentDao;

import com.sunsoft.model.InsuranceData;

public interface InsuranceRepository extends CrudRepository<InsuranceData, Integer> {

}
