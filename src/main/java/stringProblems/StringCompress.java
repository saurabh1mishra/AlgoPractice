package stringProblems;

public class StringCompress {
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
        System.out.println(solution(input));
    }
}
