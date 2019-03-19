package html.blocks;

import html.elements.Button;
import html.elements.Text;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Posted message")
@FindBy(xpath = ".//div[contains(@id,'timeline_story_container')]//div[@role='article']")
public class PostedMessage extends HtmlElement {

    @Name("Text message")
    @FindBy(xpath = ".//div[contains(@class,'userContent')]//p")
    private Text postedText;

    @Name("Show options")
    @FindBy(xpath = ".//a[@data-testid='post_chevron_button']")
    private Button showOptions;

    @Name("Edit option")
    @FindBy(xpath = "//a[@data-feed-option-name='FeedEditOption']")
    private Button editOption;

    @Name("Delete option")
    @FindBy(xpath = "(//a[@data-feed-option-name='FeedDeleteOption'])[2]")
    private Button deleteOption;

    public PostedMessage openOptionsMenu() {
        showOptions.shouldBeDisplayed()
                .click();
        return this;
    }

    public void selectEditOption(){
        editOption.shouldBeDisplayed()
                .click();
    }

    public void selectDeleteOption(){
        deleteOption.shouldBeDisplayed()
                .click();
    }

    public String getPostedText(){
        return postedText.shouldBeDisplayed()
                .getText();
    }

}
