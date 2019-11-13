package stringPractice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UppercaseFirstLetterTest {

    @Test
    public void uppercaseStringTest() {
        assertEquals("Uppercase", stringPractice.UppercaseFirstLetter.uppercaseFirstLetter("Uppercase"));
    }

    @Test
    public void longStringTest() {
        assertEquals("Uppercase", stringPractice.UppercaseFirstLetter.uppercaseFirstLetter("uppercase"));
    }

    @Test
    public void shortStringTest() {
        assertEquals("A", stringPractice.UppercaseFirstLetter.uppercaseFirstLetter("a"));
    }

    @Test
    public void emptyStringTest() {
        assertEquals("", stringPractice.UppercaseFirstLetter.uppercaseFirstLetter(""));
    }

    @Test
    public void sameLetterTest() {
        assertEquals("Eeee", stringPractice.UppercaseFirstLetter.uppercaseFirstLetter("eeee"));
    }

}
