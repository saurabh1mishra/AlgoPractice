import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * string abc= "dsfgdsg ds dsgsdgsdgsdg sdgsdgsdgsd sdgsdgsdgsdgdsg dsgsdgsdgsdgs dfsdfsdfgsdfgsdgs dsfdsfsdfsdfsdfdsfdsf"
 */
public class LongestSubsstring {


    public static String solution(String input) {
        String[] str = input.split(" ");
        Arrays.sort(str);

        return str[str.length - 1];
    }

    public static void main(String[] args) {
        String abc = "dsfgdsg ds dsgsdgsdgsdg sdgsdgsdgsd sdgsdgsdgsdgdsg dsgsdgsdgsdgs dfsdfsdfgsdfgsdgs dsfdsfsdfsdfsdfdsfdsf";

        System.out.println(solution(abc));

    }


}
