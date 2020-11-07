package agh.cs.lab4;

public class World {
    public static void main(String[] args) {
        String[] kupa = {"f","f","r","l","f","f","l","f","r","b","l","f"}
        MoveDirection[] directions = new OptionsParser().parse(kupa);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine enegine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}