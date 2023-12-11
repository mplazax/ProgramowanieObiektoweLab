package agh.ics.oop.model.interfaces;

import agh.ics.oop.model.Vector2d;

public interface WorldElement{
    boolean isAt(Vector2d position);
    public Vector2d getPosition();
}
