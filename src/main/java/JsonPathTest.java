import com.jayway.jsonpath.JsonPath;

import java.util.List;

public final class JsonPathTest {
    private JsonPathTest() {
    }

    /**
     * @param args default conss
     */
    public static void main(final String[] args) {
        String json = "{\n"
                + "    \"9ECE784B-B30C-4243-9D54-3D0055E8AC69\": [\n"
                + "        \"Comments datatags\"\n"
                + "    ]\n"
                + "}";

        List<Object> str = JsonPath.read(json, "$.*[:1]");
        System.out.println(str.get(0));
    }
}
