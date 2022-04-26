package com.sample.AirlineProject;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.dao.*;
import com.model.*;

import junit.framework.Assert;
@SpringBootTest
class FlightStatusTest {
	
	@Autowired
	FlightStatusService service;
	
	@Test
	void testAdd() {
		
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(12);
		status.setRemainingEconomySeats(11);
		status.setRemainingPremiumSeats(10);
		service.add(status);
		FlightStatus status1=service.find(status.getId());
		
	  Assert.assertEquals(12,status1.getRemainingBusinessSeats());
	  Assert.assertEquals(11,status1.getRemainingEconomySeats());
		
	}

	

	@Test
	void testFind() {
		
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(12);
		status.setRemainingPremiumSeats(23413);
		status.setRemainingEconomySeats(25);
		service.add(status);
		FlightStatus status1=service.find(status.getId());
		Assert.assertEquals(12, status1.getRemainingBusinessSeats());
	} 

	@Test
	void testFindAll() {
		FlightStatus status = new FlightStatus();
		status.setRemainingBusinessSeats(17);
		status.setRemainingEconomySeats(5);
		status.setRemainingPremiumSeats(3);
		service.add(status);
		List<FlightStatus> status1 = service.findAll();
		Assert.assertEquals(status1.get(0).getRemainingBusinessSeats(),status1.get(0).getRemainingBusinessSeats());
	}
	@Test
	void testUpdate() {
		
		FlightStatus status=service.find(1);
		status.setRemainingBusinessSeats(17);
		status.setRemainingEconomySeats(5);
		status.setRemainingPremiumSeats(3);
		service.update(status);
		FlightStatus fs1 =service.find(1);
		Assert.assertEquals(5, fs1.getRemainingEconomySeats());
	}
	
	@Test
	void testDelete() {		
		FlightStatus fs = service.find(2);
		service.delete(2);
		FlightStatus fs1 = service.find(2);
		Assert.assertNull(fs1);
		
	}

}
