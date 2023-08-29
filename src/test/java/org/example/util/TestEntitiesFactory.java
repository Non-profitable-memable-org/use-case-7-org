package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.model.Student;

import java.util.List;
import java.util.Random;

@UtilityClass
public class TestEntitiesFactory {
    public static Student getStudent(int age, int grade) {
        var student = new Student();
        student.setName(randomName());
        student.setAge(age);
        student.setGrade(grade);

        return student;

    }

    private static String randomName() {
        var listOfNames = List.of("John", "Jack", "Antony", "Taras", "Rajet", "Xi", "Joe", "Donald", "Sofi", "Oksana");

        return listOfNames.get(new Random().nextInt(listOfNames.size()));
    }
}
