package FunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Supplier;

interface Itest{
    public void run(String str);
}


public class MethodRef {


    private void testImpl(String str) {
        System.out.println(str);
    }

    private String test(){
        return "Supplier";
    }


    public static void main(String[] args) {


        Consumer<String> itest = new MethodRef()::testImpl;
        Supplier<String> itestSupplier = new MethodRef()::test;
        itest.accept("test");
        System.out.println(itestSupplier.get());

    }
}