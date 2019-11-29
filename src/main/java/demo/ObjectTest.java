package demo;

import java.util.HashMap;
import java.util.Map;

public class ObjectTest {
    static class Emp {
        String name;
        String test;

        @Override
        public String toString() {
            return "Emp{" +
                    "name='" + name + '\'' +
                    ", test='" + test + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Emp emp = new Emp();
        Map<String, Object> map = new HashMap<>();
        map.put("test", "test");
        Object t = map.get("test");
        System.out.println(emp);

    }
}
