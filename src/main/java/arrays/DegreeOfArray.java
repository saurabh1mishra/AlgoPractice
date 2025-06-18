package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> acc = new HashMap<>();

        for (int ele : nums) {
            acc.put(ele, acc.getOrDefault(ele, 0) + 1);
        }

        return acc.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() * entry.getValue())
                .orElse(0);
    }

    public int findShortestSubArray2(int[] nums) {
        int maxDegree = 1;
        int currDegree = 1;
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                currDegree ++ ;
            } else {
                maxDegree =  Math.max(currDegree, maxDegree);
                currDegree = 1;
            }
        }

        return maxDegree;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        int result = degreeOfArray.findShortestSubArray(nums);
        System.out.println("The length of the shortest subarray with the same degree is: " + result);
    }
}
