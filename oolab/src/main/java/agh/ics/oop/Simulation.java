package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class Simulation {

    public static void main(String[] args) {
        // Utwórz mapę o rozmiarze 10x10
        WorldMap map = new GrassField(10);

        // Utwórz listę ruchów dla symulacji
        List<MoveDirection> moves = List.of(
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD
        );

        // Utwórz listę pozycji początkowych dla zwierząt
        List<Vector2d> initialPositions = List.of(
                new Vector2d(2, 2),
                new Vector2d(3, 3)
        );

        // Utwórz symulację
        Simulation simulation = new Simulation(moves, initialPositions, map);

        // Uruchom symulację
        simulation.run();
    }

    private List<Animal> animals;
    private List<MoveDirection> moves;
    private int currentAnimalIndex = 0;

    private WorldMap validator;

    public Simulation(List<MoveDirection> moves, List<Vector2d> initialPositions, WorldMap map) {
        this.setMoves(moves);
        this.setAnimals(initializeAnimals(initialPositions));
        this.setValidator(map);
    }

    private List<Animal> initializeAnimals(List<Vector2d> initialPositions) {
        List<Animal> animalList = new java.util.ArrayList<>();
        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(position);
            animalList.add(animal);
            getValidator().place(animal);
        }
        return animalList;
    }

    public void run() {
        int numberOfAnimals = this.getAnimals().size();

        for (MoveDirection move : this.getMoves()) {
            Animal currentAnimal = this.getAnimals().get(this.getCurrentAnimalIndex());
            currentAnimal.move(move, this.getValidator());

            System.out.println("Zwierzę " + this.getCurrentAnimalIndex() + ": " + currentAnimal);

            this.setCurrentAnimalIndex((this.getCurrentAnimalIndex() + 1) % numberOfAnimals);
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<MoveDirection> getMoves() {
        return this.moves;
    }

    public void setMoves(List<MoveDirection> moves) {
        this.moves = moves;
    }

    public int getCurrentAnimalIndex() {
        return this.currentAnimalIndex;
    }

    public void setCurrentAnimalIndex(int currentAnimalIndex) {
        this.currentAnimalIndex = currentAnimalIndex;
    }

    public WorldMap getValidator() {
        return validator;
    }

    public void setValidator(WorldMap validator) {
        this.validator = validator;
    }
}
