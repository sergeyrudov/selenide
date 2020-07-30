package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import resources.Credentials;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FinanceUaConverter {
    @Test
    void testCalculation() {
        //create new credentials object with amount ( amount 123.50USD)
        Credentials credentials = new Credentials();

        //open finance.i.ua
        open("http://finance.i.ua");

        //get value of today currency exchange USD
        double currency_rate = Double.parseDouble($(By.id("currency_rate")).getValue());

        //set amount 100
        $(By.id("currency_amount"))
                .setValue(String.valueOf(credentials.getAmount()));

        // get result and replace " " to ""
        String result = $(By.id("currency_exchange"))
                .getValue().replaceAll("\\s+", "");

        //assert that result = amount*currency_rate
        assertEquals(result,
                String.format("%.2f", currency_rate * credentials.getAmount()));
    }
}
