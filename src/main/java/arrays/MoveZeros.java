package arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {

        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        
        for (int j = ptr; j < nums.length; j++) {
            nums[j] = 0;
        }

    }
}
