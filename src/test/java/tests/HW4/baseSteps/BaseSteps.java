package tests.HW4.baseSteps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import resources.Credentials;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static io.restassured.RestAssured.given;


public class BaseSteps {
    public static int issueNmbr;

    public static int getIssueNmbr() {
        return issueNmbr;
    }

    @Step("Sign in as user")
    public void loginAsUser(final String username, final String password) {
        Configuration.holdBrowserOpen = true;
        open("/login");
        $(byName("login")).sendKeys(username);
        $(byName("password")).sendKeys(password);
        $(byValue("Sign in")).click();
        //TODO: add verification that user signed in
    }

    @Step("Navigate to repository")
    public void navigateToRepositoryIssues(final String repository) {
        open(repository + "/issues");
    }

    @Step("Create new issue")
    public void createNewIssueWithTitleandBody(final String title, final String body) {
        $(byXpath("//span[text()='New issue']")).click();
        $(byName("issue[title]")).sendKeys(title);
        $(byName("issue[body]")).setValue(body).submit();
    }

    @Step("Check that issue created")
    public void shouldSeeIssueWithTitle(final String repository) {
        issueNmbr = Integer.parseInt($(byXpath("//span[contains(text(),'#')]"))
                .getText().replace("#", ""));
        System.out.println(issueNmbr);
        assertEquals(Configuration.baseUrl + repository + "/issues/" + issueNmbr, url());
    }

    @Step("Check that issue deleted")
    public void issueShouldBeDeleted() {
        $(".js-form-action-text").click();
    }

    @Step("Verify by API call that task was created")
    public Issue verifyIssue() {
        // @formatter:off
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization", Credentials.getToken())
                .baseUri("https://api.github.com")
                .when()
                .post("/repos/sergeyrudov/selenide/issues")
                .then()
                .statusCode(201)
                .extract()
                .as(Issue.class);
        // @formatter:on
    }
}
