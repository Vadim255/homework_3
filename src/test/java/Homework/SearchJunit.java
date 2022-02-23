package Homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchJunit {

    // устанавливаем настройки браузера
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1900x1200";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void searchJunit() {
        // откройте страницу Selenide в Github
        open("/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $(".js-repo-nav").find(byText("Wiki")).click();
        // убедитесь, что в списке страниц(Pages) есть страница SoftAssertions
        $(".Layout-main").find(byText("Soft assertions")).click();
        // откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").find(byText("Using JUnit5 extend test class:")).shouldHave(text("Using JUnit5 extend test class:"));
    }
}
