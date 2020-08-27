package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("simple_tests")
@Owner("SergeyR")
@Feature("working with parametrized tests")
class SimpleTests {

    @Test
    @DisplayName("Multiply check")
    void parametrizedTest() {
        int a = 3;
        int intValue = Integer.parseInt(System.getProperty("value")); //from terminal, gradle simple_tests -Dvalue=5

        step("verify result of multiply", () -> {
            parameter("input value = ", intValue);
            parameter("result = ", intValue * a);
            assertEquals(a * intValue,  15);
        });
    }

    @Test
    @DisplayName("String input check")
    void parametrizedStringTest() {
        String b = System.getProperty("text");  //from terminal, gradle simple_tests -Dtext=apple

        step("string input check", () -> {
            assertEquals("apple", b, "b = " + b);
        });
    }
}