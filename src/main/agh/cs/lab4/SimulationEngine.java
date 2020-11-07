package agh.cs.lab4;

public class SimulationEngine implements agh.cs.lab4.IEngine {
    public MoveDirection[] directions;
    public IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for(Vector2d initialPosition: positions) {
            this.map.animalList.add(new Animal(initialPosition));
        }
    }

    @Override
    public void run() {
        for(MoveDirection dir: this.directions){
            for(Animal animal: this.map.animalsList){
                animal.move(dir);
            }
        }
    }
}
