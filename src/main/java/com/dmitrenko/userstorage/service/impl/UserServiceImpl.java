package com.dmitrenko.userstorage.service.impl;

import com.dmitrenko.userstorage.mapper.impl.UserMapper;
import com.dmitrenko.userstorage.mapper.impl.UserResponseMapper;
import com.dmitrenko.userstorage.model.dto.UserAddRequest;
import com.dmitrenko.userstorage.model.dto.UserResponse;
import com.dmitrenko.userstorage.repository.UserRepository;
import com.dmitrenko.userstorage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;

import static com.dmitrenko.userstorage.util.Constant.QUEUE_ADD_USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;
	private final UserResponseMapper userResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	@RabbitListener(queues = QUEUE_ADD_USER)
	public UserResponse add(UserAddRequest request) {
		if(userRepository.findByUserName(request.getUserName()).isPresent())
			throw new EntityExistsException(String.format("User with user name [%s] already exist", request.getUserName()));

		var user = userMapper.from(request);
		user = userRepository.saveAndFlush(user);

		return userResponseMapper.from(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserResponse> getAll() {

		return userResponseMapper.from(userRepository.findAll());
	}
}
