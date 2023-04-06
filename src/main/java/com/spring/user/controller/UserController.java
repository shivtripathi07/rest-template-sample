package com.spring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.user.dto.User;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String USER_API = "https://jsonplaceholder.typicode.com/users";
	
	@GetMapping("/users/{id}")
	public User consumeUser(@PathVariable Integer id) {
		String url = USER_API + "/{id}";
		return restTemplate.getForObject(url, User.class, id);
	}

	@GetMapping("/users")
	public User[] consumeAllUser() {
		return restTemplate.getForObject(USER_API, User[].class);
	}	

}
