package hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapObjectTest {
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
        emp.name = "saurabh";
        emp.test = "1";
        Map<String, Object> map = new HashMap<>();
        map.put("test", emp);
        Object t = map.get("test");
        emp.name = "changed";
        System.out.println(t);

    }
}
