package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.AdminAlreadyExistException;
import com.library.exception.AdminIdNotFoundException;
import com.library.exception.NoAdminFoundException;
import com.library.model.Admin;
import com.library.serviceImpl.AdminServiceImpl;


@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminServiceImpl serviceImpl;
	//Add admin 
	@PostMapping(path="/addAdmin/")
	public Admin addAdmin(@RequestBody Admin admin)throws AdminAlreadyExistException{
		return serviceImpl.addAdmin(admin);
	}
	//Updte Admin based on id
	@PutMapping(path="/updateAdmin/{adminId}")
	public Admin update(@RequestBody Admin admin, @PathVariable int adminId)throws NoAdminFoundException{
		return serviceImpl.updateAdmin(admin);
	}
	@GetMapping(path="/fetch/admin/{adminId}")
	public Admin getAdminById(@PathVariable int adminId) {
		return serviceImpl.getAdminById(adminId);
		
	}
	//remove admin
	@DeleteMapping(path="/removeAdmin/{adminId}")
	public void remove(@PathVariable int adminId)throws NoAdminFoundException{
		serviceImpl.removeAdmin(adminId);
	}
	//view admin based on id
	@GetMapping(path="/viewAdmin/{id}")
	public Admin view(@PathVariable int id)throws AdminIdNotFoundException, NoAdminFoundException{
		Admin a=serviceImpl.findbyId(id);
		
		return serviceImpl.viewAdmin(a);
	}
	@GetMapping(path="/viewAdmin")
	public List<Admin>viewAllAdmins(){
		return serviceImpl.viewAllAdmins();
		
	}
	
}