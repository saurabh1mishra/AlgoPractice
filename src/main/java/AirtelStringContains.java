
/*
str1 = "saurabh"
str2 = "xyzsaurabhisQA"

*/


public class AirtelStringContains {

    public static boolean solution(String keyword, String str2) {

        if (keyword.length() > str2.length()) {
            return false;
        }

        boolean result = false;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == keyword.charAt(0) || !result) {
                int a = 0;
                for (int j = i; j < str2.length(); j++) {
                    if (str2.charAt(j) != keyword.charAt(a)) {
                        result = false;
                        break;
                    }
                    a++;
                    if (a == keyword.length()) {
                        result = true;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static boolean solution2(String keyword, String string){
        return string.indexOf(keyword) != -1;
    }

    public static void main(String[] args) {
        String keyword = "saurabh";
        String string = "mynameissaurabhmishra";
        System.out.println(solution2(keyword, string));
    }
}
