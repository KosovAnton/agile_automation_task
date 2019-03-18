package html.pages;

import html.blocks.SideBar;

import static utils.GlobalValues.BASE_URL;
import static utils.GlobalValues.DRIVER;

public class HomePage extends BasePage {

    private SideBar sideBar;

    public void openProfile() {
        sideBar.clickProfileLink();
    }

    public HomePage open(){
        DRIVER.get(BASE_URL);
        return this;
    }

}
