package tests;

import config.WebDriverProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.title;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WebDriverTest {

    private final WebDriverProvider webDriverProvider = new config.WebDriverProvider();

    @BeforeEach
    public void startWebDriver() {
        webDriverProvider.createWebDriver();
    }

    @Test
    public void gitHubTest() {
        String title = title();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }
}