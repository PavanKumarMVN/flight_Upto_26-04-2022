package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.model.*;

@Service
public class FleetService 
{
	@Autowired
	FleetDAO fleetDAOImpl;
	
	public void add(Fleet fleet)
	{
		fleetDAOImpl.addFleet(fleet);
	}
	
	public Fleet find(int id)
	{
		return fleetDAOImpl.findFleet(id);
	}
	
	public List<Fleet> findAll()
	{
		return fleetDAOImpl.findAllFleet();
	}
	
	public boolean update(Fleet fleet)
	{
		return fleetDAOImpl.updateFleet(fleet);
	}
	
	public boolean delete(int i)
	{
		return fleetDAOImpl.deleteFleet(i);
	}
}
