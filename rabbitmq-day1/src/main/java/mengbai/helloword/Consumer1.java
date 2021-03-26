package mengbai.helloword;

import com.rabbitmq.client.*;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Customer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/23 17:29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {

       //        创建连接mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
//      设置连接rabbitmq主机
        connectionFactory.setHost("8.136.219.183");
//        设置端口号
        connectionFactory.setPort(5673);
//        设置连接那个虚拟机
        connectionFactory.setVirtualHost("/emp");
//       设置访问须虚拟机的用户名和密码
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
//       获取连接对象
        Connection connection = connectionFactory.newConnection();
//        Connection connection = RabbitMQUtils.getConnection();
//        获取连接中的通道
        Channel channel = connection.createChannel();
        //        通道绑定对应的消息队列
//        参数1：队列名称，如果队列不存在自动创建
//        参数2：用来定义队列特性是否要持久化 true  持久化 false 不持久化
//        参数3:是否独占队列
//        参数4:是否自动删除
//        参数5:其他属性
        channel.queueDeclare("helloRabbitMQ", true, false, true, null);
//        消费消息
//        参数1：消费那个队列的消息 队列名称
//        参数2：开始小的自动确认机制
//        参数3：消费时的回调接口
        channel.basicConsume("helloRabbitMQ", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body：" + new String(body));
            }
        });
//        channel.close();
//        connection.close();


    }


}

