package tests.HW2;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import resources.Credentials;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OverclockersSignInTest {
    @Test
    void overclockersSignInTest() {
        //open overclockers.ua
        open("https://forum.overclockers.ua");

        //open login window
        $(byText("Вход")).click();

        //sign in flow
        $("#username_q").setValue(Credentials.getUsername());
        $("#password_q").setValue(Credentials.getPass()).pressEnter();

        //verify that user signed in
        assertEquals($(By.className("username")).getText(), Credentials.getUsername());
        //verify that user get session id
        assertNotNull(url().split("sid=")[1]);
    }
}