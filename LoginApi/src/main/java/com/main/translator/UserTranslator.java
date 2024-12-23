package com.main.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dto.UserRequest;

import com.main.entity.User;

@Component
public class UserTranslator {
	
	@Autowired
	private ObjectMapper mapper;
	
	public UserTranslator(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public User requestentity(UserRequest request) {
		return mapper.convertValue(request, User.class);
		
	}
	
//	public UserResponse responseentity(String message) {
//		return mapper.convertValue(message, UserResponse.class);
//	}

}

