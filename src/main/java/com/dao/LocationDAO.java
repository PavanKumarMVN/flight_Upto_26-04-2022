package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.*;

@Repository
public interface LocationDAO {
	
	public void addLocation(Location location);
	public Location findLocation(int id);
	public List<Location> findAllLocation();
	public boolean updateLocation(Location location);
	public boolean deleteLocation(int id);
}