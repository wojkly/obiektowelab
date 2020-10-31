package agh.cs.lab3;

public class World {
    public static void main(String[] args) {
        Animal cat = new Animal();
        String[] data = new String[]{"f","afs","l","left","forward","forward","uwu","backward",
        "r","f","f","f","kawa","f","left"};
        MoveDirection[] moves = OptionsParser.parse(data);
        System.out.println(cat.toString());
        for(MoveDirection m: moves){
            cat.move(m);
            System.out.println(cat.toString());
        }

        Animal dog = new Animal();
        MoveDirection[] dogMoves = {MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD};

        for(MoveDirection m: dogMoves)
            dog.move(m);
        System.out.println("dog"+ dog.toString());
    }
}