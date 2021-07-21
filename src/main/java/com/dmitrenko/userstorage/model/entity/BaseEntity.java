package com.dmitrenko.userstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue
	private UUID id;

	@CreationTimestamp
	@Column(name = "CREATED", nullable = false, updatable = false)
	private LocalDateTime created;
}
