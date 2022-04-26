package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.GuestUserService;
import com.dao.LocationService;
import com.model.Admin;
import com.model.AdminDashboard;
import com.model.Flight;
import com.model.GuestUser;
import com.model.GuestUserDashboard;
import com.model.Location;

@RestController
public class GuestUserRestController {

	@Autowired
	LocationService locationService;
	
	@Autowired
	GuestUserService guestService;
	
	// guest user details
	@GetMapping("/getguestuser/{id}")
	public ResponseEntity<?> getGuestUser(@PathVariable int id) throws FindException
	{
		GuestUser guest= guestService.find(id);
		if(guest==null)
		{
			throw new FindException(id);
		}
		guestService.find(id);
		return ResponseEntity.ok("Guest User found successfully");
	}
	
	@GetMapping("/getallguestusers")
  public List<GuestUser> getAllGuestUser()
  {
	   return guestService.findAll();
  }
	   
  @PostMapping("/addguestuser")
  public ResponseEntity<?> addGuestUser(@RequestBody GuestUser guest) throws AddGuestUserException
  {
	   if(guest.getUserName()==null || guest.getPassword()==null)
	   {
		   throw new AddGuestUserException(guest.getId());
	   }
	   guestService.add(guest);
	   return ResponseEntity.status(HttpStatus.OK).body("GuestUser added successfully");
  }
  
  @DeleteMapping("/deleteguestuser/{id}")
  public ResponseEntity<?> deleteGuestUser(@PathVariable("id") int id) throws DeleteException 
  {
	  GuestUser guest= guestService.find(id);
	   if(guest==null)
	   {
		   throw new DeleteException(id);
	   }
	   guestService.delete(id);
	   return ResponseEntity.ok("GuestUser details deleted successfully");
  }
  
  @PatchMapping("/updateguestuser")
  public ResponseEntity<?> updateGuestUser(@RequestBody GuestUser guest) throws UpdateException
  {
	  GuestUser guest1= guestService.find(guest.getId());
	   if(guest1==null)
	   {
		   throw new UpdateException();
	   }
	   guestService.update(guest);
	   return ResponseEntity.ok("GuestUser details updated Successfully");
  }
	// guestuser with location details
	@GetMapping("/guest/findalllocation")
	public List<Location> findLocation(@RequestBody GuestUserDashboard adminDashboard) 
	{
		boolean result = guestService.checkGuestUser(adminDashboard.getGuestUser().getUserName(),adminDashboard.getGuestUser().getPassword());
		if(result)
		{
			return locationService.findAll();
		}
		return locationService.findAll();
	}
	
	@PostMapping("/guest/addlocation")
	public ResponseEntity<?> addFlight(@RequestBody GuestUserDashboard adminDashboard) throws AddException
	{
		boolean result= guestService.checkGuestUser(adminDashboard.getGuestUser().getUserName(), adminDashboard.getGuestUser().getPassword());
		
		if(result) {
			if(adminDashboard.getGuestUser().getUserName()==null || adminDashboard.getGuestUser().getPassword()==null)
			   {
				   throw new AddException();
			   }
			locationService.add(adminDashboard.getLocation());
			return ResponseEntity.status(HttpStatus.OK).body("Location details added by admin Succesfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("Invalid Admin details");
		}
	}

	   
	@DeleteMapping("/guest/deletelocation")
	 public ResponseEntity<?> deleteLocation(@RequestBody GuestUserDashboard adminDashboard) throws DeleteException 
	 {
		boolean result= guestService.checkGuestUser(adminDashboard.getGuestUser().getUserName(), adminDashboard.getGuestUser().getPassword());
		if(result)
		{
			Location location= locationService.find(adminDashboard.getLocation().getId());
			if(location==null)
			{
				throw new DeleteException(location.getId());
			}
			locationService.delete(location.getId());
			return ResponseEntity.ok("Location details deleted successfully");
		}
		else
		{
			return ResponseEntity.ok("Admin details not found");
		}
	 }
	@PatchMapping("/guest/location")
	public ResponseEntity<?> updateLocation(@RequestBody GuestUserDashboard ad) throws UpdateException
	{
		boolean result= guestService.checkGuestUser(ad.getGuestUser().getUserName(), ad.getGuestUser().getPassword());
		if(result)
		{
			Location location= locationService.find(ad.getLocation().getId());
			if(location==null)
			{
				throw new UpdateException();
			}
			locationService.update(ad.getLocation());
			return ResponseEntity.ok("location details updated");
		}
		else
		{
			return ResponseEntity.ok("Admin details not found");
		}
	}
}

