package arrays;

/**
 *
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 */

import java.util.*;
import java.util.stream.Collectors;

public class SortArraybyIncreasingFrequency {
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        System.out.println(map);

        list.sort((x, y) -> !Objects.equals(map.get(x), map.get(y)) ? map.get(x) - map.get(y) : x - y);

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,1,3,2};
        System.out.println(Arrays.toString(frequencySort(input)));
    }
}
