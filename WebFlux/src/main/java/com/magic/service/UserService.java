package com.magic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.dao.User;
import com.magic.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Flux<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Mono<User> saveUser(User user) {    
		return userRepository.save(user);
	}

	@Override
	public Mono<Void> deleteUser(String id) {
		return userRepository.deleteById(id);

	}

}
