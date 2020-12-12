package ru.csu.iit.backend.tests;

import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.commands.AuthorizationCommand;
import ru.csu.iit.backend.models.commands.RegistrationCommand;
import ru.csu.iit.backend.models.common.UserListModel;
import ru.csu.iit.backend.models.queries.UserListQueryModel;
import ru.csu.iit.backend.services.AuthService;
import ru.csu.iit.backend.services.RegistrationService;
import ru.csu.iit.backend.services.UserService;
import ru.csu.iit.backend.steps.CommonTestSteps;

import java.io.IOException;


@Test
public class RestReqresTests extends TestBase {

    @Story(value = "Checking the loading of the correct user list")
    @Test(groups = "Positive case")
    public void getCorrectUserList() {

        UserService service = new UserService(properties, ContentType.JSON);

        RequestSpecification requestSpecification = service.requestBuilder()
                .createUserListQueryModel(new UserListQueryModel(null))
                .buildUserListQuery();

        ValidatableResponse response = service.executeGetUserListQuery(requestSpecification).then();

        CommonTestSteps checker = new CommonTestSteps(response);
        checker.checkStatusCode(200)
                .checkNotNull("page")
                .checkEqualTo("page", 1)
                .checkNotNull("per_page")
                .checkEqualTo("per_page", 6)
                .checkNotNull("total")
                .checkEqualTo("total", 12)
                .checkNotNull("total_pages")
                .checkEqualTo("total_pages", 2)
                .checkNotNull("data")
                .checkEveryItemNotNull("data")
                .checkHasSize("data", 6)
                .checkNotNull("support")
                .checkNotNull("support.url")
                .checkNotNull("support.text");
    }

    @Story(value = "Verification of successful registration")
    @Test(groups = "Positive case")
    public void successfulRegistration() {

        RegistrationService service = new RegistrationService(properties, ContentType.JSON);

        RequestSpecification requestSpecification = service.requestBuilder()
                .createRegistrationCommandModel(new RegistrationCommand("eve.holt@reqres.in", "cityslicka"))
                .buildRegistrationCommand();

        ValidatableResponse response = service.executePostRegistrationData(requestSpecification).then();

        CommonTestSteps checker = new CommonTestSteps(response);
        checker.checkStatusCode(200)
               .checkNotNull("token");
    }

    @Story(value = "Verification of successful authorization")
    @Test(groups = "Positive case")
    public void successfulAuthorization() {

        AuthService service = new AuthService(properties, ContentType.JSON);

        RequestSpecification requestSpecification = service.requestBuilder()
                .createAuthorizationCommandModel(new AuthorizationCommand("eve.holt@reqres.in", "cityslicka"))
                .buildAuthorizationCommand();

        ValidatableResponse response = service.executePostAuthorizationData(requestSpecification).then();

        CommonTestSteps checker = new CommonTestSteps(response);
        checker.checkStatusCode(200)
                .checkNotNull("token");
    }

    @Story(value = "Verification of failed registration")
    @Test(groups = "Negative case")
    public void failedRegistration() {

        RegistrationService service = new RegistrationService(properties, ContentType.JSON);

        RequestSpecification requestSpecification = service.requestBuilder()
                .createRegistrationCommandModel(new RegistrationCommand("eve.holt@reqres.in"))
                .buildRegistrationCommand();

        ValidatableResponse response = service.executePostRegistrationData(requestSpecification).then();

        CommonTestSteps checker = new CommonTestSteps(response);
        checker.checkStatusCode(400)
                .checkNotNull("error")
                .checkEqualTo("error", "Missing password");
    }

    @Story(value = "Verification of failed authorization")
    @Test(groups = "Negative case")
    public void failedAuthorization() {

        AuthService service = new AuthService(properties, ContentType.JSON);

        RequestSpecification requestSpecification = service.requestBuilder()
                .createAuthorizationCommandModel(new AuthorizationCommand("eve.holt@reqres.in"))
                .buildAuthorizationCommand();

        ValidatableResponse response = service.executePostAuthorizationData(requestSpecification).then();

        CommonTestSteps checker = new CommonTestSteps(response);
        checker.checkStatusCode(400)
               .checkNotNull("error")
               .checkEqualTo("error", "Missing password");
    }

    private void someMethod() throws IOException {
        UserService service = new UserService(properties, ContentType.JSON);

        RequestSpecification requestSpecification = service.requestBuilder()
                .createUserListQueryModel(new UserListQueryModel(1))
                .buildUserListQuery();

        UserListModel model = service.getUserListData(requestSpecification);

    }
}
