package org.example.Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStreams {
    public static void main(String[] args) throws IOException {

        Stream<String> bandas = Files.lines(Paths.get("C:\\Users\\Rodrigo\\Desktop\\java\\serpro\\src\\main\\java\\org\\example\\Streams\\bandas.txt"));


        bandas
                .sorted()
                .filter(banda -> banda.length()>15)
                .forEach(System.out::println);

        bandas.close();





    }

}
