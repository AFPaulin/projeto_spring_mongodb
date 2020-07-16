package com.example.demo.projetomongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.projetomongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//?0 indica que é o primeiro parametro que vai ser comparado 
	// isso é uma alternativa usando a annotation @Query
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);
	
	
	//ignoreCase = busca ignora maiuscula e minuscula
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: ?2} } , "
			+ "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } },"
			+ " { 'body': { $regex: ?0, $options: 'i' } },"
			+ " { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text,Date minDate,Date maxDate);
	
	
}
