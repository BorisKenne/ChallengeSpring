package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.User;



public interface UserRepository extends MongoRepository<User, String>{
    public List<User> findByName(String name);
	public User findByEmail(String email);
}   