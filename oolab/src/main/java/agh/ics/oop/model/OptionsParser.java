package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import static agh.ics.oop.model.MoveDirection.*;


public class OptionsParser {

    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> move = new ArrayList<>();

        for(String side: args) {
            switch (side) {
                case "f", "forward" -> move.add(FORWARD);
                case "b", "backward" -> move.add(BACKWARD);
                case "l", "left" -> move.add(LEFT);
                case "r", "right" -> move.add(RIGHT);
                default -> throw new IllegalArgumentException(side + " is not legal move specification");
            }
        }

        return move;
    }

}
