package stringProblems;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: s = "cbbdaaccbb"
 * Output: "bb aa cc bb"
 * <p>
 * Example 3:
 * Input: s = "geekforgeegeegeekeeg"
 * Output: "eegeegee"
 * <p>
 * <p>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.*
 * * *
 */

public class MindTickleLongestPalindromic {

    public static boolean isPalindromic(String input) {

        char[] strArr = input.toCharArray();
        for (int i = 0; i < strArr.length / 2; i++) {
            char temp = strArr[strArr.length - 1 - i];
            strArr[strArr.length - 1 - i] = strArr[i];
            strArr[i] = temp;
        }

        String revString = String.valueOf(strArr);

        return input.equals(revString);

    }

    public static void solution(String input) {

        Set<String> result = new HashSet<>();
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            String str = "";
            for (int j = i; j < input.length(); j++) {
                str += input.charAt(j);
                if (isPalindromic(str)) {
                    result.add(str);
                    max = Math.max(max, str.length());
                }
            }
        }


        int finalMax = max;
        result.stream().distinct().filter(i -> (i.length() == finalMax)).forEach(System.out::println);
    }

    public static void main(String[] args) {

        String input = "babad";
        solution(input);
    }


}
