package com.example.test.fileIo;


import java.io.IOException;
import java.util.List;


public interface FileIO {
    List<String> readLines(String filePath) throws IOException;

    void writeLines(List<String> lines, String filePath) throws IOException;
}
