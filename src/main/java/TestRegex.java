public class TestRegex {

    public static void main(String[] args) {
        int sum = 11;
        int counter = 3;
        System.out.println(Math.round((double) sum / counter));

        String S = fixString("ab#c");
        System.out.println(S);
    }

    public static String fixString(String s) {
        int pointer = -1;
        boolean swap = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                pointer++;
                if (swap) {
                    if (pointer < 0) pointer = 0;
                    //  s = s.replaceFirst(s.charAt(pointer), s.charAt(i));
                }
            } else {
                swap = true;
                pointer--;
            }
        }
        return s;
    }
}
