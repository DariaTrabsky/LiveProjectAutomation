package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.JoinUsPage;
import utils.BrowserUtils;

public class JoinUsSteps {
    JoinUsPage page;
    HomePage homePage;
    public JoinUsSteps(){
        page = new JoinUsPage();
        homePage = new HomePage();
    }

    @When("I click on {string} button")
    public void i_click_on_button(String button) {
        switch (button.toLowerCase()){
            case "join now":
                BrowserUtils.click(homePage.joinNowBtn);
                BrowserUtils.switchToNewWindow();
                break;
            default:
                System.out.println("Invalid button");
        }
    }

    @Then("verify page-info {string} is display")
    public void verifyPageInfoIsDisplay(String pageInfo) {
        switch (pageInfo){
            case "Join Us":
                BrowserUtils.isDisplayed(page.joinUsPageInfo);
                break;
            default:
                System.out.println("Invalid page-info");
        }
    }
}
