package stringProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestPalindrome {
    public boolean isPlaindromeRec(String str) {
        if (str.length() == 1) return true;
        if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
        if (str.length() > 3) {
            return isPlaindromeRec(str.substring(1, str.length() - 1));
        } else {
            return true;
        }
    }

    public boolean isPlaindrome(String str) {
        String str2 = reverse(str);
        return (str.equals(str2));
    }

    static String reverse(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            int other = arr.length - i - 1;
            char temp = arr[i];
            arr[i] = arr[other];
            arr[other] = temp;
        }

        return String.valueOf(arr);
    }

    public static void main(String... args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String[] str = "ABCBAERRETTETET".split("");
        List<String> plaindrome = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String subStr = "";
            for (int j = i; j < str.length; j++) {
                subStr += str[j];
                if (longestPalindrome.isPlaindrome(subStr)) {
                    plaindrome.add(subStr);
                }
            }
        }
        System.out.println(plaindrome);
        Optional<String> longString = plaindrome.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longString.get());
    }

}
