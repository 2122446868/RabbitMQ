package com.mengbai.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

/**
 * RoutingConsumer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 16:53]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class RoutingConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(), key = {"info", "error"}, exchange = @Exchange(type = "direct", name = "directs")))
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(), key = {"info"}, exchange = @Exchange(type = "direct", name = "directs")))
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }
}
