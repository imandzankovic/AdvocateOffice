package com.example.controllers;

public class TaskNotFoundException extends Exception {
	public TaskNotFoundException(String exception) {
		super(exception);
	}
}
