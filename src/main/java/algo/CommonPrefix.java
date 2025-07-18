package algo;

import java.util.Arrays;

public class CommonPrefix {
    public static void main(String args[]) {
        String[] arr = {"mint", "mini", "mineral"};
        int size = arr.length;
        // The longest common prefix of an empty array is "".
        if (size == 0) {
            System.out.println("Longest common prefix: ");
        }
        // The longest common prefix of an array containing
        // only one element is that element itself.
        else if (size == 1) {
            System.out.println("Longest common prefix: " + arr[0]);
        } else {
            // Sort the array
            Arrays.sort(arr);
            int length = arr[0].length();
            StringBuilder res = new StringBuilder();
            // Compare the first and the last strings character
            // by character.
            for (int i = 0; i < length; i++) {
                // If the characters match, append the character to the result.
                if (arr[0].charAt(i) == arr[size - 1].charAt(i)) {
                    res.append(arr[0].charAt(i));
                }
                // Else, stop the comparison.
                else {
                    break;
                }
            }
            String result = res.toString();
            System.out.println("Longest common prefix: " + result);
        }
    }
}
