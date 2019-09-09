package BasicJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHypotenuse {
    @Test
    public void testHypotenuse(){
        assertEquals(5, Hypotenuse.calculateHypotenuse(3,4));
    }

}
