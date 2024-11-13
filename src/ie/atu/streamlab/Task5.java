package ie.atu.streamlab;

import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,6,4,8,10);
        int min = numbers.stream()
        .reduce(Integer.MAX_VALUE, (a,b)-> Math.min(a, b));
        System.out.println("min value: " +  min);
    }
}

