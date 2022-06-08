/*

String actual = “$r$ev$$w”;
			 0123456
      //reverse = “w$ve$$r”
			 0123456
 */
public class StringReverse {

    static String rev(String input) {
        String[] str = input.split("");
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (StringReverse.isString(str[left])) {
                if (StringReverse.isString(str[right])) {
                    swap(str, left, right);
                }
                right = right - 1;
            }
            left = left + 1;
        }

        return printArray(str);
    }

    static void swap(String[] str, int left, int right) {
        String temp = str[left];
        str[left] = str[right];
        str[right] = temp;

    }

    static boolean isString(String str) {
        return str.matches("\\w");
    }

    static String printArray(String[] str) {
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String actual = "r$ev$$w";
        String rev = rev(actual);
        System.out.println(rev);
    }
}
