package agh.cs.lab2;

public class World {
    public static void main(String[] args) {
        Animal cat = new Animal();
        System.out.println( cat.toString() );
        cat.move(MoveDirection.RIGHT);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.FORWARD);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.LEFT);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.BACKWARD);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.BACKWARD);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.BACKWARD);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.LEFT);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.FORWARD);
        System.out.println( cat.toString() );
        cat.move(MoveDirection.FORWARD);
        System.out.println( cat.toString() );
    }
}