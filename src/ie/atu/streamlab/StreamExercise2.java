package ie.atu.streamlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class StreamExercise2 {
    public static void main(String[] args) {
        String filePath = "resources/input.txt";
        String letter = "x";

        try{
            long wordCount = Files.lines(Paths.get(filePath))
            .flatMap(line->Arrays.stream(line.split("\\s+")))
            // .filter(word->word.length()>5)
            .filter(word->word.contains(letter))
            .map(String::toUpperCase)
            .peek(System.out::println)
            .count();

            System.out.println("\nTotal words processed; " + wordCount);
        }catch(IOException e){
            System.err.println("error reading file: " + e.getMessage());
        }
    }
}
