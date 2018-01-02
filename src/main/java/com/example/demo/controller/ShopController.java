package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shop;
import com.example.demo.repository.ShopRepository;

@RestController
@Service
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ShopRepository shopRepository;

	public ShopController() {
		super();
		// TODO Auto-generated constructor stub
	}

	//CREATE
	public void createShop(Shop shop) {
		shopRepository.save(shop);
	}
	
	//READ
	public Shop readShop(String id) {
		Shop shop=shopRepository.findOne(id);
		return shop;
	}
	
	//UPDATE 
	public void updateShop(Shop shop) {
		shopRepository.save(shop);
	}
	
	//DELETE
	public void deleteShop(String id) {
		shopRepository.delete(id);
	}
}
