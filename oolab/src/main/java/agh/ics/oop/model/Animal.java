package agh.ics.oop.model;

public class Animal {
    private final Vector2d mapSize = new Vector2d(4, 4);
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public Animal(Vector2d position) {
        this.setPosition(position);
    }

    public Animal() {}

    public String toString() {
        return "pozycja: " + this.getPosition().toString() + ", orientacja: " + this.getOrientation().toString();
    }

    public boolean isAt(Vector2d position) {
        return this.getPosition().equals(position);
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = this.getPosition();
        switch (direction) {
            case FORWARD -> newPosition = this.getPosition().add(this.getOrientation().toUnitVector());
            case BACKWARD -> newPosition = this.getPosition().subtract(this.getOrientation().toUnitVector());
            case RIGHT -> this.setOrientation(this.getOrientation().next());
            case LEFT -> this.setOrientation(this.getOrientation().previous());
        }
        if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(this.mapSize)) {
            this.setPosition(newPosition);
        }
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
