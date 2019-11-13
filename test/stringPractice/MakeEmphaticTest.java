package stringPractice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeEmphaticTest {

    @Test
    public void longStringTest() {
        assertEquals("EMPHASIS!!!", stringPractice.MakeEmphatic.makeEmphatic("emphasis"));
    }


    @Test
    public void shortStringTest() {
        assertEquals("I!!!", stringPractice.MakeEmphatic.makeEmphatic("i"));
    }

    @Test
    public void emptyStringTest() {
        assertEquals("!!!", stringPractice.MakeEmphatic.makeEmphatic(""));
    }


}
