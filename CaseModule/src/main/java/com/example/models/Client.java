package com.example.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int client_id;
    private String client_name;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CaseInfo> cases;
    
    public Client(){
    }
    
    public Client(String client_name){
    	this.setClient_name(client_name);
    }
    
    public Client(String client_name, Set<CaseInfo> cases){
    	this.setClient_name(client_name);
    	this.cases = cases;
    }
    
    // name
	public String getCatlient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
    
    // products
    public void setCases(Set<CaseInfo> cases){
    	this.cases = cases;
    }
    
    public Set<CaseInfo> getCases(){
    	return this.cases;
    }

	public int getClientId() {
		return client_id;
	}

	public void setClientId(int client_id) {
		this.client_id = client_id;
	}
		
	}


