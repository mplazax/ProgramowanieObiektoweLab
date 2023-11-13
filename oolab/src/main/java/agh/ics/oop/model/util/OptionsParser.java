package agh.ics.oop.model.util;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> result = new ArrayList<>();

        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> result.add(MoveDirection.FORWARD);
                case "b", "backward" -> result.add(MoveDirection.BACKWARD);
                case "l", "left" -> result.add(MoveDirection.LEFT);
                case "r", "right" -> result.add(MoveDirection.RIGHT);
            }
        }

        return result;
    }
}
