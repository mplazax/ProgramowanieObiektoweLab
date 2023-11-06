package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTest {

    @Test
    public void testSimulation() {
        List<MoveDirection> directions = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT));
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        Simulation simulation = new Simulation(directions, positions);

        // Przechwytujemy wypisywanie na konsolę do sprawdzenia wyników
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        simulation.run();

        // Sprawdzamy, czy wynik symulacji jest zgodny z oczekiwaniami
        String[] expectedOutput = {
                "Zwierzę 0: pozycja: (2,3), orientacja: Północ",
                "Zwierzę 1: pozycja: (3,3), orientacja: Północ",
                "Zwierzę 0: pozycja: (2,3), orientacja: Wschód"
        };

        String[] outputLines = outContent.toString().trim().split(System.lineSeparator());

        assertEquals(expectedOutput.length, outputLines.length);

        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], outputLines[i]);
        }

        // Sprawdzamy, czy zwierzęta mają właściwą orientację
        assertEquals(MapDirection.EAST, simulation.getAnimals().get(0).getOrientation());
        assertEquals(MapDirection.NORTH, simulation.getAnimals().get(1).getOrientation());

        // Sprawdzamy, czy zwierzęta są na właściwych pozycjach
        assertEquals(new Vector2d(2, 3), simulation.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(3, 3), simulation.getAnimals().get(1).getPosition());

        directions = OptionsParser.parse(new String[]{"b b r f l f r b f r b l l r f"});
        positions = List.of(new Vector2d(0, 0), new Vector2d(4, 4), new Vector2d(2, 2), new Vector2d(3, 3), new Vector2d(1, 1), new Vector2d(0, 4));

        simulation = new Simulation(directions, positions);
        // Sprawdzamy, czy zwierzęta nie wychodzą poza mapę
        for (Animal animal : simulation.getAnimals()) {
            Vector2d position = animal.getPosition();
            boolean withinBounds = position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(4, 4));
            assertTrue(withinBounds);
        }
        // @TODO: dodać testy sprawdzające zachowanie wiekszej ilosci zwierzat
        // @TODO: dodac testy dla wejsciowych lancuchow znakow
    }
}

