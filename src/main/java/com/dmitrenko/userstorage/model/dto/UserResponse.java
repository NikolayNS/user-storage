package com.dmitrenko.userstorage.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserResponse {
	private UUID id;
	private String userName;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private LocalDateTime created;
}
