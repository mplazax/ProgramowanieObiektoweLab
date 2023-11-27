package agh.ics.oop.model;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<MoveDirection> moves;
    private List<Animal> animals = new ArrayList<>(){};
    private WorldMap map;

    public Simulation( List<MoveDirection> moves ,List<Vector2d> positions, WorldMap map) throws PositionAlreadyOccupiedException {
        this.moves = moves;
        this.map = map;
        for(Vector2d position : positions){
            if (position.getX()>=0 && position.getY()>= 0){
                Animal animal = new Animal(position);
                if (this.map.place(animal)){
                    this.animals.add(animal);
                }
            }
        }
    }

    public List<Animal> getAnimals(){ return animals; }

    public void run(){
        int animalNum = animals.size();
        for (int i = 0; i < moves.size(); i++){
            int animalId = i%animalNum;
            map.move(animals.get(animalId), moves.get(i));

        }

    }

}
