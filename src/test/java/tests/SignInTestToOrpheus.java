package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import resources.Credentials;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SignInTestToOrpheus {
    private Credentials credentials = new Credentials();

    @Test
    void signInToOrpheus() {
        //open browser
        Configuration.browser = "firefox";
        open(credentials.getVipqc03());

        //find search fields
        $(byName("q")).setValue(credentials.getLogin()).pressEnter();

        //check that selenide is displayed in result
        $("html").shouldHave(text("ru.selenide.org"));
    }
}
