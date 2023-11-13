package agh.ics.oop.model;

import java.util.*;
import agh.ics.oop.model.util.MapVisualizer;

public class GrassField extends AbstractWorldMap {
    private HashMap<Vector2d, Animal> animals = new HashMap<Vector2d, Animal>();
    private HashMap<Vector2d, Grass> grasses = new HashMap<Vector2d, Grass>();

    public GrassField(int grassCount) {
        this.generateGrass(grassCount);
    }

    private void generateGrass(int grassCount) {
        int maxSize = (int) Math.sqrt(grassCount * 10);
        RandomPositionGenerator generator = new RandomPositionGenerator(maxSize, maxSize, grassCount);
        for (Vector2d position : generator) {
            Grass grass = new Grass(position);
            this.grasses.put(position, grass);
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        if (animal != null) {
            return animal;
        }
        if (this.grasses.containsKey(position)) {
            return this.grasses.get(position);
        }
        return null;
    }

    public int getGrassCount() {
        return this.grasses.size();
    }

    public String toString()    {
        Vector2d bottomLeft = null;
        Vector2d topRight = null;
        for (Vector2d position : this.animals.keySet()) {
            if (bottomLeft == null) {
                bottomLeft = position;
                topRight = position;
            }
            else {
                bottomLeft = bottomLeft.lowerLeft(position);
                topRight = topRight.upperRight(position);
            }
        }
        for (Vector2d position : this.grasses.keySet()) {
            if (bottomLeft == null) {
                bottomLeft = position;
                topRight = position;
            }
            else {
                bottomLeft = bottomLeft.lowerLeft(position);
                topRight = topRight.upperRight(position);
            }
        }
        assert bottomLeft != null;
        return new MapVisualizer(this).draw(bottomLeft, topRight);
    }
}


