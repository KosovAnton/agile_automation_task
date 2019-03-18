package html.pages;

import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static utils.GlobalValues.*;

public class BasePage extends HtmlElement {

    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(DRIVER)), this);
    }

}
