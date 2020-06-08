package JVM;

public class SampleStackOverflow {

    // Use -Xss500k, then reduce it

    public static void main(String[] a) throws Exception {
        int x = 5;
        doSomething(1);

    }


    private static void doSomething (int counter) throws Exception {


        while (counter < 1000) {
            System.out.println("Inside loop , counter : " + counter );
            String nameProperty = "Person : " + counter;

            counter++;
            doSomething(counter);
        }
    }
}
