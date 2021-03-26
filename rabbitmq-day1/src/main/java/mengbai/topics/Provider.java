package mengbai.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Provider
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 14:53]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
//        声明交换机  和交换机类型(通配符方式)
        channel.exchangeDeclare("topics", "topic");
//        动态路由
        String routingKey = "user.save";
        channel.basicPublish("topics", routingKey, null, ("这是路由中的动态订阅模型,route key: [" + routingKey + "]").getBytes());
        RabbitMQUtils.closeConnectionAndChannel(channel, connection);
    }
}
