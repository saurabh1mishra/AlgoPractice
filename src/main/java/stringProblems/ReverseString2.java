package stringProblems;

public class ReverseString2 {

    static String reverse(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            int other = arr.length - i - 1;
            char temp = arr[i];
            arr[i] = arr[other];
            arr[other] = temp;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverse("abc"));
    }

}
