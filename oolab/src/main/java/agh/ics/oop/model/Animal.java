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
        return "pozycja: " + this.position.toString() + ", orientacja: " + this.orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = this.position;
        switch (direction) {
            case FORWARD:
                newPosition = this.position.add(this.orientation.toUnitVector());
                break;
            case BACKWARD:
                newPosition = this.position.subtract(this.orientation.toUnitVector());
                break;
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
        }
        if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4))) {
            this.position = newPosition;
        }
    }


    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }
}
