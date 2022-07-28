package arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSumSubarray {

    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int curr_sum = nums[0];
        for (int i = 1; i<nums.length ; i++ ) {
            curr_sum = Math.max(nums[i], curr_sum+nums[i]);
            max_sum = Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }
}
