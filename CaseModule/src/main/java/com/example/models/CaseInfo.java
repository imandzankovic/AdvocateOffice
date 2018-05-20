package com.example.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "caseinfo")
public class CaseInfo implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	 @Column(name = "case_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int caseId;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "court")
	private String court;
	
	@Column(name = "court_number")
	private long courtNumber;
	
	@Column(name = "case_number")
	private long caseNumber;
	
	@Column(name = "judge")
	private String judge;
   
	/*@ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "case_categories",
    	joinColumns = @JoinColumn(name = "case_id", referencedColumnName = "case_id"),
    	inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories = new HashSet<Category>();*/
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Category category;
	
	   public void setCategory(Category category){
	    	this.category = category;
	    }
	    
	    public Category getCategory(){
	    	return this.category;
	    }
	    @ManyToOne(fetch = FetchType.EAGER)
	    private Client client;
	
	   public void setClient(Client client){
	    	this.client = client;
	    }
	    
	    public Client getClient(){
	    	return this.client;
	    }
	    
	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	public long getCourtNumber() {
		return courtNumber;
	}
	public void setCourtNumber(long courtNumber) {
		this.courtNumber = courtNumber;
	}
	public long getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(long caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	
	 public CaseInfo() {}

   /*  public CaseInfo(long caseNumber, String court,long courtNumber,String judge,String note) {
         this.caseNumber = caseNumber;
         this.court=court;
         this.courtNumber = courtNumber;
         this.judge=judge;
         this.note=note;
     }*/
	
	 public CaseInfo(String court) {
		 this.court=court;
	 }
     public CaseInfo(String court, Category category){
     	this.court = court;
     	this.category = category;
     }
     public CaseInfo(String court, Client client){
      	this.court = court;
      	this.client = client;
      }
  
     @Override
 	public String toString() {
 		return String.format("Case[caseId=%d, caseNumber='%d', court='%s',courtNumber='%d',judge='%s',note='%s']", caseId, caseNumber, court,courtNumber,judge,note);
 	}

}
