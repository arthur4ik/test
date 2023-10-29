package com.example.test.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Реализация алгоритма быстрой сортировки
public class QuickSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sortAndSaveChunk(List<String> chunk, String chunkFileName) throws IOException {
        chunk.sort(null);
        try (BufferedWriter chunkWriter = new BufferedWriter(new FileWriter(chunkFileName))) {
            for (String item : chunk) {
                chunkWriter.write(item);
                chunkWriter.newLine();
            }
        }
    }
}
