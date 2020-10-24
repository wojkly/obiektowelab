package agh.cs.lab2;

public class World {
    public static void main(String[] args) {
        MapDirection xd = MapDirection.NORTH;
        System.out.println(xd.toString());
        System.out.println(xd.next ());
        System.out.println(xd.previous());
        Vector2d a = xd.toUnitVector();
        System.out.println( a.toString() );
    }
}