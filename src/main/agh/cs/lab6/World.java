package agh.cs.lab6;

public class World {
    public static void main(String[] args) {
////        String[] dane = {"f","f","r","l","f","f","l","f","r","b","l","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(6);
//        IWorldMap map = new RectangularMap(10,5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println( map.toString()  );
        engine.run();
        System.out.println("final status:");
        System.out.println( map.toString()  );


    }
}