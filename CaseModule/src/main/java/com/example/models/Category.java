package com.example.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/*@Entity
@Table(name = "category")
public class Category implements Serializable {
	
	 private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryId;
	@Column(name = "category_name")
	private String categoryName;
	
	@ManyToMany
	@JoinTable(name = "case_categories", 
		joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"), 
		inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "case_id"))
	private Set<CaseInfo> cases = new HashSet<CaseInfo>();
	
	 public Set<CaseInfo> getCases() {
			return cases;
		}

		public void setCases(Set<CaseInfo> cases) {
			this.cases = cases;
		}
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category(){

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    
}
*/
@Entity
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;
    private String category_name;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CaseInfo> cases;
    
    public Category(){
    }
    
    public Category(String category_name){
    	this.setCategory_name(category_name);
    }
    
    public Category(String category_name, Set<CaseInfo> cases){
    	this.setCategory_name(category_name);
    	this.cases = cases;
    }
    
    // name
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
    
    // products
    public void setCases(Set<CaseInfo> cases){
    	this.cases = cases;
    }
    
    public Set<CaseInfo> getCases(){
    	return this.cases;
    }


}