package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import resources.Credentials;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OverclockersSignInTest {
    @Test
    void overclockersSignIn() {
        //create object with credentials
        Credentials credentials = new Credentials();

        //open overclockers.ua
        open("https://forum.overclockers.ua");

        //open login window
        $(".dropdown-toggle").click();

        //sign in flow
        $(By.id("username_q")).setValue(Credentials.getUsername());
        $(By.id("password_q")).setValue(credentials.getPass());
        $(By.name("login")).click();

        //ensure that username visible
        $(By.className("username")).shouldBe(Condition.visible);

        //assert that credentials.username == visible username
        assertEquals($(By.className("username")).getText(), Credentials.getUsername());
    }

    @Test
    void checkUrlSid() {
        //get url sessionid and ensure that sid!=null
        assertNotNull(url().split("sid=")[1]);
    }
}