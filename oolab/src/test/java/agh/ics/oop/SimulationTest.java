package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.enums.MapDirection;
import agh.ics.oop.model.enums.MoveDirection;
import agh.ics.oop.model.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.interfaces.WorldMap;
import org.junit.jupiter.api.Test;
import static agh.ics.oop.model.enums.MoveDirection.*;
import static agh.ics.oop.model.enums.MapDirection.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    public void runTest() throws PositionAlreadyOccupiedException {
        WorldMap map = new RectangularMap(5,5);
        List<MoveDirection> directions = Arrays.asList(
                FORWARD,
                RIGHT,
                BACKWARD,
                FORWARD,
                FORWARD,
                LEFT,
                FORWARD
        );

        List<Vector2d> startingPositions = Arrays.asList(
                new Vector2d(-1, -1),
                new Vector2d(2, 2),
                new Vector2d(2, 2),
                new Vector2d(3, 3),
                new Vector2d(4, 4)
        );

        Simulation simulation = new Simulation(directions, startingPositions,map);
        simulation.run();

        List<Vector2d> expectedPositions = Arrays.asList(
                new Vector2d(2, 4),
                new Vector2d(3, 3),
                new Vector2d(4, 3)
        );

        List<MapDirection> expectedDirections = Arrays.asList(
                NORTH,
                EAST,
                WEST
        );

        List<Animal> animals = simulation.getAnimals();
        for (int i = 0; i < animals.size(); i++) {
            assertEquals(expectedPositions.get(i), animals.get(i).getPosition());
            assertEquals(expectedDirections.get(i),animals.get(i).getDirection());
        }
    }

}