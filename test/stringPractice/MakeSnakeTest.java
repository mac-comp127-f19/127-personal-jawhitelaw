package stringPractice;

import activityStarterCode.stringPractice.MakeSnake;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeSnakeTest {

    @Test
    public void mixedSsTest() {
        assertEquals("SSSnake sssoundsss", stringPractice.MakeSnake.makeSnake("Snake sounds"));
    }

    @Test
    public void emptyStringTest() {
        assertEquals("", stringPractice.MakeSnake.makeSnake(""));
    }
}
