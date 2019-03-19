package html.blocks;

import html.elements.Button;
import html.elements.Input;
import html.elements.Link;
import html.elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.GlobalValues;
import utils.JsUtils;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static utils.GlobalValues.DEFAULT_WAITING_TIMEOUT;
import static utils.GlobalValues.DRIVER;

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
