package com.dmitrenko.userstorage.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "user")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "app_user")
public class User extends BaseEntity {

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
}
