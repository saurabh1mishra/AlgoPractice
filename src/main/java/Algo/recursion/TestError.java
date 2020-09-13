package Algo.recursion;

public class TestError {

    void Base() {
        throw new Error();
    }

    public static void main(String[] args) {
        TestError test = new TestError();
        try {
            test.Base();
        } catch (Exception e) {
            System.out.println("test");
        }
        finally {
            System.out.println("test 1");
        }

    }
}
