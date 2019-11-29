package RabbitMQ_Utils;

        import java.io.IOException;
        import java.util.concurrent.TimeoutException;

public class TestProducerConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        String Queue = "test_java_dp";
        Producer p = new Producer(Queue);
        p.sendMessage("testing new Design pattern");
        Consumer c = new Consumer(Queue);
        System.out.println(c.retrievemsg());
    }
}
