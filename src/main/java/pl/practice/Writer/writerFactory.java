package pl.practice.Writer;

public class writerFactory {

    public IFileWriter produce(String filePath) {
        IFileWriter writer = null;

        if(filePath.endsWith(".csv")) {
            writer = new CSVWriter();
        }
        if(filePath.endsWith(".json")) {
            writer = new JSONWriter();
        }
        if(filePath.endsWith(".xlsx")) {
            writer = new excelWriter();
        }
        return writer;
    }
}