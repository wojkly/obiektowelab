package agh.cs.lab4;

public class SimulationEngine implements agh.cs.lab4.IEngine {
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
        int animalsCount = ((RectangularMap)(this.map)).getNumAnimals();
        int i = 0;
        for(MoveDirection dir: this.directions){
            ( ((RectangularMap)(this.map)) .getAnimalatIdx(i % animalsCount)).move(dir);
            i += 1;
//            if (i % animalsCount == 0)
//                System.out.println( this.map.toString()  );
        }
    }
}
