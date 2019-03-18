package html.elements;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.decorators.MatcherDecoratorsBuilder.should;
import static ru.yandex.qatools.htmlelements.matchers.decorators.TimeoutWaiter.timeoutHasExpired;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.matchers.WebElementMatchers;

public class BaseWebElement<T> extends HtmlElement {

    protected final int DEFAULT_WAITING_TIMEOUT = 15;

    public T shouldBeDisplayed(){
        assertThat("Element " + this.getName() + " was not displayed during " + DEFAULT_WAITING_TIMEOUT + "seconds",
                this, should(WebElementMatchers.isDisplayed())
                        .whileWaitingUntil(timeoutHasExpired(SECONDS.toMillis(DEFAULT_WAITING_TIMEOUT))));
        return (T) this;
    }
}
