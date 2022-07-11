package edu.miu.waabackend.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMessagingConfig {
    public static final String QUEUE_ONE = "first_queue";
    public static final String EXCHANGE_ONE = "first_exchange";
    public static final String ROUTING_KEY_ONE = "routing_key_one";

    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE);
    }

    @Bean
    public TopicExchange exchangeOne() {
        return new TopicExchange(EXCHANGE_ONE);
    }

    @Bean
    public Binding bindingOne(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_ONE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
