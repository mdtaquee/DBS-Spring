package com.sunsoft.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.LoginData;

import com.sunsoft.repository.LoginRepository;
//import com.sunsoft.repository.UserRepository;

@Service
public class LoginDao {
	@Autowired
	private LoginRepository loginRepository;
	public List<LoginData> getUsers(){
		List<LoginData> loginList = (List<LoginData>) loginRepository.findAll();
		return loginList;
	}
}
