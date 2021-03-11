package com.magic.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.magic.dao.User;
import com.magic.service.IUserService;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {
	@Autowired
	IUserService userservice;

	public Mono<ServerResponse> getUser(ServerRequest request) {
		
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(userservice.getAllUser(), User.class);
	}

	public Mono<ServerResponse> saveUser(ServerRequest request) {
		Mono<User> user = request.bodyToMono(User.class);
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(user.flatMap(userservice::saveUser), User.class);
	}
	public Mono<ServerResponse> deleteUser(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(userservice.deleteUser(id), User.class);
	}
}
