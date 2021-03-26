package com.mengbai.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Consumer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 15:55]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {

    @RabbitHandler
    public void receivel(String message) {
        System.out.println("message======" + message);

    }

}
