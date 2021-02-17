package com.magic.service;

import com.magic.dao.User;

import reactor.core.publisher.Flux;

public interface IUserService {
	public Flux<User> getAllUser();
}
