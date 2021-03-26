package com.mengbai.hello;

import com.mengbai.RabbitmqSpringbootApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Provider
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 15:51]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class Provider {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void hello() {
        rabbitTemplate.convertAndSend("hello", "hello word");
    }

    @Test
    public void workqueque() {
        for (int i = 1; i <= 10; i++) {

            rabbitTemplate.convertAndSend("work", "hello work");
        }

    }

    @Test
    public void fanout() {
        rabbitTemplate.convertAndSend("fanoutLogs", null, "这是fanout模型");
    }

    @Test
    public void routing() {
        rabbitTemplate.convertAndSend("directs", "error", "error的日志信息");
    }

    @Test
    public void topic() {
        rabbitTemplate.convertAndSend("topics", "user.save.fandAll", "user.save.findAll 的消息");
    }
}
