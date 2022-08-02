package algo;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 */
public class InvalidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.length() == 1) return false;
            if (s.startsWith(")") || s.startsWith("}") || s.startsWith("]")) return false;
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}
