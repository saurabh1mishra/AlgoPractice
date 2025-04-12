package algo;

import java.util.HashSet;
import java.util.Set;

public class APMissingNum {

    public static void main(String[] args) {
        int[] arr = {2, 6, 14};
        int size = arr.length;
        int missingNum = 0;
        int diff = (arr[size - 1] - arr[0]) / (size);
        for (int i = 0; i < size - 1; i++) {
            int nextNum = arr[i] + diff;
            if (nextNum != arr[i + 1]) {
                missingNum = nextNum;
                break;
            }
        }

        System.out.println(missingNum);
    }
}
