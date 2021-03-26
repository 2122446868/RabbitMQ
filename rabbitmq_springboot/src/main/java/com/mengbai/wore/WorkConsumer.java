package com.mengbai.wore;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Consumer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 16:34]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message) {
        System.out.println("work message1 = " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message) {
        System.out.println("work message2 = " + message);
    }
}
