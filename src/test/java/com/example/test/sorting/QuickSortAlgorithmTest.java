package com.example.test.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortAlgorithmTest {

    private QuickSortAlgorithm quickSortAlgorithm;

    @BeforeEach
    void setUp() {
        quickSortAlgorithm = new QuickSortAlgorithm();
    }

    @Test
    void sortAndSaveChunk() throws IOException {
        List<String> chunk = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "date"));
        Path tempDir = createTempDirectory();

        String chunkFileName = tempDir.resolve("testChunk.txt").toString();

        quickSortAlgorithm.sortAndSaveChunk(chunk, chunkFileName);

        List<String> sortedChunk = readLinesFromFile(chunkFileName);

        assertEquals(Arrays.asList("apple", "banana", "cherry", "date"), sortedChunk);
    }

    private Path createTempDirectory() throws IOException {
        return Files.createTempDirectory("tempDir");
    }

    private List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}