package com.magic.service;

import com.magic.dao.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
	public Flux<User> getAllUser();
	
	public Mono<User> saveUser(User user);

	public Mono<Void> deleteUser(String user);
	
}
