package rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.util.Queue;

public class PublisherMQ {
    private final static String QUEUE_NAME = "EXECUTIONID/TABLENAME";
    private static final String EXCHANGE_NAME = "test_excahnge";


    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            String message = "Hello "+ QUEUE_NAME;
            channel.queueDeclare(QUEUE_NAME, true,false,false,null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
            channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }
}
