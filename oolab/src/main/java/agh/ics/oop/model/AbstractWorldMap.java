package agh.ics.oop.model;

import java.util.HashMap;

public abstract class AbstractWorldMap implements WorldMap {
    protected HashMap<Vector2d, Animal> animals = new HashMap<Vector2d, Animal>();

    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position);
    }

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        Vector2d newPosition = null;
        switch (direction) {
            case LEFT -> {
                animal.setOrientation(animal.getOrientation().previous()); return;
            }
            case RIGHT -> {
                animal.setOrientation(animal.getOrientation().next()); return;
            }
            case FORWARD -> newPosition = animal.getPosition().add(animal.getOrientation().toUnitVector());
            case BACKWARD -> newPosition = animal.getPosition().subtract(animal.getOrientation().toUnitVector());
        }
        if (this.canMoveTo(newPosition)) {
            animal.setPosition(newPosition);
            this.animals.remove(oldPosition);
            this.animals.put(newPosition, animal);
        }
    }

    public WorldElement ObjectAt(Vector2d position) {
        if (this.animals.containsKey(position)) {
            return this.animals.get(position);
        }
        return null;
    }

    public int getAnimalCount() {
        return this.animals.size();
    }

    public abstract String toString();
}
