package tests.HW6;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.GooglePage;

import static io.qameta.allure.Allure.step;

@Tag("run_test_in_browser")
@Owner("SergeyR")
@Feature("Running test in browser")
public class SearchTest {

    private GooglePage googlePage = new GooglePage();
    private String seachText = "Привет";

    @Test
    void selenideSearchTest() {
        Configuration.headless = true;
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
