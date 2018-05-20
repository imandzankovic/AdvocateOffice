package com.example.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int client_id;
    private String client_name;
    
   /* @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CaseInfo> cases;*/
    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
	private Set<Hearing> hearings;
    
    public Client(){
    }
    
    public Client(String client_name){
    	this.setClient_name(client_name);
    }
    
    /*public Client(String client_name, Set<CaseInfo> cases){
    	this.setClient_name(client_name);
    	this.cases = cases;
    }*/
    public Client(String client_name, Set<Hearing> hearings){
    	this.client_name = client_name;
    	this.hearings = hearings;
    }
	
	public int getClientId() {
		return client_id;
	}

	public void setClientId(int client_id) {
		this.client_id = client_id;
	}
    // name
	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
    
    // products
  /*  public void setCases(Set<CaseInfo> cases){
    	this.cases = cases;
    }
    
    public Set<CaseInfo> getCases(){
    	return this.cases;
    }
*/
	public Set<Hearing> getHearings() {
		return hearings;
	}
	
	public void setHearings(Set<Hearing> hearings) {
		this.hearings = hearings;
	}

}