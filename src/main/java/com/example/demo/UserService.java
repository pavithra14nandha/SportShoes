package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
UserRepo repou;
public User insertUser(User u)
{
	return repou.save(u);
}
public List<User> getAllUser()
{
	return repou.findAll();
}
public String delete(User u)
{
	repou.delete(u);
	return "deleted";
}
public Optional<User> findbyid(int id)
{
	 return repou.findById(id);
	
}

}
