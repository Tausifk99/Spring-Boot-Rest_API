package com.jsp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.demo.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	
	 @Query("SELECT a FROM Admin a WHERE a.email=:myemail AND a.password=:mypassword")
     public Admin validateAdmin(@Param("myemail") String email,@Param("mypassword") String password);
}
