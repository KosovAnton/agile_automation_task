package stepdefinitions;

import cucumber.api.java.en.Given;
import html.pages.AuthorizationPage;

import java.io.IOException;

import static http.ApiSteps.login;
import static utils.GlobalValues.BASE_URL;
import static utils.GlobalValues.DRIVER;

public class AuthorizationStepDefinitions {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Given("^I am on a FaceBook as not authorized user$")
    public void notAuthorizedInFacebook() throws IOException {
        //DRIVER.get(BASE_URL);
        //authorizationPage.getLoginHeader().logIn("wefwf","wgwgwgwg");
        login("kosov.business@gmail.com", "Fossil!123!FB");
    }
}
