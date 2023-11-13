package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {

    @Test
    public void simulationRunWithSingleAnimalTest() {
        // Given
        List<MoveDirection> moves = Arrays.asList(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> initialPositions = List.of(new Vector2d(2, 2));
        GrassField map = new GrassField(10);
        Simulation simulation = new Simulation(moves, initialPositions, map);

        // When
        simulation.run();

        // Then
        assertEquals(new Vector2d(3, 2), simulation.getAnimals().get(0).getPosition());
    }

    @Test
    public void simulationRunWithMultipleAnimalsTest() {
        // Given
        List<MoveDirection> moves = Arrays.asList(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> initialPositions = Arrays.asList(new Vector2d(2, 2), new Vector2d(1, 1));
        GrassField map = new GrassField(10);
        Simulation simulation = new Simulation(moves, initialPositions, map);

        // When
        simulation.run();

        // Then
        assertEquals(new Vector2d(3, 2), simulation.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(2, 1), simulation.getAnimals().get(1).getPosition());
    }

    @Test
    public void simulationRunWithWrapAroundTest() {
        // Given
        List<MoveDirection> moves = Arrays.asList(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> initialPositions = List.of(new Vector2d(4, 4));
        GrassField map = new GrassField(10);
        Simulation simulation = new Simulation(moves, initialPositions, map);

        // When
        simulation.run();

        // Then
        assertEquals(new Vector2d(0, 4), simulation.getAnimals().get(0).getPosition());
    }
}
