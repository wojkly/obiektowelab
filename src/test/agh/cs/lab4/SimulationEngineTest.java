package agh.cs.lab4;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void collisionTest() {
        String[] data = {"r","r","f","b","l","b","l","b"};

        MoveDirection[] directions = new OptionsParser().parse(data);
        IWorldMap map = new RectangularMap(5, 5);
        Vector2d[] positions = { new Vector2d(0,4), new Vector2d(3,4) };

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d pos0 = ( ((RectangularMap)(map)) .getAnimalatIdx(0) ).getPosition();
        Vector2d pos1 = ( ((RectangularMap)(map)) .getAnimalatIdx(1) ).getPosition();

        assertEquals("(1,4)", pos0.toString() );
        assertEquals("(2,4)", pos1.toString() );
    }
    @Test
    void mapBorderTest() {
        String[] d1 = {"f","f","f","l","f"};
        String[] d2 = {"b","b","l","b","b"};
        String[] d3 = {"l","f","f","r","b"};
        String[] data = new String[15];
        for(int i=0; i < data.length; i += 1){
            if (i%3 == 0) {
                data[i] = d1[i / 3];
            }else if(i%3 == 1) {
                data[i] = d2[i / 3];
            }else{
                    data[i] = d3[i / 3];
            }
        }

        MoveDirection[] directions = new OptionsParser().parse(data);
        IWorldMap map = new RectangularMap(7, 4);
        Vector2d[] positions = { new Vector2d(5,3), new Vector2d(5,1) , new Vector2d(1,2)};

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d pos0 = ( ((RectangularMap)(map)) .getAnimalatIdx(0) ).getPosition();
        Vector2d pos1 = ( ((RectangularMap)(map)) .getAnimalatIdx(1) ).getPosition();
        Vector2d pos2 = ( ((RectangularMap)(map)) .getAnimalatIdx(2) ).getPosition();

        assertEquals("(4,4)", pos0.toString() );
        assertEquals("(7,0)", pos1.toString() );
        assertEquals("(0,1)", pos2.toString() );
    }

}