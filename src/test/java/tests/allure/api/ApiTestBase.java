package tests.allure.api;

import api.pages.ApiVerify;
import data.DataGenerator;
import pages.TestCasePagesModal;
import tests.TestBase;

public class ApiTestBase extends TestBase {
    DataGenerator dataGenerator = new DataGenerator();

    TestCasePagesModal testCasePages = new TestCasePagesModal();
    ApiVerify apiVerify = new ApiVerify();
}
