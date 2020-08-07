package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import resources.Credentials;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FinanceUaConverter {
    //verify that input amount >=0
    @Test
    void verifyInputAmount() {
        assert Credentials.getAmount() >= 0;
        assertTrue(Credentials.getAmount() >= 0, "пояснение");
        
        
        // Arrange / Given
        // Act / When
        // Assert / Then
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
                .setValue(String.valueOf(Credentials.getAmount()));

        // get result and replace " " to ""
        String result = $("#currency_exchange")
                .getValue().replaceAll("\\s+", "");

        //assert that result = amount*currency_rate
        assertEquals(result,
                String.format("%.2f", currencyRate * Credentials.getAmount()));
    }
}
