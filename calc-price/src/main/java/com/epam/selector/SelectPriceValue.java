package com.epam.selector;
import com.epam.fileReader.FileReader;
import com.epam.fileReader.FileReaderBin;
import java.io.IOException;
import java.util.Map;

public class SelectPriceValue {

    String fileName = "discount.bin";

    FileReader fileReaderBin = new FileReaderBin();



    public Double getValueDiscount(Double inputValues) throws IOException, ClassNotFoundException {

        Double discount = 0.0;
        for (Map.Entry<Integer, Double> entry : fileReaderBin.getAllDiscount(fileName).entrySet()) {

            if (entry.getKey() <= inputValues) {
                discount = entry.getValue();
            }
            else{
                return discount;
            }
        }
        return discount;
    }

}
