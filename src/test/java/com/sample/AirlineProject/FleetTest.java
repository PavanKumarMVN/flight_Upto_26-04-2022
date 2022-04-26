package com.sample.AirlineProject;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.FleetService;
import com.model.*;

import junit.framework.Assert;

@SpringBootTest
class FleetTest 
{
	@Autowired
	FleetService service;
	
	@Test
	void testAdd() 
	{
		Fleet fleet = new Fleet();
		fleet.setCode("B2A68");
		fleet.setModel("Amber Flare");
		fleet.setTotalBusinessSeats(143);
		fleet.setTotalEconomySeats(360);
		fleet.setTotalPremiumSeats(130);
		service.add(fleet);
		
		Fleet fleet_to_be_tested = service.find(fleet.getId());
		Assert.assertEquals("B2A68",fleet_to_be_tested.getCode());
		Assert.assertEquals("Amber Flare",fleet_to_be_tested.getModel());
		Assert.assertEquals(143,fleet_to_be_tested.getTotalBusinessSeats());
		Assert.assertEquals(360,fleet_to_be_tested.getTotalEconomySeats());
		Assert.assertEquals(130,fleet_to_be_tested.getTotalPremiumSeats());
	}
	
	@Test
	void testFind() 
	{		
		Fleet fleet = new Fleet();
		fleet.setCode("B2A68");
		fleet.setModel("Amber Flare");
		fleet.setTotalBusinessSeats(143);
		fleet.setTotalEconomySeats(360);
		fleet.setTotalPremiumSeats(130);
		service.add(fleet);
		Fleet fleet1 = service.find(fleet.getId());
		
		Assert.assertEquals("B2A68", fleet1.getCode());
	}

	@Test
	void testFindAll() 
	{
		Fleet fleet = new Fleet();
		fleet.setCode("3256B");
		fleet.setModel("Model");
		fleet.setTotalBusinessSeats(200);
		fleet.setTotalEconomySeats(500);
		fleet.setTotalPremiumSeats(240);
		service.add(fleet);
		List<Fleet> fleet1 = service.findAll();
		Assert.assertEquals(fleet1.get(0).getCode(),fleet1.get(0).getCode());
	}

	@Test
	void testUpdate() 
	{
		
		Fleet fleet_to_be_tested = service.find(1);
		fleet_to_be_tested.setCode("3256B");
		fleet_to_be_tested.setModel("Model");
		fleet_to_be_tested.setTotalBusinessSeats(200);
		fleet_to_be_tested.setTotalEconomySeats(500);
		fleet_to_be_tested.setTotalPremiumSeats(240);
		service.update(fleet_to_be_tested);
		
		Fleet fleet_to_be_tested1 = service.find(1);
		
		Assert.assertEquals("3256B", fleet_to_be_tested1.getCode());
		
	}

	@Test
	void testDelete() 
	{
		service.delete(2);
		Fleet fs1 = service.find(2);

		Assert.assertNull(fs1);
	}
	
}
