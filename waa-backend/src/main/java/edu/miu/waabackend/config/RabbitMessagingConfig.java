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

    @Bean
    public Queue queueOne() {
        return new Queue(RoutingValues.QUEUE_ONE.toString());
    }

    @Bean
    public TopicExchange exchangeOne() {
        return new TopicExchange(RoutingValues.EXCHANGE_ONE.toString());
    }

    @Bean
    public Binding bindingOne(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RoutingValues.ROUTING_KEY_ONE.toString());
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
