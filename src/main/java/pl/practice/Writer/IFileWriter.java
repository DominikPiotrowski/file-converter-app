package pl.practice.Writer;

import java.util.List;
import java.util.Map;

public interface IFileWriter {
    void write(List<Map<String, String>> records, String filePath);
}
