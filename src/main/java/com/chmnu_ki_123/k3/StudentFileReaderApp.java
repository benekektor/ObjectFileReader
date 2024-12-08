package com.chmnu_ki_123.k3;

import java.io.IOException;
import java.util.List;

public class StudentFileReaderApp {
    public static void main(String[] args) {

        String filePath = "students.txt";

        try {

            List<Student> students = StudentFileReader.readStudentsFromFile(filePath);

            System.out.println("List of students:");
            for (Student student : students) {
                System.out.printf("Name: %s, Average Grade: %.2f%n",
                        student.getName(), student.getAverageGrade());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid file format: " + e.getMessage());
        }
    }
}

