package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Task;

@RestController
public class TestController {

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public Task firstPage() {

		Task t = new Task();
	t.setTaskId(45);
	t.setDescription("description");
	t.setDueDate(null);
	t.setTitle("title");
		return t;
	}
}