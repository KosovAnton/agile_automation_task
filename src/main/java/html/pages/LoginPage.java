package html.pages;

import html.blocks.LoginBlock;

import static utils.GlobalValues.BASE_URL;
import static utils.GlobalValues.DRIVER;

public class LoginPage extends BasePage {

    private final String URL = BASE_URL + "/login";

    private LoginBlock loginBlock;

    public void login(String email, String pass) {
        loginBlock.fillEmailField(email)
                .fillPasswordField(pass)
                .clickLogInButton();
    }

    public LoginPage open(){
        DRIVER.get(URL);
        return this;
    }
}
