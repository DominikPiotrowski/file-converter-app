package pl.practice.Writer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class excelWriter implements IFileWriter {

    final writerUtils writerUtils = new writerUtils();

    @Override
    public void write(List<Map<String, String>> records, String filePath) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("records");
        Set<String> headers = writerUtils.prepareHeaders(records);

        //headery:
        Row headerRow = sheet.createRow(0);
        int cellCount = 0;
        for(String header : headers){
            headerRow.createCell(cellCount).setCellValue(header);
            cellCount++;
        }

        //reszta:
        int rowCount = 1;
        for(Map<String, String> record : records){
            Row row = sheet.createRow(rowCount);

            cellCount = 0;
            for (String header : headers) {
                row.createCell(cellCount).setCellValue(record.get(header));
                cellCount++;
            }
            rowCount++;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            workbook.write(fileOutputStream);
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
