package arrays;


/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * <p>
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */
public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) if (nums[mid] == nums[mid + 1]) left = mid + 1;
            else right = mid - 1;
            if (mid % 2 == 1) if (nums[mid] == nums[mid - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left];

    }
}
