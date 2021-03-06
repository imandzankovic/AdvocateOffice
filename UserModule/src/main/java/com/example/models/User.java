package com.example.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String username;
	private String email;
	private String password;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   /* @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', email='%s']",
                Id, username, email);
    }*/
  public User() {}

     public User(String username, String password,String email) {
         this.username = username;
         this.password=password;
         this.email = email;
     }

	
}
