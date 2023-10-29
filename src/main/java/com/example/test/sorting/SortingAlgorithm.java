package com.example.test.sorting;

import java.io.IOException;
import java.util.List;

public interface SortingAlgorithm {
    void sortAndSaveChunk(List<String> chunk, String chunkFileName) throws IOException;
}
