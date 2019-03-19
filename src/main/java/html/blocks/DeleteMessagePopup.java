package html.blocks;

import html.elements.BaseWebElement;
import html.elements.Button;
import html.elements.Input;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

@Name("Delete message popup")
@FindBy(xpath = ".//form[contains(@action,'delete')]")
public class DeleteMessagePopup extends BaseWebElement<DeleteMessagePopup> {

    @Name("Submit")
    @FindBy(xpath = ".//button[@type='submit']")
    private Button submit;

    public DeleteMessagePopup clickSubmitButton() {
        submit.shouldBeDisplayed()
                .click();
        return this;
    }

}
