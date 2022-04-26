package com.controller;

public class AddUserException extends RuntimeException {
	private int id;
	public AddUserException(int id) {
		
		super("id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() {
		return "id "+ id +" not available";
	}
	
}