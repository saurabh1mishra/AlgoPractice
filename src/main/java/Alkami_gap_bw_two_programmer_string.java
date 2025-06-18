import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alkami_gap_bw_two_programmer_string {
    public static void main(String[] args) {
        String input = "xproxgrxammxerabcprgxmamer";
        int matchEndIndex = findProgrammerMatchEndIndex(input);

        if (matchEndIndex != -1) {
            System.out.println("All characters of 'programmer' matched by index: " + matchEndIndex);
        } else {
            System.out.println("'programmer' not fully matched in the input string.");
        }
    }

    public static int findProgrammerMatchEndIndex(String input) {
        String matchString = "programmer";
        String[] arr = matchString.split("");
        List<String> targetChars = new ArrayList<>(Arrays.asList(arr));
        System.out.println(targetChars);
        for (int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));
            if (targetChars.contains(currentChar)) {
                targetChars.remove(currentChar);
                if (targetChars.isEmpty()) {
                    return i; // All characters matched
                }
            }
        }
        return -1; // Not all characters matched
    }
}
