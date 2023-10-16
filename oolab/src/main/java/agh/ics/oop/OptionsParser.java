package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int length = args.length;
        MoveDirection[] directions = new MoveDirection[length];

        for (int i = 0; i < length; i++) {
            switch (args[i]) {
                case "f":
                    directions[i] = MoveDirection.FORWARD;
                    break;
                case "b":
                    directions[i] = MoveDirection.BACKWARD;
                    break;
                case "r":
                    directions[i] = MoveDirection.RIGHT;
                    break;
                case "l":
                    directions[i] = MoveDirection.LEFT;
                    break;
                default:
                    // ignorowanie niepoprawnych argumentów
                    break;
            }
        }

        return directions;
    }
}
