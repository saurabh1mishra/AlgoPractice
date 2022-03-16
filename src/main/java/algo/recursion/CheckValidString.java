package algo.recursion;

import java.util.Stack;

public class CheckValidString {

    public static boolean checkValidString(String s) {
        Stack stack = new Stack();
        int count_of_star = 0;
        int count_of_parathsiss= 0;
        for (String str : s.split("")) {
            if (str.equals("(")) {
                stack.push(str);
                count_of_parathsiss++;
            } else if (str.equals("*")) {
                if(stack.peek().equals("("))
                stack.push(str);
                count_of_star++;
            } else {
                if ((stack.size() == 0)) {
                    return false;
                } else {
                    if (stack.peek().equals("*")) {
                        stack.pop();
                        count_of_star--;
                    } else if (stack.peek().equals("(")) {
                        stack.pop();
                        count_of_parathsiss--;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0 || count_of_parathsiss < count_of_star;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(((*))))"));
    }
}

