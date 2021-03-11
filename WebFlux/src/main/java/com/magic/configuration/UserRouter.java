package com.magic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.magic.handler.UserHandler;

@Configuration
@EnableWebFlux
public class UserRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(UserHandler userHandler) {
		
		return RouterFunctions.route(
									RequestPredicates.GET("/get")
									.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
									userHandler::getUser)
				.andRoute(RequestPredicates.POST("/save")
								.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
										userHandler::saveUser)
				.andRoute(RequestPredicates.DELETE("/delete/{id}")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
								userHandler::deleteUser);
					
	}
}
