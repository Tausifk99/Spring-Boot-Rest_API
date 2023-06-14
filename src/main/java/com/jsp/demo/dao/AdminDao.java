package com.jsp.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.demo.dto.Admin;
import com.jsp.demo.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;
	
	//save
	public Admin saveAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}
	
	//get by id
	public Admin getAdminById(int id)
	{
		Optional<Admin> op=adminRepository.findById(id);
		
		if(op.get()!=null)
		{
	    return op.get();
		}else
		{
			return null;
		}
	}
	
	//get all
	public List<Admin> getAllAdmin()
	{
		return adminRepository.findAll();
	}
	
	//delete by id
	public Admin deleteAdminById(int id)
	{
		Optional<Admin> admin=adminRepository.findById(id);
		if(admin.get()!=null)
		{
		adminRepository.deleteById(id);
		System.out.println(admin.get());
		return admin.get();
		}else
		{
			return null;
			
		}
	}
	
	//update by id
	public Admin updateAdminById(int id,Admin admin)
	{
		Optional<Admin> op=adminRepository.findById(id);
		Admin ad=op.get();
		ad.setName(admin.getEmail());
		ad.setName(admin.getName());
		ad.setPassword(admin.getPassword());
		
		adminRepository.save(ad);
		return ad;	
	}
	
	//validate admin
	public Admin validateAdmin(String email,String password)
	{
		return adminRepository.validateAdmin(email, password);
	}
	
	
	
	
	
	
	
	
}
