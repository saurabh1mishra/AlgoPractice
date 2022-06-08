package stringProblems;

import java.util.Stack;

public class ReverseStringWithOutSpecialChar {


    public static String solution(String str) {

        Stack<String> chr = new Stack<>();
        Stack<String> numeric = new Stack<>();
        String[] strArr = str.split("");
        StringBuilder sb = new StringBuilder();

        for (String charStr : strArr) {
            if (charStr.matches("\\d")) {
                numeric.push(charStr);
            } else if (charStr.matches("\\w")) {
                chr.push(charStr);
            }
        }

        for (String charStr : strArr) {
            if (charStr.matches("\\d")) {
                sb.append(numeric.pop());
            } else if (charStr.matches("\\w")) {
                sb.append(chr.pop());
            } else {
                sb.append(charStr);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseStringWithOutSpecialChar.solution("ab#@12m@2#q"));
    }
}
