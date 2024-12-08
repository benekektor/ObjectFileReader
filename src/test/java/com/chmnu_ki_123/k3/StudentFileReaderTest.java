package com.chmnu_ki_123.k3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class StudentFileReaderTest {

    @Test
    public void testReadStudentsFromFile_InvalidLine() {
        String invalidLinePath = "invalid_students.txt";

        try {
            Files.write(Paths.get(invalidLinePath), List.of("John Doe 90,85"));
            StudentFileReader.readStudentsFromFile(invalidLinePath);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Invalid line format"));
        } catch (IOException e) {
            fail("Unexpected IOException: " + e.getMessage());
        } finally {
            try {
                Files.delete(Paths.get(invalidLinePath));
            } catch (IOException ignored) {
            }
        }
    }
}
