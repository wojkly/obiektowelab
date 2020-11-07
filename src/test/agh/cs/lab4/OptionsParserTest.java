package agh.cs.lab4;

import agh.cs.lab4.MoveDirection;
import agh.cs.lab4.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void testParse() {
        String[] a = {"a","left","right","home","f","uwu"};
        MoveDirection[] aExp = {MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.FORWARD};

        String[] b = {"r", "ups","xd","b","left","forward"};
        MoveDirection[] bExp = {MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.FORWARD};

        assertArrayEquals(bExp, OptionsParser.parse(b));

        String[] c = {"b","b","c","abc","l","forawrd"};
        MoveDirection[] cExp = {MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.LEFT};

        assertArrayEquals(cExp, OptionsParser.parse(c));
    }
}