package com.sunsoft.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sunsoft.model.LoginData;

@Repository
public interface LoginRepository extends CrudRepository<LoginData, Integer>{

}
