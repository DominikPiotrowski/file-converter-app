package pl.practice.Converter;

import pl.practice.Reader.readerFactory;
import pl.practice.Reader.IFileReader;
import pl.practice.Writer.IFileWriter;
import pl.practice.Writer.writerFactory;

import java.util.List;
import java.util.Map;

public class fileConverter {
    public void convert(String sourcePath, String outputPath) {

        readerFactory readerFactory = new readerFactory();
        IFileReader reader = readerFactory.produce(sourcePath);
        List<Map<String,String>> records = reader.read(sourcePath);

        writerFactory writerFactory = new writerFactory();
        IFileWriter writer = writerFactory.produce(outputPath);
        writer.write(records,outputPath);
    }
}