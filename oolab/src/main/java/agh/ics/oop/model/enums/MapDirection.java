package agh.ics.oop.model.enums;

import agh.ics.oop.model.Vector2d;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString(){
        return switch(this) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }

    public MapDirection next(){
        MapDirection[] values = MapDirection.values();
        return values[(this.ordinal()+1)% values.length];

        /*
        stary kod, gorszy do dalszej modyfikacji
        return switch(this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
             };
         */

    }

    public MapDirection previous(){

        MapDirection[] values = MapDirection.values();
        return values[(this.ordinal()-1+values.length)%values.length];



/*
       // stary kod, gorszy do dalszej modyfikacji
        return switch(this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
*/

    }

    public Vector2d toUnitVector(){
        return switch(this) {
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case EAST -> new Vector2d(1,0);
            case WEST -> new Vector2d(-1,0);
        };
    }
}
