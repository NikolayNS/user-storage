package com.dmitrenko.userstorage.service.impl;

import com.dmitrenko.userstorage.model.dto.UserAddRequest;
import com.dmitrenko.userstorage.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.dmitrenko.userstorage.util.Constant.QUEUE_ADD_USER;

@Service
@RequiredArgsConstructor
public class QueueServiceImpl implements QueueService {

	private final RabbitTemplate rabbitTemplate;

	@Override
	@Transactional()
	public void sendAdd(UserAddRequest request) {
		rabbitTemplate.convertAndSend(QUEUE_ADD_USER, request);
	}
}
