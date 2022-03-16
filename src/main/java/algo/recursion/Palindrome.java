package algo.recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("tess5et"));
    }

    private static boolean isPalindrome(String str) {
        if (str.length() <= 1)
            return true;
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        if (str.length() > 3) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return true;
        }
    }
}


