package tests;

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
    void quantityOfArchivesTest() {
        open("");
        
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byLinkText("Архивные депозиты")).click();
        $$(".product-cell__cell").shouldHaveSize(3);
        
        assertEquals(homePage + "/make-money/deposits/archive/", url());
    }

    @Test
    void navigateToDepositInsuranceTest() {
        open("");
        
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(".selected").sibling(3).click();
        
        assertEquals(homePage + "/make-money/strahovanie_vkladov/", url());
    }
}
//sibling(), preceding(), parent(), closest()
