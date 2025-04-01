package algo;

import java.util.HashMap;
import java.util.Map;

public class SortMapbyValues {
    public static void main(String[] args) {

        // Create a Map with some initial values
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);

        // Stream the map's entry set, sort by value, and print each entry
        map.entrySet()
                .stream() // Convert the map's entry set to a stream
                .sorted(Map.Entry.comparingByValue()) // Sort the stream by the values
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue())); // Print each entry

    }
}
