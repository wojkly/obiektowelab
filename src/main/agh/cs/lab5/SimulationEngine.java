package agh.cs.lab5;

public class SimulationEngine implements IEngine {
    public MoveDirection[] directions;
    public IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for(Vector2d initialPosition: positions) {
            this.map.place(new Animal(this.map, initialPosition));
        }
    }

    @Override
    public void run() {
        int animalsCount = ((AbstractWorldMap)(this.map)).getNumAnimals();
        int i = 0;
        for(MoveDirection dir: this.directions){
            ( ((AbstractWorldMap)(this.map)).getAnimalatIdx(i % animalsCount)).move(dir);

            i += 1;
//            if (i % animalsCount == 0)
//                System.out.println( this.map.toString()  );
        }
    }
}
