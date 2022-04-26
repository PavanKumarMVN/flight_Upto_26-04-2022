package com.model;

import javax.persistence.OneToMany;

public class GuestUserDashboard 
{
private GuestUser guestUser;
	
	@OneToMany
	private Flight flight;
	private Fleet fleet;
	private Fare fare;
	private FlightStatus flightStatus;
	private Location location;
	
	public GuestUserDashboard() {}

	public GuestUser getGuestUser() {
		return guestUser;
	}

	public void setGuestUser(GuestUser guestUser) {
		this.guestUser = guestUser;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public FlightStatus getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
