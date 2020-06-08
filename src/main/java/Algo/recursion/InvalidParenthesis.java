package Algo.recursion;

import java.util.Stack;

public class InvalidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i <s.length() ; i++){
            if(s.charAt(i)==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(s.charAt(i)=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else if(s.charAt(i)==']' && stack.peek()=='['){
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
