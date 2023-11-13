package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.util.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    @Test
    public void testParse() {
        String[] args = {"f", "b", "r", "l", "orward", "unknown"};

        List<MoveDirection> result = OptionsParser.parse(args);

        assertEquals(4, ((List<?>) result).size());
        assertEquals(MoveDirection.FORWARD, result.get(0));
        assertEquals(MoveDirection.BACKWARD, result.get(1));
        assertEquals(MoveDirection.RIGHT, result.get(2));
        assertEquals(MoveDirection.LEFT, result.get(3));
    }
}
