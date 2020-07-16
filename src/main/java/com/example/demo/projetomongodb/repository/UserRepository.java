package com.example.demo.projetomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.projetomongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
