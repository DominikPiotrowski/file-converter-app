package pl.practice.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader implements IFileReader {

    private static final String CSV_FILE_SEPARATOR = ";";

    @Override
    public List<Map<String, String>> read(String filePath) {
        List<Map<String, String>> records = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            //pierwsza linia z nagłówkami, dzieli po separatorze
            String line = bufferedReader.readLine();
            String[] headers = line.split(CSV_FILE_SEPARATOR);

            //dzieli i dodaje do hashmapy
            while ((line = bufferedReader.readLine()) != null) {
                String[] cells = line.split(CSV_FILE_SEPARATOR);
                Map<String, String> record = new HashMap<>();

                //dodaje do mapy pod headerami odpowiednie wartości:
                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], cells[i]);
                }
                records.add(record);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}