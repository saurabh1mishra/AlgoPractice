package demo;

public class Test {
    public static void main(String[] args) {
        int sum = 0;
        int a = 0;

        while (sum++ < 3) {
            int b = (1 + 2 * sum) % 3;
            switch (b) {
                default:
                    break;
                case 0:
                    a -= 1;
                    break;
                case 1:
                    a += 5;
            }
        }
        System.out.println(a);
    }
}
