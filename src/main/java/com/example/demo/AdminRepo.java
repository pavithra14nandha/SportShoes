package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	String query="select admin from Admin admin where name=?1 and password=?2";

	@Query(query)
	public Admin findbyNamePassword(String name,String password);

}
