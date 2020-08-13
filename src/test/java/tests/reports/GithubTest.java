/*
package tests.reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;


@Owner("sergey_r")
@Feature("Работа с задачами")
public class GithubTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String BASE_URL = "https://github.com/";
    private static final int ISSUE = 12;
    private final BasicSteps steps = new BasicSteps();

    @Test
    @DisplayName("Пользователь должен иметь возможность найти Issue по номеру")
    public void shouldFindIssueByNumber(){
        Configuration.holdBrowserOpen = true;
        link("Github", String.format("%s/%s", BASE_URL, REPOSITORY));
        parameter("Репозиторий", REPOSITORY);
        parameter("Номер Issue", ISSUE);

        step("Открываем главную страницу", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () ->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        } );
        step("Открываем страницу с задачами", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем наличие задачи с номером " + ISSUE, () -> {
            $(".next_page").click();
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Пользователь не должен найти отсутствующую Issue по номеру")
    public void shouldNotFindIssueByMissingNumber() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryByLink(REPOSITORY);
        steps.openIssuesPage();
        steps.shouldNotSeeIssueWithNumber(5);
    }
}
*/
