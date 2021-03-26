package mengbai.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMQUtils
 * <功能详细描述>
 *
 * @author 赵长春
 * @version [版本号, 2021/3/24 13:57]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory;

    static {
        //        创建连接mq的连接工厂对象
        connectionFactory = new ConnectionFactory();
//      设置连接rabbitmq主机
        connectionFactory.setHost("8.136.219.183");
//        设置端口号
        connectionFactory.setPort(5672);
//        设置连接那个虚拟机
        connectionFactory.setVirtualHost("/emp");
//       设置访问须虚拟机的用户名和密码
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

    }


    public static Connection getConnection() {
        try {

//       获取连接对象
            return connectionFactory.newConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChannel(Channel channel, Connection connection) {
        try {

            if (channel != null)
                channel.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
