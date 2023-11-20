package agh.ics.oop;

import agh.ics.oop.model.*;


import java.util.List;

public class World {
    public static void run(String[] args) {
        List<MoveDirection> move = OptionParser.change(args);

        for(MoveDirection direction : move) {

            String message = switch (direction) {
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tylu";
                case LEFT -> "zwierzak idzie w lewo";
                case RIGHT -> "zwierzak idzie w prawo";
            };
            System.out.println(message);
        }

    }

    public static void main(String[] args) throws PositionAlreadyOccupiedException {

        List<MoveDirection> directions = OptionParser.change(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        GrassField map = new GrassField(10);
        map.addObserver(new ConsoleMapDisplay());
        Simulation simulation = new Simulation(directions, positions, map);
        simulation.run();

    }
}
