package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dive {

    public static void main(String[] args) {
        List<Command> commandValue = new ArrayList<Command>();
        readFile(commandValue);
        System.out.println(navHandler(commandValue));
    }

    public static List<Command> readFile(List<Command> data){
        try {
            Scanner sc = new Scanner(new File("Day02/src/day02/navdata.txt"));
            while(sc.hasNext()){
            String   line = sc.nextLine();
            String[] pair = line.split(" ");
            String commands = pair[0].trim();
            try {
                int value = Integer.parseInt(pair[1]);
                if(!commands.equals("")){
                    data.add(new Command(commands, value));
                }
            } catch (NumberFormatException e){
                System.out.println("Unable to parse");
            }
        }
            sc.close();
    } catch (FileNotFoundException e) {
            System.out.println("File not found");
    }
        return data;
    }

    public static int navHandler(List<Command> data){
        int horizontalPos = 0;
        int depth = 0;
        int i = 0;
        while (i < data.size()){
            if (data.get(i).getDirection().equals("forward")) {
                horizontalPos += data.get(i).getValue();
                i++;
            } else if (data.get(i).getDirection().equals("up")) {
                depth -= data.get(i).getValue();
                i++;
            } else if (data.get(i).getDirection().equals("down")) {
                depth += data.get(i).getValue();
                i++;
            }
        }
        return horizontalPos*depth;
    }
}
