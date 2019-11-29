package RabbitMQ_Utils;

import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Producer extends EndPoint{


    public Producer(String endpointName) throws IOException, TimeoutException {
        super(endpointName);
    }

    public void sendMessage(String msg) throws IOException {
        channel.basicPublish("",endPointName, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
    }
}
