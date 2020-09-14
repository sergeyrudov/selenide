package tests.HW7;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.HW6.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


@Tag("video_record_test")
@Owner("SergeyR")
@Feature("Running test in browser, with video recording")
class BrowserTests extends TestBase {

    @Test
    @Description("Google test, we look for wikipedia")
    @DisplayName("Successfull search for wiki in google")
    void successfullSearch() {
        open("http://google.com");

        $(byName("q")).val("wikipedia").pressEnter();

        $("html").shouldHave(text("wikipedia.org"));
    }
}
