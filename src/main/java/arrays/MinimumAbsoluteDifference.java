package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    /*
Given an array of distinct integers arr[], find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

1. a, b is from arr
2. a < b
3. b – a equals to the minimum absolute difference of any two elements in arr

     */
    public static void main(String[] args) {

        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};

        System.out.println(new MinimumAbsoluteDifference().minimumAbsDifference(arr));

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int tempDiff = arr[i + 1] - arr[i];
            minDiff = Math.min(minDiff, tempDiff);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int tempDiff = arr[i + 1] - arr[i];

            if (tempDiff == minDiff) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }
        }

        return result;
    }


}
