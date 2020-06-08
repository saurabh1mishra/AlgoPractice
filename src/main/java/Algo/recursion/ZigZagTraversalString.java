package Algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversalString {

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 4);
    }

    public static String convert(String s, int numRows) {
        if (numRows==1)
            return s;
        String res = "";
        int row = 0, col = 0, counter = 0;

        List<List<Character>> matrix = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            matrix.add(new ArrayList<Character>());
        }
        while (counter < s.length()) {
            if (row < numRows) {
                if(col!=0)
                    row++;
                while (row < numRows) {
                    if (counter == s.length()) {
                        break;
                    }
                    matrix.get(row).add(col, s.charAt(counter));
                    counter++;
                    row++;
                }
            }
            if (row == numRows) {
                row = row - 2;
                col++;
                while (row >= 0) {
                    if (counter == s.length()) {
                        break;
                    }
                    for (int i = 0; i < numRows; i++) {
                        matrix.get(i).add(col, ' ');
                    }
                    matrix.get(row).add(col, s.charAt(counter));
                    counter++;
                    col++;
                    row--;
                }
                row++;
                col--;
            }
        }

        for (List<Character> rw : matrix) {
            res +='\n';
            for (Character ch : rw) {
               // if(ch != ' ')
                 res += ch;
            }
        }

        System.out.println(res);
        return res;
    }
}
