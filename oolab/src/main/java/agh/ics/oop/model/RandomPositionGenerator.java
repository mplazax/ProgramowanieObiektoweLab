package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomPositionGenerator implements Iterable<Vector2d>{

    private final List<Vector2d> randomPositions = new ArrayList<Vector2d>();

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        generatePositions(maxWidth, maxHeight, grassCount);
    }

    private void generatePositions(int maxWidth, int maxHeight, int grassCount) {
        List<Vector2d> positions = new ArrayList<Vector2d>();
        for (int i = 0; i < maxWidth; i++){
            for (int j = 0; j < maxHeight; j++){
                positions.add(new Vector2d(i, j));
            }
        }

        Collections.shuffle(positions);

        for (int i = 0; i < grassCount; i++) {
            Vector2d position = positions.get(i);
            this.randomPositions.add(position);
        }
    }
    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<Vector2d>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < randomPositions.size();
            }

            @Override
            public Vector2d next() {
                return randomPositions.get(index++);
            }
        };
    }
}
