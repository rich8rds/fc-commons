package com.favourite.collections.commons.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "notification.exchange";

    // Queue Names
    public static final String LOGIN_QUEUE = "loginQueue";
    public static final String OTP_QUEUE = "notification.queue.otp";
    public static final String USER_QUEUE = "notification.queue.user";
    public static final String USER_SERVICE_QUEUE = "notification.queue.user.service";
    public static final String PRODUCT_SERVICE_QUEUE = "notification.queue.product.service";
    public static final String ORDER_SERVICE_QUEUE = "notification.queue.order.service";


    // Routing Keys
    public static final String OTP_ROUTING_KEY = "notification.otp.*";
    public static final String USER_ROUTING_KEY = "notification.user.*";
    public static final String USER_SERVICE_ROUTING_KEY = "notification.user.service.*";
    public static final String PRODUCT_SERVICE_ROUTING_KEY = "notification.product.service.*";
    public static final String ORDER_SERVICE_ROUTING_KEY = "notification.order.service.*";

    // Specific Routing Keys
    public static final String VERIFICATION_ROUTING_KEY = "notification.otp.verification";
    public static final String PASSWORD_RESET_ROUTING_KEY = "notification.otp.password";
    public static final String WELCOME_ROUTING_KEY = "notification.user.welcome";
    public static final String PASSWORD_CHANGED_ROUTING_KEY = "notification.user.password";


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean("otpQueue")
    public Queue otpQueue() {
        return QueueBuilder.durable(OTP_QUEUE).build();
    }

    @Bean("userQueue")
    public Queue userQueue() {
        return QueueBuilder.durable(USER_QUEUE).build();
    }

    @Bean("userServiceQueue")
    public Queue USER_SERVICE_QUEUE() {
        return QueueBuilder.durable(USER_SERVICE_QUEUE).build();
    }

    @Bean("orderServiceQueue")
    public Queue orderServiceQueue() {
        return QueueBuilder.durable(ORDER_SERVICE_QUEUE).build();
    }

    @Bean("productServiceQueue")
    public Queue productServiceQueue() {
        return QueueBuilder.durable(PRODUCT_SERVICE_QUEUE).build();
    }

    @Bean
    public Binding otpBinding(@Qualifier("otpQueue") Queue otpQueue, TopicExchange exchange) {
        return BindingBuilder.bind(otpQueue).to(exchange).with(OTP_ROUTING_KEY);
    }


    @Bean
    public Binding userBinding(@Qualifier("userQueue") Queue userQueue, TopicExchange exchange) {
        return BindingBuilder.bind(userQueue).to(exchange).with(USER_ROUTING_KEY);
    }


    @Bean
    public Binding userServiceBinding(@Qualifier("userServiceQueue") Queue otpQueue, TopicExchange exchange) {
        return BindingBuilder.bind(otpQueue).to(exchange).with(USER_SERVICE_ROUTING_KEY);
    }

    @Bean
    public Binding orderServiceBinding(@Qualifier("orderServiceQueue") Queue otpQueue, TopicExchange exchange) {
        return BindingBuilder.bind(otpQueue).to(exchange).with(ORDER_SERVICE_ROUTING_KEY);
    }


    @Bean
    public Binding productServiceBinding(@Qualifier("productServiceQueue") Queue userQueue, TopicExchange exchange) {
        return BindingBuilder.bind(userQueue).to(exchange).with(PRODUCT_SERVICE_ROUTING_KEY);
    }

    @Bean("commonMessageConverter")
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
