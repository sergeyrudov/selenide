package tests.HW5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("simple_tests")
public class SimpleTests {

    @Test
    void positiveTest() {
        int a = 2;
        int b = 3;

        assertEquals(a * b,  6);
    }

    @Test
    void negativeTest() {
        int a = 2;
        int b = 3;

        assertEquals(a * b, 7, "a * b should be 6, not 7");
    }
}
