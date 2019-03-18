package html.blocks;

import html.elements.Button;
import html.elements.Input;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Edit message popup")
@FindBy(id = "rc.u_2e_0")
public class EditMessagePopup extends HtmlElement {

    @Name("Textbox")
    @FindBy(xpath = ".//div[@role='textbox']")
    private Input textbox;

    @Name("Submit")
    @FindBy(xpath = ".//button[@type='submit']")
    private Button submit;

    public EditMessagePopup fillTextbox(String text) {
        textbox.shouldBeDisplayed()
                .clean()
                .sendKeys(text);
        return this;
    }

    public EditMessagePopup clickSubmitButton() {
        submit.shouldBeDisplayed()
                .click();
        return this;
    }

}
