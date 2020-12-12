package ru.csu.iit.backend.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class CommonTestSteps {
    private final ValidatableResponse response;

    public CommonTestSteps(ValidatableResponse response) {
        this.response = response;
    }

    @Step(value = "Check that the response status code is")
    public CommonTestSteps checkStatusCode(int code){
        response.statusCode(code);
        return this;
    }

    @Step(value = "Check that {0} not null")
    public CommonTestSteps checkNotNull(String fieldName){
        response.assertThat().body(fieldName, notNullValue());
        return this;
    }

    @Step(value = "Check that every item {0} not null")
    public CommonTestSteps checkEveryItemNotNull(String fieldName){
        response.assertThat().body(fieldName, everyItem(notNullValue()));
        return this;
    }

    @Step(value = "Check that {0} value equal to {1}")
    public <T> CommonTestSteps checkEqualTo(String fieldName, T operand){
        response.assertThat().body(fieldName, equalTo(operand));
        return this;
    }

    @Step(value = "Check that {0} value has size {1}")
    public CommonTestSteps checkHasSize(String fieldName, int size){
        response.assertThat().body("data", hasSize(size));
        return this;
    }
}
