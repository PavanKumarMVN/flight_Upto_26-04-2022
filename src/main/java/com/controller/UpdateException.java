package com.controller;

public class UpdateException extends RuntimeException
{
	public UpdateException()
	{
		super("Id is not found to update");
	}

	@Override
	public String toString() {
		return "Id is not available to update";
	}
}
