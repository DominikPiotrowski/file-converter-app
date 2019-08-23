package Writer;

import org.junit.Assert;
import org.junit.Test;
import pl.practice.Writer.CSVWriter;
import pl.practice.Writer.IFileWriter;
import pl.practice.Writer.writerFactory;

public class WriterFactoryTest {

    @Test
    public void shouldReturnCSVWriter() {
        //given
        final String filePath = "path/to/file.csv";
        final writerFactory factory = new writerFactory();

        //when
        IFileWriter product = factory.produce(filePath);

        //then
        Assert.assertTrue(product instanceof CSVWriter);
    }
}