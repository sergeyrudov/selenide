package tests.HW1;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.GooglePage;


import static io.qameta.allure.Allure.step;

class GoogleTest {
    private GooglePage googlePage = new GooglePage();
    private String seachText = "Привет";

    @Test
    void selenideSearchTest() {
        SelenideLogger.addListener("allureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );

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
