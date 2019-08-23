package pl.practice.Writer;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class writerUtils {

    Set<String> prepareHeaders(List<Map<String, String>> records) {
        Set<String> headers = new HashSet<>();

        for (Map<String, String> record : records) {
            headers.addAll(record.keySet());
        }
        return headers;
    }
}