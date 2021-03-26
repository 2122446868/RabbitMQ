package com.mengbai.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FanoutConsumer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 16:46]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class FanoutConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue //创建临时队列
            , exchange = @Exchange(name = "fanoutLogs", type = "fanout") //绑定交换机类型
    ))
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue, exchange = @Exchange(name = "fanoutLogs", type = "fanout")))
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }

}
