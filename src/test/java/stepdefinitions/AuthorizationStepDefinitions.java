package stepdefinitions;

import cucumber.api.java.en.Given;
import html.pages.LoginPage;

import java.io.IOException;

import static utils.GlobalValues.BASE_URL;
import static utils.GlobalValues.DRIVER;

public class AuthorizationStepDefinitions {

    LoginPage authorizationPage = new LoginPage();

    @Given("^I am on a FaceBook as not authorized user$")
    public void notAuthorizedInFacebook() throws IOException {
        DRIVER.get(BASE_URL);
        authorizationPage.login("kosov.business@gmail.com", "Fossil!123!FB");
    }
}
