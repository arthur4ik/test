package com.example.test.fileIo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleFileIOTest {

    @Test
    void readLines(@TempDir Path tempDir) throws IOException {
        String filePath = tempDir.resolve("testFile.txt").toString();
        List<String> expectedLines = Arrays.asList("line1", "line2", "line3");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : expectedLines) {
                writer.write(line);
                writer.newLine();
            }
        }

        SimpleFileIO fileIO = new SimpleFileIO();
        List<String> actualLines = fileIO.readLines(filePath);

        assertEquals(expectedLines, actualLines);
    }

    @Test
    void writeLines(@TempDir Path tempDir) throws IOException {
        String filePath = tempDir.resolve("testFile.txt").toString();
        List<String> linesToWrite = Arrays.asList("line1", "line2", "line3");

        SimpleFileIO fileIO = new SimpleFileIO();
        fileIO.writeLines(linesToWrite, filePath);

        List<String> actualLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualLines.add(line);
            }
        }

        assertEquals(linesToWrite, actualLines);
    }
}