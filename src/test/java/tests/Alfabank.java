package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Alfabank {
    private static String homePage = "https://alfabank.ru";

    @BeforeAll
    static void navigateToSavings(){
        Configuration.holdBrowserOpen = true;
        open(homePage);
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        assertEquals(homePage+"/make-money/deposits/", url());
    }

    @Test
    void navigateToArchive(){
        $(byLinkText("Архивные депозиты")).click();
        assertEquals(homePage+"/make-money/deposits/archive/", url());
    }

    @Test
    void verifyQuantityOfArchives(){

    }
}
