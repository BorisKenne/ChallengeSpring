package com.example.demo.model;


import com.example.demo.classe.Location;

public class ShopLink  {


	String id;

	String picture;
	String name;
	String email;
	String city;
	Location location;

	String link;
	
	public ShopLink(Shop shop, String link) {
		super();
		this.id = shop.id;
		this.picture=shop.getPicture();
		this.name=shop.getName();
		this.email=shop.getEmail();
		this.city=shop.getCity();
		this.location=shop.getLocation();
		
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	
}
