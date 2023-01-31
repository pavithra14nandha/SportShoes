package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer >{
String query="select user from User user where username=?1 and password=?2";

@Query(query)
public User findbyNamePassword(String username,String password);


}
