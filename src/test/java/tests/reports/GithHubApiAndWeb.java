package tests.reports;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GithHubApiAndWeb {

    private static final String REPOSITORY = "sergeyrudov/selenide";

    private final BasicSteps webSteps = new BasicSteps();

    private final ApiSteps apiSteps = new ApiSteps();

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }


    @Test
    @DisplayName("Пользователь должен найти Issue созданную через API")
    public void shouldNotFindIssueByMissingNumber() {
        final Issue created = apiSteps.createIssue("Hello");

        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.openRepositoryByLink(REPOSITORY);
        webSteps.openIssuesPage();
        System.out.println(created.getNumber());
        webSteps.shouldSeeIssueWithNumber(created.getNumber());
    }
}
