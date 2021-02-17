package com.magic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.dao.User;
import com.magic.service.IUserService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("/get-user")
	public Flux<User> getUser() {
		return userService.getAllUser();
	}
}
