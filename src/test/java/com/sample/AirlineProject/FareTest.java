package com.sample.AirlineProject;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.FareService;
import com.model.*;

import junit.framework.Assert;

@SpringBootTest
public class FareTest 
{
	@Autowired
	FareService service;
	
	@Test
	void contextLoads() {
	
	}
	
	@Test
	void testAdd() 
	{		
		Fare fare=new Fare();
		fare.setBusinessFare(200);
		fare.setEconomyFare(150);
		fare.setPremiumFare(1000);
		service.add(fare);
		Fare fare1=service.find(fare.getId());
	}
	
	

	@Test
	void testFind() 
	{		
		Fare fare=new Fare();
		fare.setBusinessFare(700);
		fare.setEconomyFare(550);
		fare.setPremiumFare(3000);
		service.add(fare);
		Fare status1=service.find(fare.getId());
		Assert.assertEquals(700d, status1.getBusinessFare());
	} 

	@Test
	void testFindAll() 
	{
		Fare fare=new Fare();
		fare.setBusinessFare(250d);
		fare.setEconomyFare(150);
		fare.setPremiumFare(1500);
		service.add(fare);
		
		List<Fare> farelist=service.findAll();
		Assert.assertEquals(farelist.get(1).getBusinessFare(), farelist.get(1).getBusinessFare());
	}
	
	@Test
	void testModifyFare() 
	{		
		Fare fare=new Fare();
		fare.setBusinessFare(122);
		fare.setEconomyFare(551);
		fare.setPremiumFare(3121);
		service.add(fare);
		fare.setEconomyFare(600);
		service.modifyFare(fare);
		Assert.assertEquals(true, service.modifyFare(fare));
	}
	
	@Test
	void testDelete() 
	{
		Fare fare= service.find(3);
		service.delete(fare.getId());
		Fare fare1=service.find(3);
		Assert.assertNull(fare1);
	}
}
