package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.enums.MoveDirection;
import agh.ics.oop.model.exceptions.PositionAlreadyOccupiedException;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void run(String[] args) {
        List<MoveDirection> move = OptionsParser.parse(args);

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
        Application.launch(SimulationApp.class, args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        int numberOfSimulations = 1000;
        List<Simulation> simulations = new ArrayList<>(numberOfSimulations);
        List<MoveDirection> directions = OptionsParser.parse(args);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        for (int i = 0; i < numberOfSimulations; i++) {
            GrassField map = new GrassField(10);
            map.addObserver(consoleMapDisplay);
            Simulation simulation = new Simulation(directions, positions, map);
            simulations.add(simulation);
        }

        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        Thread engineThread = new Thread(simulationEngine);
        engineThread.start();
        System.out.println("System zakończył działanie");

    }

}

