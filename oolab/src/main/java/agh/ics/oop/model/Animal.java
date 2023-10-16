package agh.ics.oop.model;

import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.MapDirection;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    public Animal() {}
    public Animal(Vector2d position) {
        this.position = position;
    }

    public String toString() {
        return "position: " + this.position.toString() + ", orientation: " + this.orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }



}
