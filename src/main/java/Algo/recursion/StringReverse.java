package Algo.recursion;

class StringReverse {
    private void reverseStr(String str) {
        if (str == null || str.isEmpty())
            return;
        System.out.print(str.charAt(str.length() - 1));
        reverseStr(str.substring(0, str.length() - 1));
    }

    private static String reverseStr2(String str) {
        if (str == null || str.isEmpty())
            return str;
        return reverseStr2(str.substring(1)) + str.charAt(0);
    }

    public static void main(String... args) {
        reverseStr2("test reverse function");
    }
}