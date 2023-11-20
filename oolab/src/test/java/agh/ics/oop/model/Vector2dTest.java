package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    public void toSringTest(){
        Vector2d vector = new Vector2d(2,3);
        String expected = "(2,3)";
        String result = vector.toString();
        assertEquals(expected, result);
    }


    @Test
    public void precedesTest_True(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(4,5);
        boolean result = vector1.precedes(vector2);
        assertTrue(result);
    }

    @Test
    public void precedesTest_False(){
        Vector2d vector1 = new Vector2d(4,5);
        Vector2d vector2 = new Vector2d(2,3);
        boolean result = vector1.precedes(vector2);
        assertFalse(result);
    }

    @Test
    public void followsTest_True(){
        Vector2d vector1 = new Vector2d(4,5);
        Vector2d vector2 = new Vector2d(2,3);
        boolean result = vector1.follows(vector2);
        assertTrue(result);
    }

    @Test
    public void followsTest_False(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(4,5);
        boolean result = vector1.follows(vector2);
        assertFalse(result);
    }

    @Test
    public void addTest(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(4,5);
        Vector2d expected = new Vector2d(6,8);
        Vector2d result = vector1.add(vector2);
        assertEquals(expected, result);
    }

    @Test
    public void subtractTest(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(4,5);
        Vector2d expected = new Vector2d(-2,-2);
        Vector2d result = vector1.subtract(vector2);
        assertEquals(expected, result);
    }

    @Test
    public void upperRightTest(){
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,1);
        Vector2d expected = new Vector2d(2,2);
        Vector2d result = vector1.upperRight(vector2);
        assertEquals(expected, result);
    }

    @Test
    public void lowerLeftTest(){
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,1);
        Vector2d expected = new Vector2d(1,1);
        Vector2d result = vector1.lowerLeft(vector2);
        assertEquals(expected, result);
    }

    @Test
    public void oppositeTest(){
        Vector2d vector = new Vector2d(1,2);
        Vector2d opposite = vector.opposite();
        Vector2d expected = new Vector2d(-1,-2);
        assertEquals(opposite, expected);

    }

    @Test
    public void equalsTest_True(){
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(1,2);

        boolean expected = vector1.equals(vector2);
        assertTrue(expected);
    }

    @Test
    public void equalsTest_False(){
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(-2,1);

        boolean expected = vector1.equals(vector2);
        assertFalse(expected);
    }
}