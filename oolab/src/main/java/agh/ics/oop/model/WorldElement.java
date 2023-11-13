package agh.ics.oop.model;

import agh.ics.oop.model.Vector2d;

public interface WorldElement {
    Vector2d getPosition();
    String toString();
    boolean isAt(Vector2d position);
}
