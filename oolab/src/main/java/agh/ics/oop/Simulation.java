package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.WorldMap;

import java.util.List;

public class Simulation {
    private List<Animal> animals;
    private List<MoveDirection> moves;
    private int currentAnimalIndex = 0;

    private final WorldMap validator;

    public Simulation(List<MoveDirection> moves, List<Vector2d> initialPositions, WorldMap map) {
        this.setMoves(moves);
        this.setAnimals(initializeAnimals(initialPositions));
        this.validator = map;
    }

    private List<Animal> initializeAnimals(List<Vector2d> initialPositions) {
        List<Animal> animalList = new java.util.ArrayList<>();
        for (Vector2d position : initialPositions) {
            animalList.add(new Animal(position));
        }
        return animalList;
    }

    public void run() {
        int numberOfAnimals = getAnimals().size();

        for (MoveDirection move : getMoves()) {
            Animal currentAnimal = getAnimals().get(getCurrentAnimalIndex());
            currentAnimal.move(move, validator);

            System.out.println("Zwierzę " + getCurrentAnimalIndex() + ": " + currentAnimal);

            setCurrentAnimalIndex((getCurrentAnimalIndex() + 1) % numberOfAnimals);
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<MoveDirection> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveDirection> moves) {
        this.moves = moves;
    }

    public int getCurrentAnimalIndex() {
        return currentAnimalIndex;
    }

    public void setCurrentAnimalIndex(int currentAnimalIndex) {
        this.currentAnimalIndex = currentAnimalIndex;
    }
}
