package com.dmitrenko.userstorage.service;

import com.dmitrenko.userstorage.model.dto.UserAddRequest;

public interface QueueService {

	void sendAdd(UserAddRequest request);
}
