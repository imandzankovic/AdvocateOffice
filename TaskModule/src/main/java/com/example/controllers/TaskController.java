package com.example.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.models.Task;
import com.example.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping("/tasks")
	public List<Task> retrieveAllTasks() {
		return taskRepository.findAll();
	}

	@GetMapping("/tasks/{id}")
	public Task retrieveTask(@PathVariable long id) throws TaskNotFoundException {
		Optional<Task> Task = taskRepository.findById(id);

		if (!Task.isPresent())
			throw new TaskNotFoundException("id-" + id);

		return Task.get();
	}

	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable long id) {
		taskRepository.deleteById(id);
	}

	@PostMapping("/tasks")
	public ResponseEntity<Object> createTask(@RequestBody Task task) {
		Task savedTask = taskRepository.save(task);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTask.getTaskId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable long id) {

		Optional<Task> TaskOptional = taskRepository.findById(id);

		if (!TaskOptional.isPresent())
			return ResponseEntity.notFound().build();

		task.setTaskId(id);
		
		taskRepository.save(task);

		return ResponseEntity.noContent().build();
	}
}