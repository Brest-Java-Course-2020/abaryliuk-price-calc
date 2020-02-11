package com.epam.fileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FileReaderBin implements FileReader {

    public TreeMap <Integer, Double> getAllDiscount(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap <Integer,Double> discountWithFile = (HashMap <Integer, Double>) objectInputStream.readObject();
        objectInputStream.close();
        TreeMap<Integer, Double> discaunt = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry: discountWithFile.entrySet()){
            discaunt.put(entry.getKey(), entry.getValue());
        }
        return discaunt;
    }
}
