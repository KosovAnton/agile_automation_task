package html.blocks;

import html.elements.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.User;

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

    public void logIn(String email, String password){
        fillEmailField(email);
        fillPasswordField(password);
        clickLogInButton();
    }

    public void logIn(User user){
        fillEmailField(user.email);
        fillPasswordField(user.password);
        clickLogInButton();
    }

    public void fillEmailField(String text){
        this.email.sendKeys(text);
    }

    public void fillPasswordField(String text){
        this.password.sendKeys(text);
    }

    public void clickLogInButton(){
        logIn.click();
    }
}
