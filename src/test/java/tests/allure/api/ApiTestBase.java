package tests.allure.api;

import api.pages.ApiVerify;
import data.DataGenerator;
import pages.TestCaseDetailPage;
import tests.TestBase;

public class ApiTestBase extends TestBase {
    DataGenerator dataGenerator = new DataGenerator();

    TestCaseDetailPage testCasePages = new TestCaseDetailPage();
    ApiVerify apiVerify = new ApiVerify();
}
