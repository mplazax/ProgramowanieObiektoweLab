package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private int currentAnimalIndex = 0;

    public Simulation(List<MoveDirection> moves, List<Vector2d> initialPositions) {
        this.moves = moves;
        this.animals = initializeAnimals(initialPositions);
    }

    private List<Animal> initializeAnimals(List<Vector2d> initialPositions) {
        List<Animal> animalList = new java.util.ArrayList<>();
        for (Vector2d position : initialPositions) {
            animalList.add(new Animal(position));
        }
        return animalList;
    }

    public void run() {
        int numberOfAnimals = animals.size();

        for (MoveDirection move : moves) {
            Animal currentAnimal = animals.get(currentAnimalIndex);
            currentAnimal.move(move);

            System.out.println("Zwierzę " + currentAnimalIndex + ": " + currentAnimal);

            currentAnimalIndex = (currentAnimalIndex + 1) % numberOfAnimals;
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }
}
