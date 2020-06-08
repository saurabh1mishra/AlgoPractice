package JDK;

public class TestClass implements Itest1
      //  ,ITest2
{
    TestClass(){
        Itest1.super.test();
   //     ITest2.super.test();
    }

    public static void main(String[] args) {
        TestClass test = new TestClass();
        test.test();

    }



  /*  @Override
    public void test() {
        Itest1.super.test();
       // ITest2.super.test();
        //System.out.println("test");
    }*/
}
