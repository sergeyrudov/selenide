package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import resources.Credentials;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OverclockersSignInTests {
    @Test
    void overclockersSignInTest() {
        //open overclockers.ua
        open("https://forum.overclockers.ua");

        //open login window
        $(byText("Вход")).click();

        //sign in flow
        $("#username_q").setValue(Credentials.getUsername());
        $("#password_q").setValue(Credentials.getPass()).pressEnter();

        //assert that credentials.username == visible username
        // assertEquals($("#username").getText(), Credentials.getUsername());
        $("#username").shouldHave(text(Credentials.getUsername()));
    }

    @Test
    void checkUrlSid() {
        //get url sessionid and ensure that sid!=null
        assertNotNull(url().split("sid=")[1]);
    }
}
