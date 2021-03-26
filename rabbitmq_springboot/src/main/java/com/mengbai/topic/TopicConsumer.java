package com.mengbai.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * TopicConsumer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 17:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"user.*"},
            exchange = @Exchange(type = "topic", name = "topics")))
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    key = {"user.#"},
                    exchange = @Exchange(type = "topic", name = "topics")
            )
    })
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }

}
