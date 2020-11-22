package agh.cs.lab6;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    public MoveDirection[] directions;
    public IWorldMap map;
    private ArrayList<Animal> animalsList = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for(Vector2d initialPosition: positions) {
            Animal animal = new Animal(this.map, initialPosition);
            if( this.map.place(animal) ) this.animalsList.add(animal);
        }
    }

    @Override
    public void run() {
        int i = 0;
        for(MoveDirection dir: this.directions){
            animalsList.get(i%animalsList.size()).move(dir);
            i += 1;

            //simulation after every animal has moved once
            if (i % animalsList.size() == 0)
                System.out.println( this.map.toString()  );
        }
    }
}
