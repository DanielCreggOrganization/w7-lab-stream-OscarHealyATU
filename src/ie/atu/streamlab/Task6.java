package ie.atu.streamlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task6 {
    public static void main(String[] args) {
          String inputPath = "resources/input.txt";

          try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
          
            long count = lines.filter(line->line.contains("Java")).count();
            System.out.println("Lines containing Java: "+  count);            

          } catch (IOException e) {
           System.err.println("Error reading file:"  + e.getMessage());
          }
    }
}
