package stringProblems;

/**
 * * /**
 * * 97
 * * input = javaScripttest  is scripting language
 * * <p>
 * * ascii A = 98
 */

public class HotStarCamleCase {
    public static int soltuion(String input) {
        int result = 0;
        int ascaiiValueOfa = 97;

        if (input == null || input.length() == 0) {
            return -1;
        }

        String[] arrString = input.split("\\W+");

        for (String str : arrString) {
            char[] arr = str.toCharArray();
            for (int i = 1; i < arr.length; i++) {
                if (arr[0] < ascaiiValueOfa && (arr[i] < ascaiiValueOfa)) {
                    break;
                }
                result = Math.max(result, str.length());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "@#$%oneTwoThree 1TwoThree; oneTwoThree oneTwoThree oneTwoThree OneTWoThree";
        System.out.println(soltuion(input));

    }

}
