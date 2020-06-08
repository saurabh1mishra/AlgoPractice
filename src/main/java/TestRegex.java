public class TestRegex {

    public static void main(String[] args) {
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
                    if (pointer < 0)
                        pointer = 0;
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
