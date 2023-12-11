package agh.ics.oop.model;
import java.util.Map;
import java.util.UUID;


public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Map<Vector2d, Animal> getAnimals(){ return animals; }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(this.width, this.height);
        this.upperright = new Vector2d(this.width, this.height);
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position);
    }
}
