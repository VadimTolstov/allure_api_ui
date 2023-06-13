package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Project;
import drivers.WebDriverProvider;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void setUp() {
        String platform = Project.config.platform();
        if ("local".equals(platform) || "remote".equals(platform))
            WebDriverProvider.configure();
        else
            throw new RuntimeException("Platform " + platform + " not supported");
    }

    @BeforeEach
    void beforeEach() {
        open();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        attachEnvDependingTestArtifacts();
        Selenide.closeWebDriver();
    }

    private void attachEnvDependingTestArtifacts() {
        Attachments.pageSource();
        String sessionId = Attachments.getSessionId();
        switch (Project.config.platform()) {
            case "remote":
                Attachments.screenshotAs("Last screenshot");
                Attachments.browserConsoleLogs();
                Attachments.addVideo(sessionId);
                break;
            case "local":
                Attachments.screenshotAs("Last screenshot");
                Attachments.browserConsoleLogs();
                break;
        }
    }
}
