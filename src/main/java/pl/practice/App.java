package pl.practice;

import pl.practice.Converter.fileConverter;

public class App {
    public static void main(String[] args) {

        String sourcePath = "C:\\Users\\piotr\\IdeaProjects\\fileconverterwithmbasinski\\src\\main\\resources\\cards.json";
        String outputPath = "C:\\Users\\piotr\\IdeaProjects\\fileconverterwithmbasinski\\src\\main\\resources\\converted.csv";

        fileConverter fileConverter = new fileConverter();
        fileConverter.convert(sourcePath,outputPath);
    }
}
