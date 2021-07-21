package com.dmitrenko.userstorage.util;

public class Constant {

	private Constant() {
	}

	public static final String ADD_USER = "/api/v1/users/add";
	public static final String ADD_USER_RMQ = "/api/v1/users/add-rmq";
	public static final String GET_ALL_USERS = "/api/v1/users";

	public static final String QUEUE = "users-queue";
	public static final String EXCHANGE = "users-exchange";
	public static final String QUEUE_ADD_USER = EXCHANGE + ".sendAddUser";
}
