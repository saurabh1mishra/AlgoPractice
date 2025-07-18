package algo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 2 pointer approach
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * https://www.interviewbit.com/blog/longest-substring-without-repeating-characters/
     *
     * @param
     * @return int with max size
     */
    public static int lengthOfLongestSubstring(String s) {

        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;
        Set<Character> hash_set = new HashSet<>();
        while (b_pointer < s.length()) {
            if (hash_set.add(s.charAt(b_pointer))) {
                b_pointer++;
                max = Math.max(hash_set.size(), max);
            } else {
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
