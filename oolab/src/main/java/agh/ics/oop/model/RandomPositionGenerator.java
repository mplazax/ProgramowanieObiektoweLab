package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int maxWidth;
    private final int maxHeight;
    private final int grassAmount;
    private final List<Vector2d> availablePositions = new ArrayList<>();
    private final Random random = new Random();

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassAmount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassAmount = grassAmount;

        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                availablePositions.add(new Vector2d(x, y));
            }
        }
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<Vector2d>() {
            private int generatedCount = 0;

            @Override
            public boolean hasNext() {
                return generatedCount < grassAmount;
            }

            @Override
            public Vector2d next() {
                if (hasNext()) {
                    int randomIndex = random.nextInt(availablePositions.size());
                    Vector2d generatedPosition = availablePositions.remove(randomIndex);
                    generatedCount++;

                    return generatedPosition;
                }

                throw new IllegalStateException("No more positions to generate.");
            }
        };
    }
}