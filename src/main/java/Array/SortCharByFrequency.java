package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<Character> queue = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : map.keySet())
            queue.offer(ch);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            for (int i = 0; i < map.get(ch); i++)
                sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharByFrequency scByFreqObj = new SortCharByFrequency();
        System.out.println(scByFreqObj.frequencySort("tree"));
    }
}