package mengbai.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import javafx.scene.control.RadioButton;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * Provider
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/25 14:02]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Provider {
    public static void main(String[] args) throws IOException {
//        获取连接
        Connection connection = RabbitMQUtils.getConnection();
//        创建通道
        Channel channel = connection.createChannel();
//       声明交换机
        channel.exchangeDeclare("logs_direct", "direct");
//      路由
        String routingKey = "error";
//        发布消息
        channel.basicPublish("logs_direct", routingKey, null, ("制定的 routingKey:" + routingKey + "的消息").getBytes());
//       释放资源
        RabbitMQUtils.closeConnectionAndChannel(channel, connection);
    }
}
