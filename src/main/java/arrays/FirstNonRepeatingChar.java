package arrays;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */

import java.util.*;


public class FirstNonRepeatingChar {
    public static int firstUniqChar(String s) {

        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int result = -1;

        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
