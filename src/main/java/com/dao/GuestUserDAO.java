package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.model.GuestUser;

@Repository
public interface GuestUserDAO 
{
	public void addGuestUser(GuestUser guest);
	public GuestUser findGuestUser(int id);
	public List<GuestUser> findAllGuestUser();
	public boolean updateGuestUser(GuestUser guest);
	public boolean deleteGuestUser(int id);
	public boolean checkGuestUser(String userName,String password);
}
