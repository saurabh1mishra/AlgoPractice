package StringProblems;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestPalindrome {
    public boolean isPlaindrome(String str) {
        if (str.length() == 1)
            return true;
        if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;
        if (str.length() > 3) {
            return isPlaindrome(str.substring(1, str.length() - 1));
        } else {
            return true;
        }
    }

    public static void main(String... args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String str[] = "ABCBAERRETTETET".split("");
        String subStr = "";
        List<String> plaindrome = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length; j++) {
                subStr += str[j];
                if (longestPalindrome.isPlaindrome(subStr)) {
                    plaindrome.add(subStr);
                }
            }
            subStr = "";
        }
        System.out.println(plaindrome);
        Optional<String> longString = plaindrome.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longString.get());
    }

}
