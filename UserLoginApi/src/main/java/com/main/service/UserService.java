package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.UserRequest;
import com.main.entity.UserEntity;
import com.main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	
	
	public String login(UserRequest req) {
		Optional<UserEntity> user = repository.findbyusername(req.getUsername());
		if(user.isPresent()) {
			UserEntity ur = user.get();
			if(ur.getPassword().equals(req.getPassword())) {
				return "sucessfully login";
			}
			else {
				return "login not sucessfully";
			}
		}
		else {
			return "user not found";
		}
	}

}
