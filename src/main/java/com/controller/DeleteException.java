package com.controller;

public class DeleteException extends RuntimeException
{
	private int id;
	public DeleteException(int id)
	{
		super("Id "+id+" not found to delete");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "Id "+id+" is not available to delete";
	}
}
