package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GooglePage {

    @Step("Open google")
    public void openMainPage() {
        open("https://google.com");
    }

    @Step("Set value in searchfield")
    public void typeSearch(String someText) {
        $(byName("q")).setValue(someText).pressEnter();
    }

    @Step("Verify value")
    public void verify(String verifyText) {
        $("html").shouldHave(text(verifyText));
    }
}
