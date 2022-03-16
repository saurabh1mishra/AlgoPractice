package stringProblems;

public class ReverseString {


    public static String reverse(String str) {

        String[] words = str.split("\\s");

        String outputdata = "";

        for (int i = words.length - 1; i >= 0; i--) {

            outputdata = outputdata + words[i] + " ";

        }
        return outputdata.trim();

    }

    public static void main(String[] args) {

        String str = "There is a cat";
        String expectedoutput = "cat a is There";

        System.out.println();
        String output = reverse(str);
        System.out.println(output.equals(expectedoutput));
        System.out.println(output);


    }
}