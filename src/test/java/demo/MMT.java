package demo;


import org.testng.annotations.Test;

import java.util.Stack;

public class MMT {

    public static boolean solution(String str) {
        String[] arr = str.split("");
        Stack<String> stack = new Stack<>();
        if (arr.length % 2 != 0) {
            return false;
        }

        if (arr[0].equals("}") || arr[0].equals("]") || arr[0].equals(")") || arr[0].equals(">")) {
            return false;
        }

        for (String ele : arr) {
            if (ele.equals("{") || ele.equals("[") || ele.equals("<") || ele.equals("(")) {
                stack.push(ele);
            } else if (ele.equals("}") || stack.peek().equals("}")) {
                stack.pop();
            } else if (ele.equals("]") || stack.peek().equals("[")) {
                stack.pop();
            } else if (ele.equals(")") || stack.peek().equals("(")) {
                stack.pop();
            } else if (ele.equals(">") || stack.peek().equals(">")) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    @Test(groups = {"test"})
    public void test() {
        String input = "{{[[()]]}}";
        boolean result = solution(input);
        System.out.println(result);
    }
}
