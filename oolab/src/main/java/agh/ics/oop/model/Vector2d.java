package agh.ics.oop.model;

public class Vector2d {
    private int x;
    private int y;

    public Vector2d(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    public String toString(){
        return "("+ this.getX() +","+ this.getY() +")";
    }

    public boolean precedes(Vector2d other){
        return (this.getX() <= other.getX() && this.getY() <= other.getY());
    }

    public boolean follows(Vector2d other){
        return (this.getX() >= other.getX() && this.getY() >= other.getY());
    }

    public Vector2d upperRight(Vector2d other){
        int x,y;
        x = Math.max(this.getX(), other.getX());
        y = Math.max(this.getY(), other.getY());
        return new Vector2d(x,y);
    }

    public Vector2d lowerLeft(Vector2d other){
        int x,y;
        x = Math.min(this.getX(), other.getX());
        y = Math.min(this.getY(), other.getY());
        return new Vector2d(x,y);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.getX() - other.getX(), this.getY() - other.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
    	this.x = x;
    }

    public void setY(int y) {
    	this.y = y;
    }

    public boolean equals(Object other){
        if(this==other) return true;
        if(!(other instanceof Vector2d that)) return false;
        return (this.getX() == that.getX() && this.getY() == that.getY());
    }

    public Vector2d opposite(){
        return new Vector2d(-this.getX(),-this.getY());
    }
}