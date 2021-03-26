package mengbai.workqueque;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import mengbai.utils.RabbitMQUtils;

import java.io.IOException;

/**
 * provider
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/24 16:40]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class provider {
    public static void main(String[] args) throws IOException {
//        获取连接
        Connection connection = RabbitMQUtils.getConnection();
//        获取通达
        Channel channel = connection.createChannel();
//        道绑定对应的消息队列
        channel.queueDeclare("workqueque", true, false, true, null);
        for (int i = 1; i <= 20; i++) {

//        发布消息
            channel.basicPublish("", "workqueque", null, (i+"hello work queque") .getBytes());
        }

        RabbitMQUtils.closeConnectionAndChannel(channel, connection);

    }

}
