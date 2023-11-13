package agh.ics.oop.model;


public class Animal implements WorldElement {
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
