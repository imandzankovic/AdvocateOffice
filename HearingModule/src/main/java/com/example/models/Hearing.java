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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import antlr.collections.List;

@Entity
@Table(name = "hearing")
public class Hearing {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "hearing_id")
	private int hearingId;
	@Column(name = "date_of_hearing")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateOfHearing;
	@Column(name = "hearing_place")
	private String hearingPlace;
	
	public int getHearingId() {
		return hearingId;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "hearing_client", joinColumns = @JoinColumn(name = "hearing_id", referencedColumnName = "hearing_id"), 
    inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "client_id"))
	private Set<Client> clients;
	//private List<Client> clients;


	
	
	public void setHearingId(int hearingId) {
		this.hearingId = hearingId;
	}
	
	public Date getDateOfHearing() {
		return dateOfHearing;
	}
	public void setDateOfHearing(Date dateOfHearing) {
		this.dateOfHearing = dateOfHearing;
	}
	public String getHearingPlace() {
		return hearingPlace;
	}
	public void setHearingPlace(String hearingPlace) {
		this.hearingPlace = hearingPlace;
	}
	public Hearing(){
	}
	
	public Hearing(Date dateOfHearing, String hearingPlace){
		this.dateOfHearing = dateOfHearing;
		this.hearingPlace = hearingPlace;
	}
	public Hearing(String hearingPlace){
		
		this.hearingPlace = hearingPlace;
	}
	public Hearing(String hearingPlace,Set<Client> clients) {
		this.hearingPlace=hearingPlace;
		this.clients=clients;
	}
	
	public Set<Client> getClients() {
		return clients;
	}
	
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
