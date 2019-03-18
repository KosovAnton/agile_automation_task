package html.blocks;

import html.elements.Button;
import html.elements.Input;
import html.elements.Link;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Post message popup")
@FindBy(id = "pagelet_timeline_composer")
public class PostMessagePopup extends HtmlElement {

    @Name("Create publication")
    @FindBy(xpath = ".//a[contains(@class,'STATUS')]")
    private Link createPublication;

    @Name("Textbox")
    @FindBy(xpath = ".//div[@role='textbox']")
    private Input textbox;

    @Name("Submit")
    @FindBy(xpath = ".//button[type='submit']")
    private Button submit;

    public PostMessagePopup fillTextbox(String text) {
        textbox.shouldBeDisplayed()
                .sendKeys(text);
        return this;
    }

    public PostMessagePopup clickSubmitButton() {
        textbox.shouldBeDisplayed()
                .click();
        return this;
    }

    public PostMessagePopup open() {
        createPublication.shouldBeDisplayed()
                .click();
        return this;
    }

}
