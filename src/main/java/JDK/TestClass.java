package JDK;

public class TestClass implements Itest1,ITest2 {

    public static void main(String[] args) {
        TestClass test = new TestClass();
        test.test();
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
