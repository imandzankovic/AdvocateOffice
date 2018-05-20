package com.example.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long taskId;

	 
	 private Date dueDate;
	
	private String title;
	
	private String description;
	
	public long getTaskId() {
		return taskId;
	}


	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public Task(){
	}
	
	public Task(Date date2, String title,String description){
		this.dueDate = date2;
		this.title = title;
		this.description=description;
	}

}
