package pl.practice.Reader;

public class readerFactory {

    public IFileReader produce(String filePath) {
        IFileReader reader = null;

        if (filePath.endsWith(".csv")) {
            reader = new CSVReader();
        }
        if (filePath.endsWith(".json")) {
            reader = new JSONReader();
        }
        if (filePath.endsWith(".xlsx")) {
            reader = new excelReader();
        }
        return reader;
    }
}
