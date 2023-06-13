package api.pages;


import api.models.*;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiVerify {

    @Step("Api verify  changing in response")
    public void verifyChangingNameTestCase(EditNameTestCaseResponse testCaseResponse, EditNameTestCaseBody body) {
        assertThat(testCaseResponse.getName()).isEqualTo(body.getName());
    }

    @Step("Api verify  description in response")
    public void verifyDescriptionTestCase(TestCaseDataResponseDto testCaseDataResponseDto, DescriptionTestCaseDto descriptionTestCaseDto) {
        assertThat(testCaseDataResponseDto.getDescription()).isEqualTo(descriptionTestCaseDto.getDescription());
    }

    @Step("Api verify  tag {tagName} in response ")
    public ApiVerify verifyAddendumTagTestCase(String tagName, TestCaseTagRequest tag) {
        assertThat(tagName).as("Ошибка с именем tag").isEqualTo(tag.getName());
        return this;
    }

    @Step("Api verify  step {step} in response ")
    public void verifyStepTagTestCase(List<TestCaseScenarioDto.Step> expectedSteps, TestCaseScenarioDto responseTestCaseScenario) {
        assertThat(responseTestCaseScenario.getSteps()).isEqualTo(expectedSteps);
    }
}
