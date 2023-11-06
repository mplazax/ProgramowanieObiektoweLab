package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap{
    private int width;
    private int height;
    private Map<Vector2d, Animal> animals = new HashMap<>();
    public RectangularMap(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.getX() >= 0 &&
                position.getX() <= getWidth() &&
                position.getY() >= 0 &&
                position.getY() <= getHeight() &&
                !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            getAnimals().put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d newPosition = new Vector2d(animal.getPosition().getX(), animal.getPosition().getY());
        switch (direction) {
            case FORWARD -> newPosition = animal.getPosition().add(animal.getOrientation().toUnitVector());
            case BACKWARD -> newPosition = animal.getPosition().subtract(animal.getOrientation().toUnitVector());
            case RIGHT -> animal.setOrientation(animal.getOrientation().next());
            case LEFT -> animal.setOrientation(animal.getOrientation().previous());
        }
        Animal newAnimal = new Animal(newPosition);
        newAnimal.setOrientation(animal.getOrientation());
        if (place(newAnimal)) {
            getAnimals().remove(animal.getPosition());
        }
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public Animal objectAt(Vector2d position) {
        return getAnimals().get(position);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Map<Vector2d, Animal> animals) {
        this.animals = animals;
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(getWidth(), getHeight()));
    }
}
