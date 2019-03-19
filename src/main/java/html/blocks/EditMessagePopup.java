package html.blocks;

import html.elements.BaseWebElement;
import html.elements.Button;
import html.elements.Input;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static utils.GlobalValues.DRIVER;

@Name("Edit message popup")
@FindBy(xpath = ".//div[@role='dialog']//div[@data-testid='react-composer-root']")
public class EditMessagePopup extends BaseWebElement<EditMessagePopup> {

    @Name("Textbox")
    @FindBy(xpath = ".//div[@role='textbox']")
    private Input textbox;

    @Name("Submit")
    @FindBy(xpath = ".//button[@type='submit']")
    private Button submit;

    public EditMessagePopup enterText(String text) {
        textbox.shouldBeDisplayed()
                .clean()
                .sendKeys(text);
        return this;
    }

    public EditMessagePopup uppendText(String text) {
        textbox.shouldBeDisplayed()
                .sendKeys(text);
        return this;
    }

    public EditMessagePopup clickSubmitButton() {
        submit.shouldBeDisplayed()
                .click();
        return this;
    }

}
