package tests.HW5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("simple_tests")
public class SimpleTests {

    @Test
    void parametrizedTest() {
        int a = 2; // gradle simple_tests -Da=5
        int b = 3; //from terminal, gradle simple_tests -Db=3

        assertEquals(a * b,  15);
    }

}
