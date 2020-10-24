package agh.cs.lab2;

import junit.framework.TestCase;
import org.junit.Test;

public class Vector2dTest extends TestCase {

    @Test
    public void equalsTest(){
        assertTrue(new Vector2d(6,-1) == new Vector2d(6,-1));
    }
    @Test
    public void toStringTest(){
        assertEquals(new Vector2d(2,8).toString(), "(2,8)" );
    }
    @Test
    public void precedesTest(){
        Vector2d u = new Vector2d(1,0);
        Vector2d v = new Vector2d(3,4);
        Vector2d w = new Vector2d(4,2);

        assertTrue(u.precedes(v));
        assertTrue(u.precedes(w));
        assertFalse(w.precedes(v));
        assertFalse(v.precedes(w));
    }
    @Test
    public void followsTest(){
        Vector2d u = new Vector2d(4,4);
        Vector2d v = new Vector2d(3,4);
        Vector2d w = new Vector2d(2,5);

        assertTrue(u.follows(v));
        assertFalse(u.follows(w));
        assertFalse(w.follows(u));
        assertFalse(w.follows(v));
        assertFalse(v.follows(w));
    }
    @Test
    public void upperRightTest(){
        Vector2d u = new Vector2d(2,6);
        Vector2d v = new Vector2d(8,5);
        Vector2d w = new Vector2d(8,4);
        Vector2d x = new Vector2d(8,6);

        assertEquals(u.upperRight(v), x);
        assertEquals(u.upperRight(x), x);
        assertEquals(v.upperRight(w), v);
    }
    @Test
    public void lowerLeftTest(){
        Vector2d u = new Vector2d(3,5);
        Vector2d v = new Vector2d(7,7);
        Vector2d w = new Vector2d(7,2);
        Vector2d x = new Vector2d(3,2);

        assertEquals(u.lowerLeft(w), x);
        assertEquals(u.lowerLeft(v), u);
        assertEquals(x.lowerLeft(v), x);
    }
    @Test
    public void addTest(){
        Vector2d u = new Vector2d(8,4);
        Vector2d v = new Vector2d(-4,1);
        Vector2d w = new Vector2d(4,5);
        assertEquals(u.upperRight(v), w);
    }
    @Test
    public void subtractTest(){
        Vector2d u = new Vector2d(4,6);
        Vector2d v = new Vector2d(-4,3);
        Vector2d w = new Vector2d(8,3);
        assertEquals(u.upperRight(v), w);
    }
    @Test
    public void oppositeTest(){
        Vector2d u = new Vector2d(4,6);
        Vector2d v = new Vector2d(-4,-6);
        assertEquals(u.opposite(), v);
    }
}