package com.example.test.externalSorted;

import com.example.test.fileIo.FileIO;
import com.example.test.sorting.SortingAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalSorter {
    private final SortingAlgorithm sortingAlgorithm;
    private final int chunkSize;
    private final FileIO fileIO;

    public ExternalSorter(SortingAlgorithm sortingAlgorithm, int chunkSize, FileIO fileIO) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.chunkSize = chunkSize;
        this.fileIO = fileIO;
    }

    public void sort(String inputFilePath, String outputFilePath) throws IOException {
        List<String> chunk = new ArrayList<>();
        List<String> chunkFileNames = new ArrayList<>();

        List<String> inputLines = fileIO.readLines(inputFilePath);

        for (String line : inputLines) {
            chunk.add(line);

            if (chunk.size() >= chunkSize) {
                sortAndSaveChunk(chunk, chunkFileNames);
            }
        }

        if (!chunk.isEmpty()) {
            sortAndSaveChunk(chunk, chunkFileNames);
        }

        mergeSortedChunks(chunkFileNames, outputFilePath);
        deleteTemporaryFiles(chunkFileNames);
    }

    public void sortAndSaveChunk(List<String> chunk, List<String> chunkFileNames) throws IOException {
        chunk.sort(null);
        String chunkFileName = "chunk" + chunkFileNames.size() + ".txt";
        chunkFileNames.add(chunkFileName);

        fileIO.writeLines(chunk, chunkFileName);
        chunk.clear();
    }

    public void mergeSortedChunks(List<String> chunkFileNames, String outputFilePath) throws IOException {
        PriorityQueue<BufferedReader> readers = new PriorityQueue<>(chunkFileNames.size(),
                (br1, br2) -> {
                    try {
                        String line1 = br1.readLine();
                        String line2 = br2.readLine();
                        return line1.compareTo(line2);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }
        );

        List<String> outputLines = new ArrayList();

        for (String chunkFileName : chunkFileNames) {
            BufferedReader reader = new BufferedReader(new FileReader(chunkFileName));
            readers.add(reader);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            while (!readers.isEmpty()) {
                BufferedReader reader = readers.poll();
                String line = reader.readLine();
                if (line != null) {
                    outputLines.add(line);
                    readers.add(reader);
                } else {
                    reader.close(); // Закрываем файловый поток
                }
            }

            fileIO.writeLines(outputLines, outputFilePath);
        }
    }


    public void deleteTemporaryFiles(List<String> fileNames) {
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public SortingAlgorithm getSortingAlgorithm() {
        return sortingAlgorithm;
    }
}
