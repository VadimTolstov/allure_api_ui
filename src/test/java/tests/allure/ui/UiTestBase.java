package tests.allure.ui;

import data.DataGenerator;
import tests.TestBase;
import ui.pages.AuthorizationUi;
import ui.pages.ProjectPagesModal;
import ui.pages.ProjectsPagesModal;
import ui.pages.TestCasePagesModal;

public class UiTestBase extends TestBase {
    DataGenerator dataGenerator = new DataGenerator();
    AuthorizationUi userAuthorization = new AuthorizationUi();
    ProjectsPagesModal projectsPagesModal = new ProjectsPagesModal();
    ProjectPagesModal projectPages = new ProjectPagesModal();
    TestCasePagesModal testCasePages = new TestCasePagesModal();

}

