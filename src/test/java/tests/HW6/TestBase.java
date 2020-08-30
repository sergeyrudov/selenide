package tests.HW6;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.selenide.LogType.BROWSER;
import static io.qameta.allure.selenide.LogType.CLIENT;
import static tests.HW6.helpers.AttachmentsHelper.*;


public class TestBase {
    @BeforeAll
    @Step("Tests setup")
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.headless = true;
    }

    @AfterEach
    @Step("Attachments")
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getBrowserConsoleLogs());
       // attachAsText("Client console logs", getClientConsoleLogs());

        closeWebDriver();
    }

    public static String getBrowserConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(String.valueOf(BROWSER)));
    }

    public static String getClientConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(String.valueOf(CLIENT)));
    }
}