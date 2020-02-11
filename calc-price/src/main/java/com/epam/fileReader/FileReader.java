package com.epam.fileReader;
import java.io.IOException;
import java.util.TreeMap;

public interface FileReader {
    TreeMap<Integer,Double> getAllDiscount(String fileName) throws IOException, ClassNotFoundException;
}
