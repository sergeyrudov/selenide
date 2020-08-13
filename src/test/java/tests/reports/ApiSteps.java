package tests.reports;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import org.hamcrest.core.Is;
import resources.Credentials;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiSteps {

    @Step("Создаем задача с заданным названием")
    public Issue createIssue(String title) {

        final Issue toCreate = new Issue();
        toCreate.setTitle(title);

        // @formatter:off
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization", "token "+ Credentials.getToken())
                .baseUri("https://api.github.com")
                .body(toCreate)
        .when()
                .post("/repos/sergeyrudov/selenide/issues")
        .then()
                .statusCode(201)
        .extract()
                .as(Issue.class);
        // @formatter:on
    }

}
