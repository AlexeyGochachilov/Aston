package SecondHomeWork;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private int course;
    private List<Book> books;

    public Student(String firstName, String lastName, int age, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }
}
