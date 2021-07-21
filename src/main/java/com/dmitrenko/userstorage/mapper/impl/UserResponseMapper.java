package com.dmitrenko.userstorage.mapper.impl;

import com.dmitrenko.userstorage.mapper.Mapper;
import com.dmitrenko.userstorage.model.dto.UserResponse;
import com.dmitrenko.userstorage.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserResponseMapper implements Mapper<UserResponse, User> {

	@Override
	public UserResponse from(User source) {
		return new UserResponse()
			.setId(source.getId())
			.setUserName(source.getUserName())
			.setFirstName(source.getFirstName())
			.setLastName(source.getLastName())
			.setBirthDate(source.getBirthDate())
			.setCreated(source.getCreated());
	}
}
