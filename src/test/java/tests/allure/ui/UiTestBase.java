package tests.allure.ui;

import data.DataGenerator;
import pages.LoginPage;
import pages.ProjectDetailPage;
import pages.ProjectsModalPage;
import pages.TestCaseDetailPage;
import tests.TestBase;

public class UiTestBase extends TestBase {
    DataGenerator dataGenerator = new DataGenerator();
    LoginPage userAuthorization = new LoginPage();
    ProjectsModalPage projectsModalPage = new ProjectsModalPage();
    ProjectDetailPage projectPages = new ProjectDetailPage();
    TestCaseDetailPage testCasePages = new TestCaseDetailPage();

}

