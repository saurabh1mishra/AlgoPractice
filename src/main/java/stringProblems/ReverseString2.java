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

    static String reversePartial(String str, int start, int end) {
        char[] arr = str.toCharArray();
        char temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    /*Function to reverse arr[] from index start to end*/
    static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static String swapString(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        System.out.println(reversePartial("abcdef",2,4));
    }

}
