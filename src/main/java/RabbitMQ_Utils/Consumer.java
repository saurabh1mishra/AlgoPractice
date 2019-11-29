package RabbitMQ_Utils;

import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer extends EndPoint {
    public Consumer(String endpointName) throws IOException, TimeoutException {
        super(endpointName);
    }

    public void getMessage() throws IOException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(endPointName, true, deliverCallback, consumerTag -> {
        });

    }

    public String retrievemsg() throws IOException {
        return new String(channel.basicGet(endPointName, true).getBody());
    }
}
