package Algo.recursion;

public class FIb {
       public static int  fib(int num){
        if (num<=1){
            return num;
        }
        return fib(num - 1) + fib(num - 2);
       } 
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}