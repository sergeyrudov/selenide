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
    void verifyAmount() throws NullPointerException{
        assert Credentials.getAmount()>=0;
    }

    @Test
    void testCalculation() {
        //open finance.i.ua
        open("http://finance.i.ua");

        //get value of today currency exchange USD
        double currency_rate = Double.parseDouble
                (Objects.requireNonNull($(By.id("currency_rate")).getValue()));

        //set amount 123.50
        $(By.id("currency_amount"))
                .setValue(String.valueOf(Credentials.getAmount()));

        // get result and replace " " to ""
        String result = $(By.id("currency_exchange"))
                .getValue().replaceAll("\\s+", "");

        //assert that result = amount*currency_rate
        assertEquals(result,
                String.format("%.2f", currency_rate * Credentials.getAmount()));
    }
}
