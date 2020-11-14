package agh.cs.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveToTest() {
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(3,5)));
        map.place(new Animal(map, new Vector2d(3,8)));
        map.place(new Animal(map, new Vector2d(5,7)));

        assertFalse( map.canMoveTo(new Vector2d(3,5)));
        assertFalse( map.canMoveTo(new Vector2d(3,8)));
        assertFalse( map.canMoveTo(new Vector2d(5,7)));
        assertTrue( map.canMoveTo(new Vector2d(4,4)));
    }

    @Test
    void placeTest() {
        IWorldMap map = new GrassField(8);
        map.place(new Animal(map, new Vector2d(2,3)));
        map.place(new Animal(map, new Vector2d(5,0)));
        map.place(new Animal(map, new Vector2d(6,2)));
        map.place(new Animal(map, new Vector2d(5,0)));

        assertEquals(3, ((GrassField)(map)).getNumAnimals());
    }

    @Test
    void isOccupiedTest() {
        IWorldMap map = new GrassField(9);
        map.place(new Animal(map, new Vector2d(4,1)));
        map.place(new Animal(map, new Vector2d(3,2)));
        map.place(new Animal(map, new Vector2d(5,5)));
        map.place(new Animal(map, new Vector2d(1,3)));

        assertTrue(map.isOccupied(new Vector2d(4,1)));
        assertTrue(map.isOccupied(new Vector2d(3,2)));
        assertTrue(map.isOccupied(new Vector2d(5,5)));
        assertTrue(map.isOccupied(new Vector2d(1,3)));
        assertFalse(map.isOccupied(new Vector2d(5,2)));
        assertFalse(map.isOccupied(new Vector2d(4,2)));
    }

    @Test
    void objectAtTest() {
        IWorldMap map = new GrassField(12);
        map.place(new Animal(map, new Vector2d(2,3)));
        map.place(new Animal(map, new Vector2d(5,0)));
        map.place(new Animal(map, new Vector2d(6,2)));
        map.place(new Animal(map, new Vector2d(5,0)));

        assertTrue( null != map.objectAt(new Vector2d(6,2)));
        assertTrue( null != map.objectAt(new Vector2d(2,3)));
    }
}