package drivers;

import com.codeborne.selenide.Configuration;
import config.Project;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static config.Project.isRemoteDriver;

public class WebDriverProvider {

    public static void configure() {
        Configuration.baseUrl = Project.config.baseUrl();
        Configuration.browserSize = Project.config.browserSize();
        String[] browserWithVersion = Project.config.browserAndVersion();
        Configuration.browser = browserWithVersion[0];
        Configuration.browserVersion = browserWithVersion[1];
        Configuration.pageLoadStrategy = "eager";
        RestAssured.baseURI = Project.config.baseUrl();

        if (isRemoteDriver()) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub",
                    Project.config.userNameSelenoid(),
                    Project.config.passwordSelenoid(),
                    Project.config.remoteDriverUrl());
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }
}
