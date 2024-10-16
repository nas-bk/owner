package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.open;

public class WebDriverProvider {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }


    public void createWebDriver() {

        if (config.getRemoteUrl() != null) {
            Configuration.remote = config.getRemoteUrl();
            Configuration.pageLoadStrategy = "eager";
            Configuration.timeout = 15000;
        }

        switch (config.getBrowser()) {
            case CHROME: {
                Configuration.browser = "chrome";
                break;
            }
            case FIREFOX: {
                Configuration.browser = "firefox";
                break;
            }
            default:
                throw new RuntimeException("No such driver");
        }

        Configuration.browserVersion = config.getBrowserVersion();
        open(config.getBaseUrl());
    }

}
