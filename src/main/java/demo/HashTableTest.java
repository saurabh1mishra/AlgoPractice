package demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
       // Map<String, String> hashtable = new HashMap<>();
        hashtable.put("a", "x");
        System.out.println(hashtable);
    }
}
