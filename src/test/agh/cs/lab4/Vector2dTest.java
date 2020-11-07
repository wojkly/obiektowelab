package agh.cs.lab4;

import agh.cs.lab4.Vector2d;
import junit.framework.TestCase;
import org.junit.Test;

public class Vector2dTest extends TestCase {
    @Test
    public void testEquals(){
        assertEquals(new Vector2d(6,-1), new Vector2d(6,-1));
    }
    @Test
    public void testToString(){
        assertEquals("(2,8)", new  Vector2d(2,8).toString());
    }
    @Test
    public void testPrecedes(){
        Vector2d u = new Vector2d(1,0);
        Vector2d v = new Vector2d(3,4);
        Vector2d w = new Vector2d(4,2);

        assertTrue(u.precedes(v));
        assertTrue(u.precedes(w));
        assertFalse(w.precedes(v));
        assertFalse(v.precedes(w));
    }
    @Test
    public void testFollows(){
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
    public void testUpperRight(){
        Vector2d u = new Vector2d(2,6);
        Vector2d v = new Vector2d(8,5);
        Vector2d w = new Vector2d(8,4);
        Vector2d x = new Vector2d(8,6);

        assertEquals(x, u.upperRight(v));
        assertEquals(x, u.upperRight(x));
        assertEquals(v, v.upperRight(w));
    }
    @Test
    public void testLowerLeft(){
        Vector2d u = new Vector2d(3,5);
        Vector2d v = new Vector2d(7,7);
        Vector2d w = new Vector2d(7,2);
        Vector2d x = new Vector2d(3,2);

        assertEquals(x, u.lowerLeft(w));
        assertEquals(u, u.lowerLeft(v));
        assertEquals(x, x.lowerLeft(v));
    }
    @Test
    public void testAdd(){
        Vector2d u = new Vector2d(8,4);
        Vector2d v = new Vector2d(-4,1);
        Vector2d w = new Vector2d(4,5);
        assertEquals(w, u.add(v));
    }
    @Test
    public void testSubtract(){
        Vector2d u = new Vector2d(4,6);
        Vector2d v = new Vector2d(-4,3);
        Vector2d w = new Vector2d(8,3);
        assertEquals(w, u.subtract(v));
    }
    @Test
    public void testOpposite(){
        Vector2d u = new Vector2d(4,6);
        Vector2d v = new Vector2d(-4,-6);
        assertEquals(v, u.opposite());
    }
}