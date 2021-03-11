package com.magic;



import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.magic.dao.User;
import com.magic.repository.UserRepository;
import com.magic.service.UserService;
import com.mongodb.connection.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class WebFluxApplicationTests {

	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	public void getUserTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(,"Himanshu", 21))
										.collect(Collectors.toList()));
		assertEquals(1,  )
	}
	

}
