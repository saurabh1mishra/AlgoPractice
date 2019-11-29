import java.util.UUID;

public class TestThreadLocal {
    public static void main(String[] args) {
        new Thread(new Worker("worker1")).start();
        new Thread(new Worker("worker2")).start();
    }
}
class TransactionManager {
    private static final InheritableThreadLocal<String> context = new InheritableThreadLocal(){
        @Override
        protected String childValue(Object parentValue) {
            return "child data.";
        }
    };

    public static void startTransaction() {
        context.set(UUID.randomUUID().toString());
    }
    public static String getTransactionId() {
        return context.get();
    }
    public static void endTransaction() {
        context.remove();
    }
}
class Worker implements Runnable {
    private final String name;
    Worker(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        TransactionManager.startTransaction();
        System.out.println(name + " after start - " + TransactionManager.getTransactionId());
        SubWorker subWorker = new SubWorker("sub" + name);
        Thread subWorkerThread = new Thread(subWorker);
        subWorkerThread.start();
        try {
            subWorkerThread.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " after subworker - " + TransactionManager.getTransactionId());
        TransactionManager.endTransaction();
        System.out.println(name + " after end - " + TransactionManager.getTransactionId());
    }
}
class SubWorker implements Runnable {
    private final String name;
    SubWorker(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " - " + TransactionManager.getTransactionId());
        TransactionManager.startTransaction();
        System.out.println("chaninging "+name + " - " + TransactionManager.getTransactionId());

    }
}