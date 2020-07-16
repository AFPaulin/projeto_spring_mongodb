package com.example.demo.projetomongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.projetomongodb.domain.Post;
import com.example.demo.projetomongodb.domain.User;
import com.example.demo.projetomongodb.dto.UserDTO;
import com.example.demo.projetomongodb.repository.PostRepository;
import com.example.demo.projetomongodb.repository.UserRepository;
import com.example.demo.projetomongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	//@Autowired instancia automaticamente nesse framework
	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List <Post> findByTitle(String text) {
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text,Date minDate,Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
	
}
