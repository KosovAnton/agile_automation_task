package html.blocks;

import html.elements.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Login block")
@FindBy(xpath = ".//div[@id='header_block']/parent::div")
public class LoginBlock extends HtmlElement {

    @Name("Email")
    @FindBy(id = "email")
    private Input email;

    @Name("Password")
    @FindBy(id = "pass")
    private Input password;

    @Name("'Log in' button")
    @FindBy(id = "loginbutton")
    private Button logIn;

    public LoginBlock fillEmailField(String text) {
        email.shouldBeDisplayed()
                .sendKeys(text);
        return this;
    }

    public LoginBlock fillPasswordField(String text) {
        password.shouldBeDisplayed()
                .sendKeys(text);
        return this;
    }

    public LoginBlock clickLogInButton() {
        logIn.shouldBeDisplayed()
                .click();
        return this;
    }
}
