package Reader;

import org.junit.Assert;
import org.junit.Test;
import pl.practice.Reader.CSVReader;
import pl.practice.Reader.IFileReader;
import pl.practice.Reader.readerFactory;

public class ReaderFactoryTest {

    @Test
    public void shouldReturnCSVReader() {
        //given
        final String filePath = "path/to/file.csv";
        final readerFactory factory = new readerFactory();

        //when
        IFileReader product = factory.produce(filePath);

        //then
        Assert.assertTrue(product instanceof CSVReader);
    }
}