package com.jsp.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo.dto.Admin;
import com.jsp.demo.dto.Login;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
		
	@PostMapping("/admins")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/admins/{id}")
	public ResponseStructure<Admin> getAdminById(@PathVariable int id)
	{
		return adminService.getAdminById(id);
	}
	
	@GetMapping("/admins")
	public ResponseStructure<List<Admin>> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
	
	@DeleteMapping("/admins/{id}")
	public ResponseStructure<Admin> deleteAdminById(@PathVariable int id)
	{
		return adminService.deleteAdminById(id);
	}
	
	@PutMapping("/admins/{id}")
	public ResponseStructure<Admin>  updateAdminById(@PathVariable int id,@RequestBody Admin admin)
	{
		return adminService.updateAdminById(id, admin);
	}
	
	@PostMapping("/login")
	public ResponseStructure<Admin> validateAdmin(@RequestBody Login login)
	{
		return adminService.validateAdmin(login.getEmail(), login.getPassword());
	}
	
}
