package stepdefinitions.UI;

import cucumber.api.java.en.Given;
import html.pages.LoginPage;

public class LoginStepdefs {

    LoginPage loginPage = new LoginPage();

    @Given("^User logs in with credentials \"([^\"]*)\"/\"([^\"]*)\"$")
    public void userLogsInWithCredentials(String email, String pass) throws Throwable {
        loginPage.open()
                .login(email, pass);
    }
}
