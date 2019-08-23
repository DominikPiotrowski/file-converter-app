package pl.practice.Writer;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONWriter implements IFileWriter {

    @Override
    public void write(List<Map<String, String>> records, String filePath) {

        //dla jsona nie musimy przygotowywać headerów

        JSONArray jsonArray = new JSONArray();

        for (Map<String, String> record : records) {
            jsonArray.put(record);
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(jsonArray.toString(2)); //od drugiego akapitu
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}