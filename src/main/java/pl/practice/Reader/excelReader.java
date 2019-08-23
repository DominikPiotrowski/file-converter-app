package pl.practice.Reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class excelReader implements IFileReader {
    @Override
    public List<Map<String, String>> read(String filePath) {
        List<Map<String, String>> result = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            //wiersz nagłówkowy:
            Row headerRow = sheet.getRow(0);
            List<String> headers = new ArrayList<>();

            Iterator<Cell> headerIterator = headerRow.iterator();

            while (headerIterator.hasNext()) {
                Cell cell = headerIterator.next();
                headers.add(cell.getStringCellValue());
            }

            //wiersze z danymi:
            Iterator<Row> rowIterator = sheet.rowIterator();

            //ignorowanie pierwszego wirsza:
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Map<String, String> record = new HashMap<>();
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                int currentColumn = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CellType cellType = cell.getCellType();

                    Object value = CellType.NUMERIC.equals(cellType) ?
                            cell.getNumericCellValue() : cell.getStringCellValue();

                    String currentColumnName = headers.get(currentColumn);
                    record.put(currentColumnName, value.toString());
                    currentColumn++;
                }
                result.add(record);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}