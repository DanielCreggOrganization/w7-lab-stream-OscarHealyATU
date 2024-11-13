package ie.atu.streamlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello Java Streams!");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<String> names= Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> words = Arrays.asList("Hello", " ", "world", "!");
        List<String> filteredNames = names.stream()
        .filter(name->name.length()>3)
        .sorted()
        .collect(Collectors.toList());

       filteredNames.forEach(name->System.out.println(name));

        // method reference
        //lambda
        names.stream()
        .map(name->name.toUpperCase())
        .forEach(name->System.out.println(name));
        //method reference 
        names.stream()
        .map(String::toUpperCase)
        .forEach(System.out::println);

        numbers.stream()
        .map(NumberUtils::doubleNumber)
        .forEach(System.out::println);
    
        int sum = numbers.stream()
        .reduce(0,(a,b)->a+b);
        System.out.println("Sum: " + sum);
        
        int max = numbers.stream()
        .reduce(Integer.MIN_VALUE, (a,b)->Math.max(a,b));
        System.out.println("max value; " + max);

        String combined = words.stream()
            .reduce("",(a,b)->a+b);
        System.out.println("Combined string: " + combined);

        int min = numbers.stream()
        .reduce(Integer.MAX_VALUE, (a,b)->Math.min(a,b));
        System.out.println("Min value: " + min);

        String inputPath = "resources/input.txt";
        try(Stream<String> lines = Files.lines(Paths.get(inputPath))){
        lines.filter(line->line.contains("java"))
        .map(String::trim)
        .forEach(line->System.out.println(line));
        
        } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
        }



       }     
    }

