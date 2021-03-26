package mengbai.fanout;

import com.rabbitmq.client.*;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Customer
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 11:56]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException {
//        获取连接
        Connection connection = RabbitMQUtils.getConnection();
//        创建通道
        Channel channel = connection.createChannel();
//        创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //将临时队列绑定exchange
        channel.queueBind(queue, "logs", "");
//        消费消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1: " + new String(body));
            }
        });

    }
}
