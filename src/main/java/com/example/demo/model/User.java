package com.example.demo.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	
	//les valeures de ce champ doivent etre différentes dans la base de données !!!
	private String email;
	private String password;
	private String name;
	private ArrayList<String> shops;
	public User(){ 
		// TODO Auto-generated constructor stub
	}
	public User(String id, String email, String password, String nom,ArrayList<String> shops) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = nom;
		this.shops=shops;
	}
    
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}
	public ArrayList<String> getShops() {
		return shops;
	}
	public void setShops(ArrayList<String> shops) {
		this.shops = shops;
	}

	
	
}
