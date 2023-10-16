package agh.ics.oop;

import agh.ics.oop.model.*;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        Animal animal = new Animal();
        System.out.println(animal.toString());
        System.out.println("system zakończył działanie");
    }

    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            if (direction != null) {
                switch (direction) {
                    case FORWARD:
                        System.out.println("Zwierzak idzie do przodu");
                        break;
                    case BACKWARD:
                        System.out.println("Zwierzak idzie do tyłu");
                        break;
                    case RIGHT:
                        System.out.println("Zwierzak skręca w prawo");
                        break;
                    case LEFT:
                        System.out.println("Zwierzak skręca w lewo");
                        break;
                }
            }
        }
    }
}
