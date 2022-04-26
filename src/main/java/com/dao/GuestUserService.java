package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.*;

@Service
public class GuestUserService 
{
	@Autowired
	GuestUserDAO guestDAOImpl;
	
	public void add(GuestUser guest)
	{
		guestDAOImpl.addGuestUser(guest);
	}
	
	public GuestUser find(int id)
	{
		return guestDAOImpl.findGuestUser(id);
	}
	
	public List<GuestUser> findAll()
	{
		return guestDAOImpl.findAllGuestUser();
	}
	
	public boolean update(GuestUser guest)
	{
		return guestDAOImpl.updateGuestUser(guest);
	}
	
	public boolean delete(int id)
	{
		return guestDAOImpl.deleteGuestUser(id);
	}
	
	public boolean checkGuestUser(String userName,String password)
	{
		return guestDAOImpl.checkGuestUser(userName,password);
	}
}
