package com.dmitrenko.userstorage.mapper.impl;

import com.dmitrenko.userstorage.mapper.Mapper;
import com.dmitrenko.userstorage.model.dto.UserAddRequest;
import com.dmitrenko.userstorage.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements Mapper<User, UserAddRequest> {

	@Override
	public User from(UserAddRequest source) {
		return new User()
			.setUserName(source.getUserName())
			.setFirstName(source.getFirstName())
			.setLastName(source.getLastName())
			.setBirthDate(source.getBirthDate());
	}
}
