package org.example.service;

import org.example.model.Student;
import org.example.util.TestEntitiesFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StudentConvertorTest {

    private StudentConverter service = new StudentConverter();

    //Positive Test Cases:
    //Case 1: High Achiever
    //·	Given a list with a student object of age 21 or above and grade above 90, the function should return a list with object with the additional field HonorRoll = true.
    @Test
    public void shouldGetHonorableStudents() {
        var student1 = TestEntitiesFactory.getStudent(getRandomIntInRange(21, 100), getRandomIntInRange(90, 100));
        var student2 = TestEntitiesFactory.getStudent(getRandomIntInRange(21, 100), getRandomIntInRange(90, 100));
        var student3 = TestEntitiesFactory.getStudent(getRandomIntInRange(21, 100), getRandomIntInRange(90, 100));

        var result = service.convertStudents(List.of(student1, student2, student3));

        Assert.assertTrue(result.stream().allMatch(Student::isHonorRoll));

    }
    //Case 2: Exceptional Young High Achiever
    //·	Given a list with a student object of age less than 21 and grade above 90, the function should return a list with object with the additional field Exceptional = true.
    @Test
    public void shouldGetExceptionalStudents() {
        var student1 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 20), getRandomIntInRange(90, 100));
        var student2 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 20), getRandomIntInRange(90, 100));
        var student3 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 20), getRandomIntInRange(90, 100));

        var result = service.convertStudents(List.of(student1, student2, student3));

        Assert.assertTrue(result.stream().allMatch(Student::isExceptional));

    }
    //Case 3: Passed Student
    //·	Given a list with a student object of grade between 71 and 90 (inclusive), the function should return a list with object with the additional field Passed = true.
    @Test
    public void shouldPassedStudents() {
        var student1 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 100), getRandomIntInRange(71, 91));
        var student2 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 100), getRandomIntInRange(71, 91));
        var student3 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 20), getRandomIntInRange(71, 91));

        var result = service.convertStudents(List.of(student1, student2, student3));

        Assert.assertTrue(result.stream().allMatch(Student::isPassed));

    }
    //Case 4: Failed Student
    //·	Given a list with a student object of grade 70 or less, the function should return a list with object with the additional field Passed = false.
    @Test
    public void shouldFailedStudents() {
        var student1 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 100), getRandomIntInRange(0, 71));
        var student2 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 100), getRandomIntInRange(0, 71));
        var student3 = TestEntitiesFactory.getStudent(getRandomIntInRange(5, 20), getRandomIntInRange(0, 71));

        var result = service.convertStudents(List.of(student1, student2, student3));

        Assert.assertTrue(result.stream().noneMatch(Student::isPassed));

    }
    //Negative Test Cases:
    //Case 1: Empty Array
    //·	Given an empty list, the function should return an empty list.
    @Test
    public void shouldReturnEmptyList() {
        var result = service.convertStudents(Collections.emptyList());
        Assert.assertTrue(result.isEmpty());

    }
    //Case 2: Input is null:
    //•	Given a null as an input the function should throw an error.
    @Test(expected = NullPointerException.class)
    public void shouldThrowAnError() {
        var result = service.convertStudents(null);
        Assert.fail("Should've thrown NPE");

    }

    private int getRandomIntInRange(int lowerBound, int higherBound) {
        Random random = new Random();
        return random.nextInt(higherBound - lowerBound) + lowerBound;
    }
}
