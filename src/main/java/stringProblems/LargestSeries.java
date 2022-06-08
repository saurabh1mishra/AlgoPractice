package stringProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/***
 Find the largest series present in an array. Examples:   
 Input :
 arr[] = {1, 2, -3, 2, 3, 4, -6, 1, 2, 3, 4, 5, -8, 5, 6}
 Output :Index : 7, length : 5

 Input : arr[] = {-3, -6, -1, -3, -8}
 Output : No positive sequence detected.
 **/
// Main class should be named 'Solution'
class LargestSeries {

    public static int[] findLargestArray(int[] arr) {

        int index = 0;
        int size = 0;
        int aPointer = 0;
        List<Integer> series = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                series.add(arr[i]);
                break;
            }
            throw new Error("no postive number found.");
        }

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] + 1 == arr[i + 1]) {
                series.add(i);
            } else {
                if (size < series.size()) {
                    size = series.size();
                    Collections.sort(series);
                    index = series.get(0);
                }
                series = new ArrayList<>();
            }
        }

        return new int[]{index, size};
    }


    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, -3, 2, 3, 4, -6, 1, 2, 3, 4, 5, -8, 5, 6};
        int arr2[] = new int[]{-3, -6, -1, -3, -8};
        int[] result = findLargestArray(arr2);
        System.out.println(Arrays.toString(result));
    }
}