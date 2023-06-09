package tests.allure.ui;

import helpers.Regress;
import helpers.Web;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("WEB tests Allure")
@Epic("WEB")
@Owner("толстов вадим")
public class TestCaseInteractionWebTest extends UiTestBase {

    @BeforeEach
    @DisplayName("Авторузуемя и создаем проект")
    public void createProject() {
        String newProject = dataGenerator.getRandomSentence(3);

        userAuthorization.authorizationUi();

        projectsModalPage
                .verifyProjectsPages()
                .openModalCreateNewProject()
                .createProject(newProject);

        projectPages.verifyNewProject(newProject);
    }

    @AfterEach
    @DisplayName("Удаляем проект")
    public void deleteProject() {
        projectPages.deleteProject();
    }

    @Test
    @Epic("WEB")
    @Owner("толстов вадим")
    @Regress
    @Web
    @DisplayName("Создаем test case в проекте")
    public void createTestCase() {
        String nameTestCase = dataGenerator.getRandomSentence(2);

        testCasePages
                .openTestCasesPages()
                .createTestCase(nameTestCase)
                .verifyTestCaseName(nameTestCase);
    }

    @Test
    @Epic("WEB")
    @Owner("толстов вадим")
    @Regress
    @Web
    @DisplayName("Изменяем имя у test case")
    public void renameTestCase() {
        String nameTestCase = dataGenerator.getRandomSentence(1);
        String newNameTestCase = dataGenerator.getRandomSentence(1);

        testCasePages
                .openTestCasesPages()
                .createTestCase(nameTestCase)
                .verifyTestCaseName(nameTestCase)
                .renameTestCase(newNameTestCase)
                .verifyNewNameTestCase(nameTestCase, newNameTestCase);
    }

    @Test
    @Epic("WEB")
    @Owner("толстов вадим")

    @Severity(SeverityLevel.CRITICAL)
    @Regress
    @Web
    @DisplayName("Добавляем шаги в test case")
    public void createStepTestCase() {
        String nameTestCase = dataGenerator.getRandomSentence(3);
        String step1 = dataGenerator.getRandomSentence(1);
        String step2 = dataGenerator.getRandomSentence(2);
        String step3 = dataGenerator.getRandomSentence(3);

        testCasePages
                .openTestCasesPages()
                .createTestCase(nameTestCase)
                .openTestCase(nameTestCase)
                .openStepTestCase()
                .createStepTestCase(step1)
                .createStepTestCase(step2)
                .createStepTestCase(step3)
                .saveDataTestCase()
                .verifyStepTestCase(step1)
                .verifyStepTestCase(step2)
                .verifyStepTestCase(step3);
    }

    @Test
    @Epic("WEB")
    @Owner("толстов вадим")
    @Regress
    @Web
    @DisplayName("Добавляем описание в test case")
    public void createDescriptionTestCase() {
        String nameTestCase = dataGenerator.getRandomSentence(2);
        String DescriptionTestCase = dataGenerator.getRandomSentence(4);

        testCasePages
                .openTestCasesPages()
                .createTestCase(nameTestCase)
                .openTestCase(nameTestCase)
                .createDescriptionTestCase(DescriptionTestCase)
                .saveDataTestCase()
                .verifyDescriptionTestCase(DescriptionTestCase);
    }

    @Test
    @Epic("WEB")
    @Owner("толстов вадим")
    @Regress
    @Web
    @DisplayName("Добавляем tag в test case")
    public void createTagTestCase() {
        String nameTestCase = dataGenerator.getRandomSentence(3);
        String tag1Name = dataGenerator.getRandomSentence(1);
        String tag2Name = dataGenerator.getRandomSentence(1);

        testCasePages
                .openTestCasesPages()
                .createTestCase(nameTestCase)
                .openTestCase(nameTestCase)
                .openTagTestCase()
                .createTagTestCase(tag1Name)
                .createTagTestCase(tag2Name)
                .saveDataTestCase()
                .verifyTagTestCase(tag1Name)
                .verifyTagTestCase(tag2Name);
    }

    @CsvFileSource(resources = "/attachment.csv", delimiter = '|')
    @ParameterizedTest(name = "Добовление attachment {0} в test case")
    @DisplayName("-")
    @Epic("WEB")
    @Owner("толстов вадим")
    @Regress
    @Web
    public void createAttachmentTestCase(String attachments) {
        String nameTestCase = dataGenerator.getRandomSentence(3);

        testCasePages
                .openTestCasesPages()
                .createTestCase(nameTestCase)
                .openTestCase(nameTestCase)
                .openAttachmentTestCase()
                .setUploadAttachments(attachments)
                .saveDataTestCase()
                .verifyAddAttachment(attachments);
    }
}
