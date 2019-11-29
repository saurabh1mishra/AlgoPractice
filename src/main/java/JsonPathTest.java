import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class JsonPathTest {

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"9ECE784B-B30C-4243-9D54-3D0055E8AC69\": [\n" +
                "        \"Comments datatags\"\n" +
                "    ]\n" +
                "}";

        List str = JsonPath.read(json, "$.*[:1]");
        System.out.println(str.get(0));
    }
}
