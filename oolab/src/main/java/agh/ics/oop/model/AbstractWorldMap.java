package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public abstract class AbstractWorldMap implements WorldMap{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer visualization = new MapVisualizer (this);
    protected Vector2d lowerleft;
    protected Vector2d upperright;
    protected ArrayList<MapChangeListener> observers = new ArrayList<>();

    protected UUID id = UUID.randomUUID();

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }
    public void deleteObserver(MapChangeListener observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    private void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }


    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        Vector2d position = animal.getPosition();
        if (!canMoveTo(position)) {
            throw new PositionAlreadyOccupiedException(position);
        }

        animals.put(position, animal);
        notifyObservers("zwierze dodane");
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsValue(animal)){
            Vector2d position = animal.getPosition();
            MoveValidator validator = this;
            animal.move(direction, validator);
            Vector2d new_position = animal.getPosition();
            if (!position.equals(new_position)) {
                this.animals.remove(position);
                this.animals.put(new_position, animal);
            }
            notifyObservers("zwierze poruszone");
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public Map<Vector2d,WorldElement> getElements() {
        Map<Vector2d,WorldElement> result = new HashMap<>();
        for (Vector2d key : animals.keySet()){
            result.put(key,animals.get(key));
        }
        return result;
    }

    @Override
    public Boundary getCurrentBounds(){
        return new Boundary(lowerleft, upperright);
    }

    @Override
    public String toString() {
        return visualization.draw(getCurrentBounds().bottomLeft(),getCurrentBounds().upperRight() );
    }

    @Override
    public UUID getId() {
        return id;
    }
}