package mengbai.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.jupiter.api.Test;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Provider
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/23 15:48]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Provider {

    /***
     * 生产消息
     */
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
/*//        创建连接mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
//      设置连接rabbitmq主机
        connectionFactory.setHost("8.136.219.183");
//        设置端口号
        connectionFactory.setPort(5672);
//        设置连接那个虚拟机
        connectionFactory.setVirtualHost("/emp");
//       设置访问须虚拟机的用户名和密码
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
//       获取连接对象
        Connection connection = connectionFactory.newConnection();*/
        Connection connection = RabbitMQUtils.getConnection();
//        获取连接中的通道
        Channel channel = connection.createChannel();
//        通道绑定对应的消息队列
//        参数1：队列名称，如果队列不存在自动创建
//        参数2：用来定义队列特性是否要持久化 true  持久化 false 不持久化
//        参数3:是否独占队列
//        参数4:是否自动删除
//        参数5:其他属性
        channel.queueDeclare("helloRabbitMQ", true, false, true, null);

//        发布消息
//        参数1：交换机名称  参数2：队列名称 参数3：传递消息额外设置， 参数4：消息的具体内容
        channel.basicPublish("", "helloRabbitMQ", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbiitmq".getBytes());
      /*  channel.close();
        connection.close();*/
        RabbitMQUtils.closeConnectionAndChannel(channel, connection);


    }

}
