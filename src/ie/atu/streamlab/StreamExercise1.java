package ie.atu.streamlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamExercise1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 3.5));
        students.add(new Student("Bob", 19, 3.5));
        students.add(new Student("Charlie", 21, 3.9));
        students.add(new Student("Audrey", 18, 3.8));
        students.add(new Student("Dylan", 22, 3.8));
        students.add(new Student("Diana", 20, 3.7));
    
    students.stream()
    // .filter(s->s.getAge()>20)
    .filter(s->s.getGPA()>3.7)
    .sorted(Comparator.comparing(Student::getGPA).reversed())
    .map(s->String.format("Name: %-10s GPA: %.2f", s.getName(),s.getGPA()))
    .forEach(System.out::println);
    
    }
}