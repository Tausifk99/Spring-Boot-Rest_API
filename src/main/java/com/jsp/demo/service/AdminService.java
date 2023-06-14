package com.jsp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.demo.dao.AdminDao;
import com.jsp.demo.dto.Admin;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.exception.InvalidCredentialException;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public ResponseStructure<Admin> saveAdmin(Admin admin)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		if(admin!=null)
		{
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
			responseStructure.setMessage("saved succesfully");
			responseStructure.setData(adminDao.saveAdmin(admin));
			return responseStructure;
		}else
		{
			responseStructure.setData(null);
			responseStructure.setMessage("Not saved ");
			responseStructure.setStatuscode(404);
			return null;
		}
	}
	
	public ResponseStructure<Admin> getAdminById(int id)
	{
	     ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
	     if(id>0)
	     {
	    	 responseStructure.setData(adminDao.getAdminById(id));
	    	 responseStructure.setMessage("Done");
	    	 responseStructure.setStatuscode(HttpStatus.CREATED.value());
	     }else
	     {
	    	 responseStructure.setMessage("not done");
	    	 responseStructure.setData(null);
	    	 responseStructure.setStatuscode(404);
	     }
	     return responseStructure;
	}
	
	public ResponseStructure<List<Admin>> getAllAdmin()
	{
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<>();
		List<Admin> admins=adminDao.getAllAdmin();
		
		if(!admins.isEmpty())
		{
			responseStructure.setData(admins);
			responseStructure.setMessage("done");
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
		}else
		{
			 responseStructure.setMessage("not done");
	    	 responseStructure.setData(null);
	    	 responseStructure.setStatuscode(404);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Admin> deleteAdminById(int id)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		if(id>0)
		{
		responseStructure.setData(adminDao.deleteAdminById(id));
		responseStructure.setMessage("deleted");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		}else
		{
			 responseStructure.setMessage("not done");
	    	 responseStructure.setData(null);
	    	 responseStructure.setStatuscode(404);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Admin> updateAdminById(int id,Admin admin)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		
		if(id>0)
		{
			responseStructure.setData(adminDao.updateAdminById(id, admin));
			responseStructure.setMessage("updated");
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
		}else
		{
			 responseStructure.setMessage("not updated");
	    	 responseStructure.setData(null);
	    	 responseStructure.setStatuscode(404);
		}
		return responseStructure;
	}
	
	public ResponseStructure<Admin> validateAdmin(String email,String password)
	{
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		Admin admin=adminDao.validateAdmin(email, password);
		if(admin!=null)
		{
			responseStructure.setData(admin);
			responseStructure.setMessage("Admin found");
			responseStructure.setStatuscode(HttpStatus.CREATED.value());
		}else
		{
//			 responseStructure.setMessage("not found");
//	    	 responseStructure.setData(null);
//	    	 responseStructure.setStatuscode(404);
			   
			try 
			{
				 throw new InvalidCredentialException();
			}catch(InvalidCredentialException e)
			{
				responseStructure.setData(admin);
				responseStructure.setMessage(e.getMessage());
				responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			}
		}
		return responseStructure;
	}
}
