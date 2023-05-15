package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AboutUsPage;
import pages.HomePage;
import pages.JoinUsPage;
import utils.BrowserUtils;

public class JoinUsSteps {
    JoinUsPage page;
    HomePage homePage;
    AboutUsPage aboutUsPage;
    public JoinUsSteps(){
        page = new JoinUsPage();
        homePage = new HomePage();
        aboutUsPage = new AboutUsPage();
    }

    @When("I click on {string} button")
    public void i_click_on_button(String button) {
        switch (button.toLowerCase()){
            case "join now":
                BrowserUtils.click(homePage.joinNowBtn);
                BrowserUtils.switchToNewWindow();
                break;
            case "services":
                BrowserUtils.click(homePage.servicesNavBtn);
                BrowserUtils.switchToNewWindow();
                break;
            case "contact us":
                BrowserUtils.click(homePage.contactUsNavBtn);
                BrowserUtils.switchToNewWindow();
                break;
            case "about us":
                BrowserUtils.click(homePage.aboutUsSecNavBtn);
                BrowserUtils.switchToNewWindow();
                break;
            case "our services":
                BrowserUtils.click(aboutUsPage.OurServicesBtn);
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
