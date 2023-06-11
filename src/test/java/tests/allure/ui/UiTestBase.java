package tests.allure.ui;

import data.DataGenerator;
import pages.AuthorizationUi;
import pages.ProjectPagesModal;
import pages.ProjectsPagesModal;
import pages.TestCasePagesModal;
import tests.TestBase;

public class UiTestBase extends TestBase {
    DataGenerator dataGenerator = new DataGenerator();
    AuthorizationUi userAuthorization = new AuthorizationUi();
    ProjectsPagesModal projectsPagesModal = new ProjectsPagesModal();
    ProjectPagesModal projectPages = new ProjectPagesModal();
    TestCasePagesModal testCasePages = new TestCasePagesModal();

}

