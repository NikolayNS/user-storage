package com.dmitrenko.userstorage.controller;

import com.dmitrenko.userstorage.model.dto.UserAddRequest;
import com.dmitrenko.userstorage.model.dto.UserResponse;
import com.dmitrenko.userstorage.service.QueueService;
import com.dmitrenko.userstorage.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.dmitrenko.userstorage.util.Constant.ADD_USER;
import static com.dmitrenko.userstorage.util.Constant.ADD_USER_RMQ;
import static com.dmitrenko.userstorage.util.Constant.GET_ALL_USERS;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final QueueService queueService;

	@Operation(description = "Добавление нового пользователя на прямую в БД")
	@PostMapping(value = ADD_USER, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> add(@RequestBody @Valid UserAddRequest request) {
		log.debug(String.format("Add user with name %s", request.getUserName()));
		log.debug(request.toString());
		return ResponseEntity.ok(userService.add(request));
	}

	@Operation(description = "Добавление нового пользователя через RabbitMQ")
	@PostMapping(value = ADD_USER_RMQ, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public void sendAdd(@RequestBody @Valid UserAddRequest request) {
		log.debug(String.format("Send user with name %s to RabbitMQ", request.getUserName()));
		log.debug(request.toString());

		queueService.sendAdd(request);
	}

	@Operation(description = "Получение всех пользователей")
	@GetMapping(value = GET_ALL_USERS, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserResponse>> getAll() {
		log.debug("Get all users");
		return ResponseEntity.ok(userService.getAll());
	}
}
