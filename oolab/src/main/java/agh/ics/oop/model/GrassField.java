package agh.ics.oop.model;
import agh.ics.oop.model.interfaces.WorldElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


public class GrassField extends AbstractWorldMap {
    private final int grassAmount;
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();
    private final Random random = new Random();


    public GrassField(int grassAmount) {
        this.grassAmount = grassAmount;
        placeGrass();
        this.id = UUID.randomUUID();
    }
    private void placeGrass() {
        int maxWidth = (int) Math.sqrt(grassAmount * 10);
        int maxHeight = (int) Math.sqrt(grassAmount * 10);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassAmount);

        for (Vector2d grassPosition : randomPositionGenerator) {
            grassMap.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animals.get(position) == null;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassMap.get(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null){return animals.get(position);}
        return grassMap.get(position);
    }

    private Vector2d currentLower(){
        Vector2d lowerLeft = new Vector2d(0, 0);
        for (Vector2d position : animals.keySet()) {
            lowerLeft = lowerLeft.lowerLeft(position);
        }
        for (Vector2d position : grassMap.keySet()) {
            lowerLeft = lowerLeft.lowerLeft(position);
        }
        return lowerLeft;
    }

    private Vector2d currentUpper(){
        Vector2d upperRight = new Vector2d(0, 0);
        for (Vector2d position : animals.keySet()) {
            upperRight = upperRight.upperRight(position);
        }
        for (Vector2d position : grassMap.keySet()) {
            upperRight = upperRight.upperRight(position);
        }
        return upperRight;
    }

    @Override
    public Map<Vector2d, WorldElement>getElements() {
        Map<Vector2d,WorldElement> result = super.getElements();
        for (Vector2d key : grassMap.keySet()){
            result.put(key,grassMap.get(key));
        }
        return result;
    }

    @Override
    public Boundary getCurrentBounds(){
        lowerleft = currentLower();
        upperright = currentUpper();
        return super.getCurrentBounds();
    }


}
