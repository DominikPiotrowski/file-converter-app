package pl.practice.Reader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONReader implements IFileReader {

    private static final String CHARSET_UTF8 = "UTF-8";

    @Override
    public List<Map<String, String>> read(String filePath) {

        List<Map<String,String>> records = new ArrayList<>();

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String content = new String(bytes, CHARSET_UTF8);

            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {

                Object recordRow = jsonArray.get(i);
                JSONObject record = new JSONObject(recordRow.toString());
                Map<String, String> parsedRecord = new HashMap<>();

                for (String key : record.keySet()) {
                    parsedRecord.put(key, record.get(key).toString());
                }
                records.add(parsedRecord);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}