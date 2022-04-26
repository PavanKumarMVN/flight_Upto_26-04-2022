package com.sample.AirlineProject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.GuestUserService;
import com.model.GuestUser;

import junit.framework.Assert;

@SpringBootTest
public class GuestUserTest 
{
	@Autowired
	GuestUserService service;
	
	@Test
	void testAdd() {
		GuestUser guest=new GuestUser();
		guest.setUserName("Pavan");
		guest.setPassword("Pavankumar@36");
		service.add(guest);	
		
		GuestUser adminguest1=service.find(guest.getId());
		Assert.assertEquals("Pavan",guest.getUserName());
	}
	
	@Test
	void testFind() {
		GuestUser guest=new GuestUser();
		guest.setUserName("Chari");
		guest.setPassword("CharuCharmish");
		GuestUser guest1=service.find(guest.getId());
		Assert.assertNull(guest1);
	}
	
	@Test
	void testFindAll() {
		GuestUser guest=new GuestUser();
		guest.setUserName("Malli");
		guest.setPassword("MalliChari");
		service.add(guest);
		
		GuestUser guest1=new GuestUser();
		guest1.setUserName("Suri");
		guest1.setPassword("JayaSri");
		
		service.add(guest1);
		
		List<GuestUser> guestlist=service.findAll();
		Assert.assertEquals(guestlist.get(1).getPassword(), "MalliChari");

}
	@Test
	void testUpdate() {
		GuestUser guest=new GuestUser();
		guest.setUserName("Rohit Sharma");
		guest.setPassword("HitMan");
		service.add(guest);
		
		Assert.assertEquals(true, service.update(guest));
				
		}
	
	@Test 
	void testDelete() {
		GuestUser guest= service.find(2);
		service.delete(2);
		GuestUser guest1=service.find(2);
		Assert.assertNull(guest1);
	}
	
	@Test
	void testCheckAdmin() {
		service.checkGuestUser("Ranjan", "@123");
		Assert.assertEquals(true, service.checkGuestUser("Ranjan", "@123"));
	}
}
