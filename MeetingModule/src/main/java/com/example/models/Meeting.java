package com.example.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Meeting {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "meeting_id")
	private int meetingId;
	@Column(name = "date_of_meeting")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateOfMeeting;
	@Column(name = "title")
	private String title;
	@Column(name = "meeting_place")
	private String meetingPlace;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "meeting_client", joinColumns = @JoinColumn(name = "meeting_id", referencedColumnName = "meeting_id"), 
    inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "client_id"))
	private Set<Client> clients;
	
	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	
	
	public Date getDateOfMeeting() {
		return dateOfMeeting;
	}
	public void setDateOfMeeting(Date dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMeetingPlace() {
		return meetingPlace;
	}
	public void setMeetingPlace(String meetingPlace) {
		this.meetingPlace = meetingPlace;
	}
	
	public Meeting(){
	}
	
	public Meeting(Date dateOfMeeting, String title,String meetingPlace){
		this.dateOfMeeting = dateOfMeeting;
		this.title = title;
		this.meetingPlace=meetingPlace;
	}
	public Meeting(String title,String meetingPlace){
	
		this.title = title;
		this.meetingPlace=meetingPlace;
	}
	public Set<Client> getClients() {
		return clients;
	}
	
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
}

