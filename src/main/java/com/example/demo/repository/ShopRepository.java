package com.example.demo.repository;

import com.example.demo.model.Shop;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Shop,String> {

}
