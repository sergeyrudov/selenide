package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.GooglePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

class GoogleTest {
    GooglePage googlePage = new GooglePage();
    @Test
    void selenideSearchTest() {
        SelenideLogger.addListener("allureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        String seachText = "Привет";

        step("Open google", () -> {
            googlePage.openMainPage();
        });

        step("Input searchtext", () -> {
            googlePage.typeSearch(seachText);
        });

        step("Verify value", () -> {
            googlePage.verify(seachText);
        });
    }
}
