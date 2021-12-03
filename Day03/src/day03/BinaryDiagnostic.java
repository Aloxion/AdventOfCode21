package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BinaryDiagnostic {

    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        readFile(data);
        findCommon(data);
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

    public static void findCommon(ArrayList<String> data) {
        int prev = 0;
        int current = 0;
        String gammaRate = "";
        String epsilonRate = "";
        for (int k = 0; k < String.valueOf(data.get(0)).length(); k++) {
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> zero = new ArrayList<>();
            prev = current;
            current++;
            for (int j = 0; j < data.size(); j++){
                if (data.get(j).substring(prev, current).equals("1")) {
                    one.add(data.get(j).substring(prev, current));
                }
                if (data.get(j).substring(prev, current).equals("0")) {
                    zero.add(data.get(j).substring(prev, current));
                }
            }
            if (one.size() > zero.size()) {
                gammaRate = gammaRate + "1";
                epsilonRate = epsilonRate + "0";
            } else {
                gammaRate = gammaRate + "0";
                epsilonRate = epsilonRate + "1";
            }
        }
        powerConsumption(gammaRate, epsilonRate);
    }

    public static int powerConsumption(String gammaRate, String epsilonRate) {
        int gammaRateNum = 0;
        int epsilonRateNum = 0;
        for (int k = 0; k < gammaRate.length(); k++) {
            char ch1 = gammaRate.charAt(gammaRate.length()-1-k);
            if (ch1 == '1') {
                gammaRateNum += Math.pow(2, k);
            }
        }
        for (int k = 0; k < epsilonRate.length(); k++) {
            char ch2 = epsilonRate.charAt(epsilonRate.length()-1-k);
            if (ch2 == '1') {
                epsilonRateNum += Math.pow(2, k);
            }
        }
        System.out.println(gammaRateNum*epsilonRateNum);
        return gammaRateNum * epsilonRateNum;
    }
}