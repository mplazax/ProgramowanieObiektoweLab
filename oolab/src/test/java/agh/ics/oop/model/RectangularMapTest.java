package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import org.junit.jupiter.api.Test;
import static agh.ics.oop.model.MoveDirection.*;
import static agh.ics.oop.model.MoveDirection.FORWARD;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest  {

    @Test
    public void canMoveTo()throws PositionAlreadyOccupiedException{
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(4, 3));
        map.place(animal1);
        map.place(animal2);
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(4,3)));
    }

    @Test
    public void placeTest() throws PositionAlreadyOccupiedException{
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d position2 = new Vector2d(6, 7);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(4, 4));
        assertTrue(map.place(animal1));
        assertThrows(PositionAlreadyOccupiedException.class ,() -> map.place(animal2));
    }

    @Test
    public void moveTest() throws PositionAlreadyOccupiedException {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(4, 3));
        Animal animal3 = new Animal(new Vector2d(2, 2));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.move(animal1,FORWARD);
        map.move(animal2,BACKWARD);
        map.move(animal3,LEFT);
        Vector2d expectedPosition1 =new Vector2d(4,4);
        MapDirection expectedDirection1 = MapDirection.NORTH;
        Vector2d expectedPosition2 =new Vector2d(4,2);
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
    public void isOccupied() throws PositionAlreadyOccupiedException{
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        map.place(animal1);
        assertTrue(map.isOccupied(new Vector2d(4,4)));
        assertFalse(map.isOccupied(new Vector2d(2,4)));
    }

    @Test
    public void objectAt() throws PositionAlreadyOccupiedException{
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        map.place(animal1);
        WorldElement result = map.objectAt(new Vector2d(4,4));
        assertEquals(animal1, result);
        WorldElement result2 = map.objectAt(new Vector2d(3,4));
        assertNull(result2);
    }

    @Test
    public void toStringTest() throws PositionAlreadyOccupiedException{
        RectangularMap map = new RectangularMap(5, 5);
        MapVisualizer visualizer = new MapVisualizer(map);
        String expectedMap = visualizer.draw(new Vector2d(0, 0), new Vector2d(4, 4));
        assertEquals(expectedMap, map.toString());
    }
}
