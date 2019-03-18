package html.pages;

import html.blocks.LoginHeader;

public class LoginPage extends BasePage {

    private LoginHeader loginHeader;

    public void login(String email, String pass) {
        loginHeader.fillEmailField(email)
                .fillPasswordField(pass)
                .clickLogInButton();
    }
}
