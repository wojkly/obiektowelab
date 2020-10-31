package agh.cs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void moveTest1() {
        Animal dog = new Animal();
        MoveDirection[] dogMoves = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        dog.move(dogMoves[0]);
        assertEquals("pos_x: 2 pos_y: 1 orientation: Północ", dog.toString());
        dog.move(dogMoves[1]);
        assertEquals("pos_x: 2 pos_y: 1 orientation: Zachód", dog.toString());
        dog.move(dogMoves[2]);
        assertEquals("pos_x: 3 pos_y: 1 orientation: Zachód", dog.toString());
        dog.move(dogMoves[3]);
        assertEquals("pos_x: 4 pos_y: 1 orientation: Zachód", dog.toString());
        dog.move(dogMoves[4]);
        assertEquals("pos_x: 4 pos_y: 1 orientation: Zachód", dog.toString());
        dog.move(dogMoves[5]);
        assertEquals("pos_x: 4 pos_y: 1 orientation: Zachód", dog.toString());
        dog.move(dogMoves[6]);
        assertEquals("pos_x: 4 pos_y: 1 orientation: Północ", dog.toString());
    }
    @Test
    public void moveTest2() {
        Animal shark = new Animal();
        MoveDirection[] sharkMoves = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD};
        for (MoveDirection m : sharkMoves) shark.move(m);
        assertEquals("pos_x: 1 pos_y: 4 orientation: Wschód", shark.toString());
    }
    @Test
    public void moveTest3() {
        Animal rhino = new Animal();
        MoveDirection[] rhinoMoves = {MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.FORWARD};
        for (MoveDirection m : rhinoMoves) rhino.move(m);
        assertEquals("pos_x: 1 pos_y: 0 orientation: Zachód", rhino.toString());
    }
}