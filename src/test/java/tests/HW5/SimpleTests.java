package tests.HW5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("simple_tests")
public class SimpleTests {

    @Test
    void parametrizedTest() {
        int a = 3;
        String b = System.getProperty("value");  //from terminal, gradle simple_tests -Dvalue=5
        int intValue = Integer.parseInt(b);

        assertEquals(a * intValue,  15);
    }

    @Test
    void parametrizedStringTest() {
        String b = System.getProperty("text");  //from terminal, gradle apple_tests -Dtext=apple

        assertEquals("apple", b, "b = " + b);
    }
}
