package agh.ics.oop.model;

public class Vector2d {

    final private int x;
    final private int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }
    public Vector2d upperRight(Vector2d other){
        int max1 = this.x;
        int max2 = this.y;

        if (other.x > max1) max1 = other.x;
        if (other.y > max2) max2 = other.y;
        return new Vector2d(max1, max2);
    }
    public Vector2d lowerLeft(Vector2d other){
        int min1 = this.x;
        int min2 = this.y;

        if (other.x < min1) min1 = other.x;
        if (other.y < min2) min2 = other.y;
        return new Vector2d(min1, min2);
    }
    public Vector2d opposite(){
        return new Vector2d(this.x*(-1), this.y*(-1));
    }

    
    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Vector2d that)) return false;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        return result;
    }


}
