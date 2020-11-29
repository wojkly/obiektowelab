package agh.cs.lab7;

import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] parse(String [] array){
        ArrayList<MoveDirection> directionsList = new ArrayList<>();

        for(String arg: array) {
            switch (arg) {
                case "f", "forward" -> directionsList.add(MoveDirection.FORWARD);
                case "b", "backward" -> directionsList.add(MoveDirection.BACKWARD);
                case "l", "left" -> directionsList.add(MoveDirection.LEFT);
                case "r", "right" -> directionsList.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        MoveDirection [] directions = new MoveDirection[directionsList.size()];
        return directionsList.toArray(directions);
    }
}
