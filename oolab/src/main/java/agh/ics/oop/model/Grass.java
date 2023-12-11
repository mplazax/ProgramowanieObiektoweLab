package agh.ics.oop.model;


import agh.ics.oop.model.interfaces.WorldElement;

public class Grass implements WorldElement {
    private final Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition(){ return position;}

    public String toString() { return "*";}

    @Override
    public boolean isAt(Vector2d position){return this.position.equals(position);}

}
