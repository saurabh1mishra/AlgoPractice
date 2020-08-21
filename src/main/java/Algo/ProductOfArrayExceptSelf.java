package Algo;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] left_product = new int[size];
        int[] right_product = new int[size];
        left_product[0] = 1;
        right_product[size - 1] = 1;
        for (int i = 0; i < size - 1; i++) {
            left_product[i + 1] = nums[i] * left_product[i];
        }
        for (int j = nums.length - 1; j > 0; j--) {
            right_product[j - 1] = nums[j] * right_product[j];
        }
        for (int i = 0; i < size; i++) {
            nums[i] = left_product[i] * right_product[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
