package com.controller;

public class FindException extends RuntimeException
{
	private int id;
	public FindException(int id)
	{
		super("Id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "Id "+id+" is not available";
	}
}
