package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
@Autowired
AdminRepo repoa;

public Admin insert(Admin a)
{
	return repoa.save(a);
	}

public List<Admin> login()
{
	return repoa.findAll();
}
public Admin findbynamepassword(String name,String password)
{
	return repoa.findbyNamePassword(name, password);
}
}
