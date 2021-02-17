package com.magic.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.magic.dao.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
			
}
