package agh.ics.oop.model;

import static agh.ics.oop.model.enums.MapDirection.*;

import agh.ics.oop.model.enums.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    public void nextTest_NORTH(){
        MapDirection result = NORTH.next();
        assertEquals(EAST, result);
    }
    @Test
    public void nextTest_EAST(){
        MapDirection result = EAST.next();
        assertEquals(SOUTH, result);
    }
    @Test
    public void nextTest_WEST(){
        MapDirection result = WEST.next();
        assertEquals(NORTH, result);
    }
    @Test
    public void nextTest_SOUTH(){
        MapDirection result = SOUTH.next();
        assertEquals(WEST, result);
    }

    @Test
    public void previousTest_SOUTH(){
        MapDirection direction = SOUTH;
        MapDirection result = direction.previous();
        assertEquals(EAST, result);
    }

    @Test
    public void previousTest_EAST(){
        MapDirection direction = EAST;
        MapDirection result = direction.previous();
        assertEquals(NORTH, result);
    }

    @Test
    public void previousTest_NORTH(){
        MapDirection direction = NORTH;
        MapDirection result = direction.previous();
        assertEquals(WEST, result);
    }

    @Test
    public void previousTest_WEST(){
        MapDirection direction = WEST;
        MapDirection result = direction.previous();
        assertEquals(SOUTH, result);
    }



}