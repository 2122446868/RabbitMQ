package mengbai.topics;

import com.rabbitmq.client.*;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Consumer1
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 15:01]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //        声明交换机  和交换机类型(通配符方式)
        channel.exchangeDeclare("topics", "topic");
//        创建临时队列
        String queue = channel.queueDeclare().getQueue();
//       绑定队列与交换机并设置获取交换机中动态路由
        channel.queueBind(queue, "topics", "user.#");
//        消费
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2: " + new String(body));
            }
        });

    }
}
