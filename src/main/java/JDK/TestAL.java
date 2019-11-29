package JDK;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAL {
    public static void main(String[] args) {

        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        String te = "";
        te += StringUtils.join(test, ",");

        System.out.println(te);
        System.out.println(test.stream().collect(Collectors.joining(",")).toString());
    }
}
