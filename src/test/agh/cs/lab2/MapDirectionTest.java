package agh.cs.lab2;

import junit.framework.TestCase;
import org.junit.Test;


public class MapDirectionTest extends TestCase {
    @Test
    public void testNext() {
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next() );
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next() );
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next() );
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next() );
    }
    @Test
    public void testPrevious() {
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
    }
}