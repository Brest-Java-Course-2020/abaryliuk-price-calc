package com.epam;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Double [] enteredValues = new Double[4];

        Scanner scanner = new Scanner(System.in);
        String inputValue;
        int i = 0;
        do {

            if (i == 0) {
                System.out.println("Please, enter distance or Q for exit: ");
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
                        enteredValues[i] = enteredValues[i] * getDiscountPerKm(enteredValues[i]);
                    }
                    else if (i == 2){
                        enteredValues[i] = enteredValues[i] * getDiscountPerWeight(enteredValues[i]);
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

    public static HashMap<String,Double> getAllDiscountPerKm() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("discountPerKm.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap <String,Double> saleOfKm = (HashMap <String, Double>) objectInputStream.readObject();
        objectInputStream.close();
        return saleOfKm;
    }

    public static HashMap<String,Double> getAllDiscountPerWeight() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("discountPerWeight.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap <String,Double> discountPerWeight = (HashMap <String, Double>) objectInputStream.readObject();
        objectInputStream.close();
        return discountPerWeight;
    }

    public static Double getValueDiscount(String nameDiscount,Map<String,Double> map){
        Double discount = 0.0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getKey().equals(nameDiscount)) {
                discount = entry.getValue();
            }
        }
        return discount;
    }

    public static Double getDiscountPerKm (Double km) throws IOException, ClassNotFoundException {
        Double discountPerKm = 0.0;
        if (km > 0 && km <= 100){
            discountPerKm = getValueDiscount("SaleForKmBeforeHundred", getAllDiscountPerKm());
        }
        else if (km > 100 && km <= 1000){
            discountPerKm = getValueDiscount("SaleForKmAfterHundredBeforeThousand",getAllDiscountPerKm());
        }
        else if (km > 1000){
            discountPerKm = getValueDiscount("SaleForKmAfterThousand", getAllDiscountPerKm());
        }
        return discountPerKm;
    }

    public static Double getDiscountPerWeight (Double weight) throws IOException, ClassNotFoundException {
        Double discountPerWeight = 0.0;
        if (weight > 0 && weight <= 100){
            discountPerWeight = getValueDiscount("SaleForWeightBeforeHundred", getAllDiscountPerWeight());
        }
        else if (weight > 100 && weight <= 1000){
            discountPerWeight = getValueDiscount("SaleForWeightAfterHundredBeforeThousand",getAllDiscountPerWeight());
        }
        else if (weight > 1000){
            discountPerWeight = getValueDiscount("SaleForWeightAfterThousand", getAllDiscountPerWeight());
        }
        return discountPerWeight;
    }
}