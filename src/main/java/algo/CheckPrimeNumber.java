package algo;

public class CheckPrimeNumber {

    public boolean isPrime(int number) {
        for (int i = 2; i * i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
