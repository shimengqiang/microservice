package com.example.provider.service.impl;

import com.example.provider.dao.model.Users;
import com.example.provider.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 * @author smq
 */
@Service
public class UserServiceImpl implements UserService {

	private List<Users> usersList = new ArrayList<>();

	@PostConstruct
	public void init(){
		for (int i = 0; i < 10; i++) {
			Users users = new Users(1L, "user"+i);
			usersList.add(users);
		}

	}


	@Override
	public List<Users> findAll() {
		return usersList;
	}
}
