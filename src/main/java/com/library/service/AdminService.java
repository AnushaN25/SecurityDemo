package com.library.service;

import java.util.List;

import com.library.exception.AdminAlreadyExistException;
import com.library.exception.AdminIdNotFoundException;
import com.library.exception.NoAdminFoundException;
import com.library.model.Admin;



public interface AdminService 
{
	public Admin addAdmin(Admin admin)throws AdminAlreadyExistException;
	public Admin updateAdmin(Admin admin)throws NoAdminFoundException;
	public void removeAdmin(int adminId)throws NoAdminFoundException;
	public Admin viewAdmin(Admin admin)throws AdminIdNotFoundException;
	public List<Admin>viewAllAdmins();
	public Admin getAdminById(int AdminId);
}

