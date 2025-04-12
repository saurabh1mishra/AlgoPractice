package demo;

import java.lang.reflect.Array;
import java.util.*;

/**
 * ddddaabbbbbccee
 */

public class DPWorld {

    public static void main(String[] args) {
        String str = "ddddaabbbbbccee";
        char[] arr = str.toCharArray();

        Map<Character, Integer> acc = new HashMap<>();

        for (char chars : arr) {
            if (acc.containsKey(chars)) {
                acc.put(chars, acc.get(chars) + 1);
            } else {
                acc.put(chars, 1);
            }
        }

        PriorityQueue<Character> result = new PriorityQueue<>((a, b) -> acc.get(b) - acc.get(a));

        result.addAll(acc.keySet());

        StringBuilder sb = new StringBuilder();

        while (!result.isEmpty()) {
            char ch = result.poll();
            for (int i = 0; i < acc.get(ch); i++)
                sb.append(ch);
        }

        System.out.println(sb.toString());
    }

        /*  Arrays.sort(arr, (a, b) -> {
          if (acc.get(a) == acc.get(b)) {
                return (char) a - (char) b;
            }
            return acc.get(a) - acc.get(b);
        } );
        */

}

