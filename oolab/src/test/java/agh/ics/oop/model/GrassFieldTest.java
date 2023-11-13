package agh.ics.oop.model;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void grassFieldInitializationTest() {
        GrassField grassField = new GrassField(8);
        assertEquals(8, grassField.getGrassCount());
    }

    @Test
    public void objectAtAnimalTest() {
        GrassField grassField = new GrassField(1);
        Animal animal = new Animal(new Vector2d(2, 2));
        grassField.place(animal);

        assertEquals(animal, grassField.objectAt(new Vector2d(2, 2)));
    }

    @Test
    public void objectAtEmptyTest() {
        GrassField grassField = new GrassField(1);
        assertNull(grassField.objectAt(new Vector2d(10, 10)));
    }

    @Test
    public void moveAnimalTest() {
        GrassField grassField = new GrassField(1);
        Animal animal = new Animal(new Vector2d(2, 2));
        grassField.place(animal);

        animal.move(MoveDirection.FORWARD, grassField);
        Vector2d newPosition = new Vector2d(2, 3);

        assertEquals(animal, grassField.objectAt(newPosition));
        assertNull(grassField.objectAt(new Vector2d(2, 2)));
    }

    @Test
    public void multipleAnimalsTest() {
        GrassField grassField = new GrassField(1);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(3, 3));
        Animal animal3 = new Animal(new Vector2d(1, 1));

        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);

        animal1.move(MoveDirection.FORWARD, grassField);
        animal2.move(MoveDirection.RIGHT, grassField);
        animal3.move(MoveDirection.BACKWARD, grassField);

        assertEquals(animal1, grassField.objectAt(new Vector2d(2, 3)));
        assertEquals(animal2, grassField.objectAt(new Vector2d(3, 3)));
        assertEquals(animal3, grassField.objectAt(new Vector2d(1, 0)));
    }

    @Test
    public void grassFieldWithParserTest() {
        String[] args = {"f b l r f b l r"};
        List<MoveDirection> directions = OptionsParser.parse(args);

        GrassField grassField = new GrassField(1);
        Animal animal = new Animal(new Vector2d(2, 2));
        grassField.place(animal);

        for (MoveDirection direction : directions) {
            animal.move(direction, grassField);
        }

        assertEquals(animal, grassField.objectAt(new Vector2d(2, 2))); // Animal should stay at the initial position
    }

    @Test
    public void grassFieldVisualizationTest() {
        GrassField grassField = new GrassField(1);
        Animal animal = new Animal(new Vector2d(2, 2));
        grassField.place(animal);

        String expectedVisualization =
                      " y\\x  0 1 2 3 4 \n" +
                        "  4  ----------- \n" +
                        "  3 | | | | | | \n" +
                        "  2 | | |^| | | \n" +
                        "  1 | | | | | | \n" +
                        "  0 | | | | | | \n" +
                        " -1  ----------- \n";

        assertEquals(expectedVisualization, new MapVisualizer(grassField).draw(new Vector2d(0, -1), new Vector2d(4, 4)));
    }

    @Test
    public void worldElementInterfaceTest() {
        // Test the WorldElement interface methods for Animal
        WorldElement animalElement = new Animal(new Vector2d(1, 1));
        assertEquals(new Vector2d(1, 1), animalElement.getPosition());
        assertEquals("^", animalElement.toString());
        assertTrue(animalElement.isAt(new Vector2d(1, 1)));

        // Test the WorldElement interface methods for Grass
        WorldElement grassElement = new Grass(new Vector2d(0, 0));
        assertEquals(new Vector2d(0, 0), grassElement.getPosition());
        assertEquals("*", grassElement.toString()); // Assuming "*" is the representation of grass
        assertTrue(grassElement.isAt(new Vector2d(0, 0)));
    }
}
