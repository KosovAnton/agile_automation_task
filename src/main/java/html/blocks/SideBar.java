package html.blocks;

import html.elements.Link;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Side bar navigation panel")
@FindBy(id = "pagelet_navigation")
public class SideBar extends HtmlElement {

    @Name("Profile link")
    @FindBy(xpath = ".//a[contains(@data-gt,'self_timeline')]")
    private Link profile;

    public void clickProfileLink(){
        profile.shouldBeDisplayed()
                .click();
    }

}
