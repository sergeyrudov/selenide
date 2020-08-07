package tests;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UsdConverterTest {
    private double amount = 123.50;

    @Test
    void verifyInputAmount() {
        //verify that input value has numeric positive value
        assertTrue(amount >= 0, "Amount should be only numeric with positive value!");
    }

    @Test
    void testCalculation() {
        //open finance.i.ua
        open("http://finance.i.ua");

        //get value of today currency exchange USD
        double currencyRate = Double.parseDouble
                (Objects.requireNonNull($("#currency_rate").getValue()));

        //set amount 123.50
        $("#currency_amount")
                .setValue(String.valueOf(amount));

        // get result and replace " " to ""
        String result = Objects.requireNonNull($("#currency_exchange"))
                .getValue().replaceAll("\\s+", "");

        //assert that result = amount*currency_rate
        assertEquals(result,
                String.format("%.2f", currencyRate * amount));
    }
}
