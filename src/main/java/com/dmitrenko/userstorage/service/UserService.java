package com.dmitrenko.userstorage.service;

import com.dmitrenko.userstorage.model.dto.UserAddRequest;
import com.dmitrenko.userstorage.model.dto.UserResponse;

import java.util.List;

public interface UserService {
	UserResponse add(UserAddRequest request);

	List<UserResponse> getAll();
}
