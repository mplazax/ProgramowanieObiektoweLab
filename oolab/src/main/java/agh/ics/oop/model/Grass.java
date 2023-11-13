package agh.ics.oop.model;

public class Grass implements WorldElement {
    private Vector2d position;
    public Grass (Vector2d position) {
        setPosition(position);
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
}
