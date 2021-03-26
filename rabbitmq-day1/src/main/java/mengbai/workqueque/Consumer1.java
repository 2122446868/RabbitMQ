package mengbai.workqueque;

import com.rabbitmq.client.*;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Consumer1
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/24 16:46]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("workqueque", true, false, true, null);
        channel.basicConsume("workqueque", true, new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Customer1:" + new String(body));
            }
        });
    }
}
