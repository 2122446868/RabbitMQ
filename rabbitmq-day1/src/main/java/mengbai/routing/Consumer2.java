package mengbai.routing;

import com.rabbitmq.client.*;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Consumer1
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 14:08]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct", "direct");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, "logs_direct", "error");
        channel.queueBind(queue, "logs_direct", "wrong");
        channel.queueBind(queue, "logs_direct", "info");
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2: " + new String(body));
            }
        });


    }
}
