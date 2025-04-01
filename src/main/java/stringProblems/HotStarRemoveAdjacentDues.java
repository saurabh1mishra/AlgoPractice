package stringProblems;

import java.util.Stack;

/**
 * acaaabbbacdddd
 * <p>
 * acac
 */
public class HotStarRemoveAdjacentDues {


    public static String removeAdjacentDuplicates(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();  // Remove adjacent duplicate
            } else {
                stack.push(ch);
            }
        }

        // Convert stack to string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }


    public static String solution(String str) {


        StringBuilder res = new StringBuilder();

        if (str.charAt(0) != str.charAt(1)) {
            res.append(str.charAt(0));
        }

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i - 1) != str.charAt(i) && str.charAt(i + 1) != str.charAt(i)) {
                res.append(str.charAt(i));
            }
        }

        if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) {
            res.append(str.charAt(str.length() - 1));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String in = "acaaabbbacddddee";
        System.out.println(solution(in));
    }
}



