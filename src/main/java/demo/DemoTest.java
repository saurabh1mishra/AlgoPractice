package demo;

import java.util.Stack;

public class DemoTest {


    public static String soultion(String str) {

        Stack<String> chrr = new Stack<>();
        Stack<String> numeric = new Stack<>();
        String[] strArr = str.split("");
        StringBuilder sb = new StringBuilder();

        for (String cstr : strArr) {
            if (cstr.matches("\\d")) {
                numeric.push(cstr);
            } else if (cstr.matches("\\w")) {
                chrr.push(cstr);
            }
        }

        for (String cstr : strArr) {
            if (cstr.matches("\\d")) {
                sb.append(numeric.pop());
            } else if (cstr.matches("\\w")) {
                sb.append(chrr.pop());
            } else {
                sb.append(cstr);
            }
        }
            return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(DemoTest.soultion("ab#@12m@2#q"));
    }
}
