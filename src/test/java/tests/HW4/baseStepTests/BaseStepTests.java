package tests.HW4.baseStepTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Test;
import resources.Credentials;
import tests.HW4.baseSteps.BaseSteps;
import tests.reports.BasicSteps;

public class BaseStepTests {

    private final String USERNAME = Credentials.getGithubLogin();
    private final String PASSWORD = Credentials.getGithubPass();

    private final String REPOSITORY = "/sergeyrudov/selenide";
    private final String ISSUE_TITLE = "test";
    private final String ISSUE_BODY = "test";

    private final BaseSteps steps = new BaseSteps();


    @Test
    public void testIssueCreate() {
        Configuration.baseUrl = "https://github.com";
        steps.loginAsUser(USERNAME, PASSWORD);
        steps.navigateToRepositoryIssues(REPOSITORY);
        steps.createNewIssueWithTitleandBody(ISSUE_TITLE, ISSUE_BODY);
        steps.shouldSeeIssueWithTitle(REPOSITORY);
        steps.issueShouldBeDeleted();
        steps.verifyIssue();
    }
}