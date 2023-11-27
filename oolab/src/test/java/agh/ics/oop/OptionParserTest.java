package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class OptionParserTest {

    @Test
    public void changeTest(){
        String[] directions = {"f", "b", "l", "r"};

        List<MoveDirection> result = OptionsParser.parse(directions);

        List<MoveDirection> expected = new ArrayList<>() ;
        expected.add(FORWARD);
        expected.add(BACKWARD);
        expected.add(LEFT);
        expected.add(RIGHT);


        //assertArrayEquals(result, expected);
        assertEquals(expected, result);
    }

}

//{FORWARD, BACKWARD, LEFT, RIGHT}