package com.example.demo.model;

import java.util.ArrayList;

public class Retour {
	
	String userId;
	String userName;
	String userEmail;
	
	ArrayList<ShopLink> shops;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ArrayList<ShopLink> getShop() {
		return shops;
	}

	public void setShop(ArrayList<ShopLink> shops) {
		this.shops = shops;
	}

	public Retour(String userId, String userName, String userEmail, ArrayList<ShopLink> shops) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.shops = shops;
	}
	
	

}
