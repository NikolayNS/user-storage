package com.dmitrenko.userstorage.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.dmitrenko.userstorage.util.Constant.EXCHANGE;
import static com.dmitrenko.userstorage.util.Constant.QUEUE;

@Configuration
public class RabbitConfiguration {

	@Bean
	public Queue queue() {
		return new Queue(QUEUE, false);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder
			.bind(queue)
			.to(exchange)
			.with("foo.bar.#");
	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
		var container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE);
		return container;
	}
}
