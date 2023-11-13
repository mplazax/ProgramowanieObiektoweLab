package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.OptionsParser;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(directions, positions, new RectangularMap(10, 5));
        simulation.run();
        System.out.println("system zakończył działanie");
    }

}
