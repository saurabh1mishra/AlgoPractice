package stringProblems;

/**
 * acaaabbbacdddd
 * <p>
 * acac
 */
public class HotStarRemoveAdjacentDues {

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



