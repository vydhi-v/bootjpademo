package com.example.bootjpa.exceptions;

public class DogNotFoundException extends Exception{
	public DogNotFoundException(String message) {
		super(message);
	}
}
