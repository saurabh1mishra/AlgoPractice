package stringProblems;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * without any aux space
 * explanation Link : https://www.scaler.com/academy/mentee-dashboard/classroom/solve-strings-problems-under-25-mins-a9777f64-df81-44f9-a70a-44f57d9aa7a3/?status=bonus%2F#lecture
 */
public class ReverseASentence {
    public static String solution(String input) {
        input = reverse(input, 0, input.length() - 1);

        int p1 = 0, p2 = 0;
        while (p1 < input.length() - 1) {
            while (input.charAt(p2) != ' ' & p2 < input.length() - 1) {
                p2++;
            }
            input = reverse(input, p1, p2 - 1);
            p1 = p2 + 1;
            p2 = p1;
        }
        return input;
    }

    public static String reverse(String input, int start, int end) {
        char[] arr = input.toCharArray();
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    public static  String solution2(String input){

         String[] arr = input.split("\\s+");

         for(int i = 0; i < arr.length/ 2 ; i ++){
             String temp = arr[arr.length-1-i];
             arr[arr.length-1-i] = arr[i];
             arr[i] = temp;
         }

         return String.join(" ", arr);

    }


    public static  String reverse(String input){

        char[] arr = input.toCharArray();

        for(int i = 0; i < arr.length/ 2 ; i ++){
            char temp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[i];
            arr[i] = temp;
        }

        return String.valueOf(arr);

    }

    public static void main(String[] args) {
        String input = "I Love India";
        System.out.println(solution2(input));
    }

}
