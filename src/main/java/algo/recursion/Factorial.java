package algo.recursion;

import java.util.Scanner;

public class Factorial {
    static int fib(int num) {
        if (num == 1) {
            return 1;
        }
        return num * fib(num - 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of n:");
        int n = s.nextInt();
        System.out.println(fib(n));
    }

}