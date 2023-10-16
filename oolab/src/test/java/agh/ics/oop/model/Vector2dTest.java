package agh.ics.oop.model;

import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {

    @Test
    public void equalsTest() {
        assertEquals(new Vector2d(1, 2).equals(new Vector2d(1, 2)), true);
        assertEquals(new Vector2d(1, 2).equals(new Vector2d(1, 3)), false);
    }

    @Test
    public void toStringTest() {
        assertEquals(new Vector2d(1, 2).toString(), "(1,2)");
    }

    @Test
    public void precedesTest() {
        assertEquals(new Vector2d(1, 2).precedes(new Vector2d(1, 2)), true);
        assertEquals(new Vector2d(1, 2).precedes(new Vector2d(1, 3)), true);
        assertEquals(new Vector2d(1, 2).precedes(new Vector2d(1, 1)), false);
    }

    @Test
    public void followsTest() {
        assertEquals(new Vector2d(1, 2).follows(new Vector2d(1, 2)), true);
        assertEquals(new Vector2d(1, 2).follows(new Vector2d(1, 3)), false);
        assertEquals(new Vector2d(1, 2).follows(new Vector2d(1, 1)), true);
    }

    @Test
    public void upperRightTest() {
        assertEquals(new Vector2d(1, 2).upperRight(new Vector2d(1, 2)), new Vector2d(1, 2));
        assertEquals(new Vector2d(1, 2).upperRight(new Vector2d(1, 3)), new Vector2d(1, 3));
        assertEquals(new Vector2d(1, 2).upperRight(new Vector2d(1, 1)), new Vector2d(1, 2));
    }

    @Test
    public void lowerLeftTest() {
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(1, 2)), new Vector2d(1, 2));
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(1, 3)), new Vector2d(1, 2));
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(1, 1)), new Vector2d(1, 1));
    }

    @Test
    public void addTest() {
        assertEquals(new Vector2d(1, 2).add(new Vector2d(1, 2)), new Vector2d(2, 4));
        assertEquals(new Vector2d(1, 2).add(new Vector2d(1, 3)), new Vector2d(2, 5));
        assertEquals(new Vector2d(1, 2).add(new Vector2d(1, 1)), new Vector2d(2, 3));
    }

    @Test
    public void subtractTest() {
        assertEquals(new Vector2d(1, 2).subtract(new Vector2d(1, 2)), new Vector2d(0, 0));
        assertEquals(new Vector2d(1, 2).subtract(new Vector2d(1, 3)), new Vector2d(0, -1));
        assertEquals(new Vector2d(1, 2).subtract(new Vector2d(1, 1)), new Vector2d(0, 1));
    }

    @Test
    public void oppositeTest() {
        assertEquals(new Vector2d(1, 2).opposite(), new Vector2d(-1, -2));
    }
}
