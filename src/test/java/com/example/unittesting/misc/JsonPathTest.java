package com.example.unittesting.misc;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    private final String JSON_RESPONSE =
            "[{\"id\":100,\"phoneNo\":0,\"userName\":\"User0\",\"details\":\"100, 0, User0\"}," +
            "{\"id\":101,\"phoneNo\":11111111,\"userName\":\"User1\",\"details\":\"101, 11111111, User1\"}," +
            "{\"id\":102,\"phoneNo\":22222222,\"userName\":\"User2\",\"details\":\"102, 22222222, User2\"}]";

    // Tutorial: https://www.baeldung.com/guide-to-jayway-jsonpath
    @Test
    public void test_noOfObjectsInJsonArray() {
        DocumentContext context = JsonPath.parse(JSON_RESPONSE);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(100,101,102);

        List<String> userNames = context.read("$..userName");
        assertThat(userNames).containsExactly("User0","User1","User2");
    }
}
