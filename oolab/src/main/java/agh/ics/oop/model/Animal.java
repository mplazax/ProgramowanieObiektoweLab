package agh.ics.oop.model;
import static agh.ics.oop.model.MapDirection.*;


public class Animal implements WorldElement{
    private MapDirection direction;
    private Vector2d position;

    public Animal() {
        this.direction = NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d position) {
        this.direction = NORTH;
        this.position = position;
    }


    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {return position;}

    public String toString() {
        String s = direction + "";
        return s;
    }
    @Override
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator){
        Vector2d result;
        switch(direction) {
            case RIGHT -> this.direction = (this.direction).next();
            case LEFT -> this.direction = (this.direction).previous();
            case FORWARD -> {
                result = this.position.add(this.direction.toUnitVector());
                if (validator.canMoveTo(result)){
                    this.position = result;
                }
            }
            case BACKWARD -> {
                result = this.position.subtract(this.direction.toUnitVector());
                if (validator.canMoveTo(result)){
                    this.position = result;
                }
            }
        }
    }

}