package tests.HW4.selenideWithAllure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import resources.Credentials;

import static io.qameta.allure.Allure.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LambdaStepTest {
    static final String LOGIN = Credentials.getGithubLogin();
    static final String PASS = Credentials.getGithubPass();
    static final String TARGETURL = "/sergeyrudov/selenide/issues/";
    public static int issueNmbr;

    public static int getIssueNmbr() {
        return issueNmbr;
    }

    @BeforeAll
    static void initBaseUrlAndLogger() {
        Configuration.baseUrl = "https://github.com";
        SelenideLogger.addListener("allureListener", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    void testIssueCreating() {
        step("Sign in as " + LOGIN, () -> {
            Configuration.holdBrowserOpen = true;
            open("/login");
            $(byName("login")).sendKeys(LOGIN);
            $(byName("password")).sendKeys(PASS);
            $(byValue("Sign in")).click();
        });

        step("Create new issue for " + TARGETURL, () -> {
            open(TARGETURL);
            $(byXpath("//span[text()='New issue']")).click();
            $(byName("issue[title]")).setValue("test");
            $(byName("issue[body]")).setValue("test").submit();
            issueNmbr = Integer.parseInt($(byXpath("//span[contains(text(),'#')]"))
                    .getText().replace("#", ""));
            assertEquals(Configuration.baseUrl + TARGETURL + issueNmbr, url());
        });

        step("Check that issue deleted", () -> {
            parameter("Issue " + issueNmbr + "was deleted", issueNmbr);
            System.out.println(issueNmbr);
            $(".js-form-action-text").click();
        });


    }
}