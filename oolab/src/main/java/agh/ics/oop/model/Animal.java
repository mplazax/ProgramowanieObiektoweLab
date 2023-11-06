package agh.ics.oop.model;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

public class Animal {
    private final Vector2d mapSize = new Vector2d(4, 4);
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public Animal(Vector2d position) {
        this.setPosition(position);
    }

    public Animal() {
        this.setOrientation(MapDirection.NORTH);
        this.setPosition(new Vector2d(2, 2));
    }

    public String toString() {
        return switch (this.getOrientation()) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case WEST -> "<";
            case EAST -> ">";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.getPosition().equals(position);
    }

    public void move(MoveDirection direction, WorldMap validator) {
        validator.move(this, direction);
        // w przeciwnym wypadku pozostaje na swojej pozycji (jesli wychodziloby za mape)
    }


    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }
}
