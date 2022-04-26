package com.sample.AirlineProject;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.AdminService;
import com.model.*;

import junit.framework.Assert;

@SpringBootTest
public class AdminTest 
{
	@Autowired
	AdminService service;
	
	@Test
	void testAdd() {
		Admin admin=new Admin();
		admin.setUserName("Pavan");
		admin.setPassword("Pavankumar@36");

		Flight flight = new Flight();
		
		Fleet fleet = new Fleet();
		fleet.setCode("23654");
		fleet.setModel("Dracula");
		fleet.setTotalBusinessSeats(143);
		fleet.setTotalEconomySeats(360);
		fleet.setTotalPremiumSeats(130);
		
		Location location = new Location();
		location.setName("Chennai");
		location.setAirportName("Chinna pallasa airport");
		location.setCode("524768");
		location.setCountry("India");
		
		Location location1 = new Location();
		location1.setName("Delhi");
		location1.setAirportName("Dalda chouhan airport");
		location1.setCode("625345");
		location1.setCountry("India");
		
		String str="2022-03-30";
		String str1="2022-04-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		
		long diff = date1.getTime() - date.getTime();
		String diffHrs = diff/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs);
		
		FlightStatus flightStatus=new FlightStatus();
		flightStatus.setRemainingBusinessSeats(3543);
		flightStatus.setRemainingEconomySeats(5431);
		flightStatus.setRemainingPremiumSeats(5487);
		
		flight.setDepartureLocation(location);
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		flight.setArrivalLocation(location1);
		
		Fare fare = new Fare();
		fare.setBusinessFare(256.0);
		fare.setEconomyFare(3265.125);
		fare.setPremiumFare(8569.25);
		service.add(admin);
		
		
		Admin admin1=service.find(admin.getId());
		Assert.assertEquals("Pavan",admin.getUserName());
	}
	
	@Test
	void testFind() {
		Admin admin=new Admin();
		admin.setUserName("Chari");
		admin.setPassword("CharuCharmish");
		Admin admin1=service.find(admin.getId());
		Assert.assertNull(admin1);
	}
	
	@Test
	void testFindAll() {
		Admin admin=new Admin();
		admin.setUserName("Malli");
		admin.setPassword("MalliChari");
Flight flight = new Flight();
		
		Fleet fleet = new Fleet();
		fleet.setCode("23654");
		fleet.setModel("Dracula");
		fleet.setTotalBusinessSeats(143);
		fleet.setTotalEconomySeats(360);
		fleet.setTotalPremiumSeats(130);
		
		Location location = new Location();
		location.setName("Chennai");
		location.setAirportName("Chinna pallasa airport");
		location.setCode("524768");
		location.setCountry("India");
		
		Location location1 = new Location();
		location1.setName("Delhi");
		location1.setAirportName("Dalda chouhan airport");
		location1.setCode("625345");
		location1.setCountry("India");
		
		String str="2022-03-30";
		String str1="2022-04-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		
		long diff = date1.getTime() - date.getTime();
		String diffHrs = diff/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs);
		
		FlightStatus flightStatus=new FlightStatus();
		flightStatus.setRemainingBusinessSeats(3543);
		flightStatus.setRemainingEconomySeats(5431);
		flightStatus.setRemainingPremiumSeats(5487);
		
		flight.setDepartureLocation(location);
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		flight.setArrivalLocation(location1);
		
		Fare fare = new Fare();
		fare.setBusinessFare(256.0);
		fare.setEconomyFare(3265.125);
		fare.setPremiumFare(8569.25);
		service.add(admin);
		
		Admin admin1=new Admin();
		admin1.setUserName("Suri");
		admin1.setPassword("JayaSri");
		Flight flight1 = new Flight();
		
		Fleet fleet1 = new Fleet();
		fleet1.setCode("23654");
		fleet1.setModel("Dracula");
		fleet1.setTotalBusinessSeats(143);
		fleet1.setTotalEconomySeats(360);
		fleet1.setTotalPremiumSeats(130);
		
		Location location2 = new Location();
		location2.setName("Chennai");
		location2.setAirportName("Chinna pallasa airport");
		location2.setCode("524768");
		location2.setCountry("India");
		
		Location location3 = new Location();
		location3.setName("Delhi");
		location3.setAirportName("Dalda chouhan airport");
		location3.setCode("625345");
		location3.setCountry("India");
		
		String str2="2022-03-30";
		String str3="2022-04-02";
		Date date2 = Date.valueOf(str2);
		Date date3=Date.valueOf(str3);
		
		long diff1 = date3.getTime() - date2.getTime();
		String diffHrs1 = diff1/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs1);
		
		FlightStatus flightStatus1=new FlightStatus();
		flightStatus1.setRemainingBusinessSeats(3543);
		flightStatus1.setRemainingEconomySeats(5431);
		flightStatus1.setRemainingPremiumSeats(5487);
		
		flight.setDepartureLocation(location2);
		flight.setDepartureTime(date2);
		flight.setArrivalTime(date3);
		flight.setArrivalLocation(location3);
		
		Fare fare1 = new Fare();
		fare1.setBusinessFare(256.0);
		fare1.setEconomyFare(3265.125);
		fare1.setPremiumFare(8569.25);
		service.add(admin1);
		
		List<Admin> adminlist=service.findAll();
		Assert.assertEquals(adminlist.get(1).getPassword(), "MalliChari");

}
	@Test
	void testUpdate() {
		Admin admin=new Admin();
		admin.setUserName("Rohit Sharma");
		admin.setPassword("HitMan");
Flight flight = new Flight();
		
		Fleet fleet = new Fleet();
		fleet.setCode("23654");
		fleet.setModel("Dracula");
		fleet.setTotalBusinessSeats(143);
		fleet.setTotalEconomySeats(360);
		fleet.setTotalPremiumSeats(130);
		
		Location location = new Location();
		location.setName("Chennai");
		location.setAirportName("Chinna pallasa airport");
		location.setCode("524768");
		location.setCountry("India");
		
		Location location1 = new Location();
		location1.setName("Delhi");
		location1.setAirportName("Dalda chouhan airport");
		location1.setCode("625345");
		location1.setCountry("India");
		
		String str="2022-03-30";
		String str1="2022-04-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		
		long diff = date1.getTime() - date.getTime();
		String diffHrs = diff/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs);
		
		FlightStatus flightStatus=new FlightStatus();
		flightStatus.setRemainingBusinessSeats(3543);
		flightStatus.setRemainingEconomySeats(5431);
		flightStatus.setRemainingPremiumSeats(5487);
		
		flight.setDepartureLocation(location);
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		flight.setArrivalLocation(location1);
		
		Fare fare = new Fare();
		fare.setBusinessFare(256.0);
		fare.setEconomyFare(3265.125);
		fare.setPremiumFare(8569.25);
		service.add(admin);
		
		service.update(admin);
		Assert.assertEquals(true, service.update(admin));
				
		}
	
	@Test 
	void testDelete() {
		Admin admin= service.find(3);
		service.delete(admin.getId());
		Admin admin1=service.find(3);
		Assert.assertNull(admin1);
	}
	
	@Test
	void testCheckAdmin() {
		service.checkAdmin("Ranjan", "@123");
		Assert.assertEquals(true, service.checkAdmin("Ranjan", "@123"));
	}

}
