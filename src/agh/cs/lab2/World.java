package agh.cs.lab2;

public class World {
    public static void main(String[] args) {
        Vector2d a = new Vector2d(5,4);
        Vector2d b = new Vector2d(4,5);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a.precedes(b));

    }
}
