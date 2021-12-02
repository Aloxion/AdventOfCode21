package day02;

public class Command {
    private String direction;
    private int value;


    public Command(String direction, int value){
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }

    public int getValue() {
        return value;
    }

}
