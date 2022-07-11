package edu.miu.waabackend.consumer;

import edu.miu.waabackend.config.RabbitMessagingConfig;
import edu.miu.waabackend.dto.StudentDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {

    @RabbitListener(queues = RabbitMessagingConfig.QUEUE_ONE)
    private void consumeMessageFromQueue(StudentDto student){
        System.out.println("Messages Queue One" +student);
    }
}
