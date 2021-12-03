package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BinaryDiagnostic {
    static int count;

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();

        readFile(data);
        convertData(data);
        System.out.println(convertData((data)));
    }

    public static ArrayList<String> readFile(ArrayList<String> data) {
        try {
            Scanner sc = new Scanner(new File("Day03/src/day03/binarydata.txt"));
            while (sc.hasNextLine()) {
                data.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }

    public static int convertData(ArrayList<String> data){
    ArrayList<Integer> finalBinary = new ArrayList<>();
    int sumOfOnes = 0;
    int sumOfZeros = 0;
    int gammaRate = 0;
    int epsilonRate = 0;
    int row = 0;
    int result = 0;
    for (int i = 0; i < String.valueOf(data.get(0)).length(); i++) {
        for (int k = 0; k < data.size(); k++){
            for (int j = 0; j < row; j++){
                 if (Integer.valueOf(data.get(i).substring(0, j)) == 1){
                sumOfOnes += 1;
                } else if(Integer.valueOf(data.get(i).substring(0, j)) == 0){
                sumOfZeros+= 1;
                }
            }
            row++;
            if (sumOfOnes > sumOfZeros){
                finalBinary.add(1);
            } else {
                finalBinary.add(0);
            }
        }
    }
    for (int h = 0; h < finalBinary.size(); h++){
        result =+ finalBinary.get(h);
    }
    return result;
    }

}
