package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;
    private Map<Vector2d, Animal> animals = new HashMap<>();
    public RectangularMap(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(getWidth(), getHeight()));
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

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(getWidth(), getHeight()));
    }
}
