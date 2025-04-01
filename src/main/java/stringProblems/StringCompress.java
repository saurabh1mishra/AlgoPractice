package stringProblems;

public class StringCompress {


    public static String compressString(String str) {
        StringBuilder compressed = new StringBuilder();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            int count = 1;

            // Count consecutive duplicates
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // Append character and count (if >1)
            compressed.append(str.charAt(i));
            if (count > 1) {
                compressed.append(count);
            }
        }

        return compressed.toString();
    }

    public static String solution(String input) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        char last = input.charAt(0);
        output.append(last);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == last) {
                count++;
            } else {
                output.append(count);
                last = input.charAt(i);
                output.append(last);
                count = 1;
            }
        }

        output.append(count);
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "AAADBBBBCCE";
        System.out.println(compressString(input));
    }
}
