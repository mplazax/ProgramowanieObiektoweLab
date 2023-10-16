package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();
        System.out.println("system zakończył działanie");
    }

    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            if (direction != null) {
                switch (direction) {
                    case FORWARD:
                        System.out.println("Zwierzak idzie do przodu");
                        break;
                    case BACKWARD:
                        System.out.println("Zwierzak idzie do tyłu");
                        break;
                    case RIGHT:
                        System.out.println("Zwierzak skręca w prawo");
                        break;
                    case LEFT:
                        System.out.println("Zwierzak skręca w lewo");
                        break;
                }
            }
        }
    }
}
