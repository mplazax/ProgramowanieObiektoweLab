package agh.ics.oop.model;

import agh.ics.oop.model.enums.MapDirection;
import agh.ics.oop.model.exceptions.PositionAlreadyOccupiedException;
import agh.ics.oop.model.interfaces.WorldElement;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.model.enums.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    public void canMoveTo() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(4, 3));
        map.place(animal1);
        map.place(animal2);
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(4, 3)));
        assertTrue(map.canMoveTo(new Vector2d(5, 5)));
        assertTrue(map.canMoveTo(new Vector2d(-1, 5)));
    }

    @Test
    public void placeTest() throws PositionAlreadyOccupiedException{
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(4, 4));
        Animal animal3 = new Animal(new Vector2d(-1, -7));
        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
        assertTrue(map.place(animal3));
    }

    @Test
    public void moveTest() throws PositionAlreadyOccupiedException{
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(0, 0));
        Animal animal3 = new Animal(new Vector2d(2, 2));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.move(animal1,FORWARD);
        map.move(animal2,BACKWARD);
        map.move(animal3,LEFT);
        Vector2d expectedPosition1 =new Vector2d(4,5);
        MapDirection expectedDirection1 = MapDirection.NORTH;
        Vector2d expectedPosition2 =new Vector2d(0,-1);
        MapDirection expectedDirection2 = MapDirection.NORTH;
        Vector2d expectedPosition3 =new Vector2d(2,2);
        MapDirection expectedDirection3 = MapDirection.WEST;

        assertEquals(expectedDirection1, animal1.getDirection());
        assertEquals(expectedDirection2, animal2.getDirection());
        assertEquals(expectedDirection3, animal3.getDirection());
        assertEquals(expectedPosition1, animal1.getPosition());
        assertEquals(expectedPosition2, animal2.getPosition());
        assertEquals(expectedPosition3, animal3.getPosition());

    }

    @Test
    public void isOccupied()throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        map.place(animal1);
        assertTrue(map.isOccupied(new Vector2d(4,4)));
        assertFalse(map.isOccupied(new Vector2d(-1,-1)));
    }

    @Test
    public void objectAt()throws PositionAlreadyOccupiedException{
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        map.place(animal1);
        WorldElement result = map.objectAt(new Vector2d(4,4));
        assertEquals(animal1, result);
        WorldElement result2 = map.objectAt(new Vector2d(-1,-1));
        assertNull(result2) ;
    }

}