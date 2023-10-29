package com.example.test;

import com.example.test.externalSorted.ExternalSorter;
import com.example.test.fileIo.FileIO;
import com.example.test.fileIo.SimpleFileIO;
import com.example.test.sorting.QuickSortAlgorithm;
import com.example.test.sorting.SortingAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/library.unsorted.txt";
        String outputFilePath = "src/main/resources/library.sorted.txt";
        int chunkSize = 10000;

        SortingAlgorithm sortingAlgorithm = new QuickSortAlgorithm();
        FileIO fileIO = new SimpleFileIO();
        ExternalSorter externalSorter = new ExternalSorter(sortingAlgorithm, chunkSize, fileIO);

        try {
            externalSorter.sort(inputFilePath, outputFilePath);
            System.out.println("Файл успешно отсортирован.... Наконец-то блиин");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(TestApplication.class, args);
    }

}
