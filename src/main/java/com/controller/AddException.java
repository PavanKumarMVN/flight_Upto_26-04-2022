package com.controller;

public class AddException extends RuntimeException
{
	public AddException()
	{
		super("id cannot be added due to missing details");
	}

	@Override
	public String toString() 
	{
		return "Id is not added, some data is missing";
	}
}
