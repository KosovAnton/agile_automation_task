package stepdefinitions;

import cucumber.api.java.en.And;
import html.pages.HomePage;

public class SideBarStepdefs {

    HomePage homePage = new HomePage();

    @And("^User opens profile page$")
    public void userOpensProfilePage() {
        homePage.openProfile();
    }
}
