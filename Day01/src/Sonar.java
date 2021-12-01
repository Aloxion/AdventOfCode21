import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sonar {

    private static List<Integer> data = new ArrayList<>();

    public static void main(String[] args) {
        readFile();
        numberIncreased();

    }

    public static List<Integer> readFile(){
        try {
            Scanner sc = new Scanner(new File("data.txt"));
            while (sc.hasNext()) {
                data.add(Integer.valueOf(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
        }
        return data;
    }


    public static int numberIncreased(){
        int number = 0;
        int numBefore = 0;

        for (int i : data){
            if (i > numBefore && numBefore !=0){
                number++;
            }
            System.out.println(number);
        }

        return number;
    }


}
