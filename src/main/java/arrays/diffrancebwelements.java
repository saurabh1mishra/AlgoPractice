package arrays;

import java.util.Arrays;

public class diffrancebwelements {
    public static int solution(int[] A) {
        int n = A.length;
        Arrays.sort(A); // sort the array in ascending order

        // iterate through all possible differences between consecutive numbers
        for (int diff = (A[n - 1] - A[0]) / (n - 1); diff >= 0; diff--) {
            int count = 1; // count of numbers in the subsequence
            int prev = A[0]; // previous number in the subsequence
            for (int i = 1; i < n; i++) {
                if (A[i] - prev == diff) {
                    count++;
                    prev = A[i];
                } else if (A[i] - prev > diff) {
                    break; // difference too large, try smaller diff
                }
            }
            if (count == n) {
                return count; // all numbers can be chosen
            }
        }
        return 2; // at least two numbers can always be chosen
    }

    public static void main(String[] args) {
        int[] ip = {4, 7, 1, 5, 3};
        System.out.println(solution(ip));
    }

}
