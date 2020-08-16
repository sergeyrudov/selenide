package tests.HW3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AlfabankTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://alfabank.ru";
    }

    @Test
    void verifyQuantityOfArchives() {
        open("");
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byLinkText("Архивные депозиты")).click();
        $$(".product-cell__cell").shouldHaveSize(3);
        assertEquals(Configuration.baseUrl + "/make-money/deposits/archive/", url());
    }

    @Test
    void navigateToDepositInsurance() {
        open("");
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(".selected").sibling(3).click();
        assertEquals(Configuration.baseUrl + "/make-money/strahovanie_vkladov/", url());
    }
}
//sibling(), preceding(), parent(), closest()