package com.epam;

import com.epam.fileReader.FileReader;
import com.epam.fileReader.FileReaderBin;
import com.epam.selector.SelectPriceValue;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SelectPriceValue selectPriceValue = new SelectPriceValue();

        Double [] enteredValues = new Double[4];

        Scanner scanner = new Scanner(System.in);
        String inputValue;
        int i = 0;
        do {

            if (i == 0) {
                System.out.println("Enter distance or Q for exit: ");
            } else if (i == 1) {
                System.out.println("Please, enter price per km or Q for exit: ");
            } else if (i == 2) {
                System.out.println("Please, enter weight or Q for exit: ");
            } else {
                System.out.println("Please, enter price per kg or Q for exit: ");
            }

            inputValue = scanner.next();

            if (!isExitValue(inputValue)) {
                if (isCorrectDoubleValue(inputValue)) {
                    enteredValues[i] = Double.parseDouble(inputValue);
                    if (i == 0){
                        enteredValues[i] = enteredValues[i] * selectPriceValue.getValueDiscount(enteredValues[i]);
                    }
                    else if (i == 2){
                        enteredValues[i] = enteredValues[i] * selectPriceValue.getValueDiscount(enteredValues[i]);
                    }
                    i++;
                }
            }

            if (i == 4) {
                Double calcResult = 1.0;
                Double allCalcResult = 0.0;
                for (int j = 0; j < enteredValues.length-1; j++) {
                    if (j % 2 == 0 ) {
                        calcResult = enteredValues[j] * enteredValues[j + 1];
                    }
                    else {
                        allCalcResult = allCalcResult + calcResult;
                    }
                }
                allCalcResult = allCalcResult + calcResult;
                System.out.println("Price: $" + allCalcResult);
                i = 0;
            }

        } while (!isExitValue(inputValue));

        System.out.println("Finish!");
    }

    private static boolean isExitValue(String value) {
        return value.equalsIgnoreCase("Q");
    }

    private static boolean isCorrectDoubleValue(String value) {
        boolean checkResult;
        try {
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue >= 0;
        } catch (NumberFormatException ex) {
            checkResult = false;
        }
        return checkResult;
    }

}