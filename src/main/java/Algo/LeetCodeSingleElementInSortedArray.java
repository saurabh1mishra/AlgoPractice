package Algo;

public class LeetCodeSingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
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
            if (mid % 2 == 0)
                if (nums[mid] == nums[mid + 1])
                    left = mid + 1;
                else
                    right = mid - 1;
            if (mid % 2 == 1)
                if (nums[mid] == nums[mid - 1])
                    left = mid + 1;
                else
                    right = mid - 1;
        }
        return nums[left];

    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 8, 8};

        System.out.println(singleNonDuplicate(arr));
    }


}
