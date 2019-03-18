package html.blocks;

import html.elements.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Login header")
@FindBy(xpath = ".//div[contains(@class,'loggedout_menubar')]")
public class LoginHeader extends HtmlElement {

    @Name("Email")
    @FindBy(id = "email")
    private Input email;

    @Name("Password")
    @FindBy(id = "pass")
    private Input password;

    @Name("'Log in' button")
    @FindBy(id = "pass")
    private Button logIn;

    public LoginHeader fillEmailField(String text) {
        email.shouldBeDisplayed()
                .sendKeys(text);
        return this;
    }

    public LoginHeader fillPasswordField(String text) {
        password.shouldBeDisplayed()
                .sendKeys(text);
        return this;
    }

    public LoginHeader clickLogInButton() {
        logIn.shouldBeDisplayed()
                .click();
        return this;
    }
}
