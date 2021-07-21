package com.dmitrenko.userstorage.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class UserAddRequest implements Serializable {

	@NotNull(message = "Field [userName] mustn't be null")
	@NotBlank(message = "Field [userName] must be present")
	private String userName;

	@NotNull(message = "Field [firstName] mustn't be null")
	@NotBlank(message = "Field [firstName] must be present")
	private String firstName;


	private String lastName;

	@NotNull(message = "Field [birthDate] mustn't be null")
	private LocalDate birthDate;
}
