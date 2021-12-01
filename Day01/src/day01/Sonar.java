package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sonar {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        readFile(data);
        numberIncreased(data);
        threeMeasurementWindows(data);
        numberIncreased(threeMeasurementWindows(data));
    }

    public static List<Integer> readFile(List<Integer> data){
        try {
            Scanner sc = new Scanner(new File("Day01/src/day01/data"));
            while (sc.hasNext()) {
                data.add(Integer.valueOf(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }

    public static int numberIncreased(List<Integer> data){
        int numInc = 0;
        int numBefore = 0;
        for (int i : data){
            if (i > numBefore && numBefore !=0){
                numInc++;
            }
            numBefore = i;
        }
        System.out.println(numInc);
        return numInc;
    }

    public static List<Integer> threeMeasurementWindows(List<Integer> data){
        List<Integer> listOfSums = new ArrayList<>();
        int sumOfMeasurement = 0;
        for (int i = 0; i < data.size(); i++){
            if(i+2 == data.size()){
                break;
            }
            sumOfMeasurement = data.get(i) + data.get(i+1) + data.get(i+2);
            listOfSums.add(sumOfMeasurement);
        }
        return listOfSums;
    }
}
