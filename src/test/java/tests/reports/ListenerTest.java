package tests.reports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;
import static io.qameta.allure.Allure.step;
import static tests.reports.NamedBy.*;

@Feature("Работа с задачами")
public class ListenerTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String BASE_URL = "https://github.com/";
    private static final int ISSUE = 12;

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    @DisplayName("Пользователь должен иметь возможность найти Issue по номеру")
    public void shouldFindIssueByNumber(){
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(".next_page").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @Test
    @DisplayName("Пользователь должен иметь возможность найти Issue по номеру")
    public void withNamedBy(){
        link("Github", String.format("%s/%s", BASE_URL, REPOSITORY));
        parameter("Репозиторий", REPOSITORY);
        parameter("Номер Issue", ISSUE);

        open(BASE_URL);
        $(css(".header-search-input").as("Поисковая строка в заголовке")).click();
        $(css(".header-search-input").as("Поисковая строка в заголовке")).sendKeys(REPOSITORY);
        $(css(".header-search-input").as("Поисковая строка в заголовке")).submit();
        $(named(By.linkText(REPOSITORY)).as("Ссылка на репозиторий")).click();
        $(withText("Issues")).click();
        $(".next_page").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}

