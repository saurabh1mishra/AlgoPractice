package JVM;


import java.util.HashMap;
import java.util.Map;

public class StackDemo {


    public static void main(String[] a) throws Exception {

        int counter = 1;
        Map<String, SomeClass> tempMap = new HashMap<>();

        while (counter < 120) {
            System.out.println("Inside loop , counter : " + counter );

            String nameProperty = "Person : " + counter;
            SomeClass someClass = null;
            someClass = new SomeClass(counter, nameProperty, counter);

            tempMap.put(String.valueOf(counter), someClass);
            Thread.sleep(1000);

            counter++;
        }
    }
}

class SomeClass {
    int pid;
    String name;
    Integer age;

    public SomeClass(int id, String name, Integer age) {
        setName(name);
        setPid(id);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        someMethodOfSomeClass(name);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
        System.out.println("pid value is :" + pid);
    }

    public static void someMethodOfSomeClass (String name) {
        System.out.println("name is :" + name);
    }
}
