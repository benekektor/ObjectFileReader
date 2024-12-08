package com.chmnu_ki_123.k3;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class StudentFileReader {

    public static List<Student> readStudentsFromFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            String[] parts = line.split(","); // Розділяємо по комах
            if (parts.length < 3) {
                throw new IllegalArgumentException("Invalid line format: " + line);
            }

            // Формуємо ім'я
            String name = parts[0].trim() + " " + parts[1].trim(); // З'єднуємо перше та друге слово

            // Обробляємо оцінки
            double sum = 0;
            for (int i = 2; i < parts.length; i++) {
                try {
                    sum += Double.parseDouble(parts[i].trim()); // Очищаємо пробіли перед парсингом
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid grade format in line: " + line, e);
                }
            }

            double average = sum / (parts.length - 2); // Обчислюємо середнє значення
            students.add(new Student(name, average));
        }
        return students;
    }
}
