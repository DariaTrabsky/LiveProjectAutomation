package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.AboutUsPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.Map;

public class AboutUsSteps {
    AboutUsPage page;
    HomePage Homepage;

    public AboutUsSteps() {
        page = new AboutUsPage();
        Homepage = new HomePage();
    }

    @When("Why Choose Us section loads")
    public void whyChooseUsSectionLoads() {
        BrowserUtils.sleep(3000);
        BrowserUtils.clickWithJs(page.aboutUsSection);
        BrowserUtils.waitForElementVisibility(page.aboutUsSection);
        BrowserUtils.sleep(3000);
        BrowserUtils.isDisplayed(page.aboutUsSection);
        BrowserUtils.sleep(3000);
    }

    @Then("this section should display the following headers with their descriptions:")
    public void thisSectionShouldDisplayTheFollowingHeadersWithTheirDescriptions(Map<String, String> services) {
        BrowserUtils.click(Homepage.moveToTopBtn);
        BrowserUtils.isDisplayed(page.onTimeServicesHeader);
        BrowserUtils.assertEquals(page.onTimeServicesText.getText(), services.get("On Time Services"));
        BrowserUtils.sleep(3000);
        BrowserUtils.click(Homepage.moveToTopBtn);
        BrowserUtils.isDisplayed(page.experiencedTeamHeader);
        BrowserUtils.assertEquals(page.experiencedTeamText.getText(), services.get("Experienced Team"));
        BrowserUtils.sleep(3000);
        BrowserUtils.click(Homepage.moveToTopBtn);
        BrowserUtils.isDisplayed(page.goodTrackRecordsHeader);
        BrowserUtils.assertEquals(page.goodTrackRecordsText.getText(), services.get("Good Track Records"));


    }

    @And("We are Recruitment Experts text is displayed on the page")
    public void weAreRecruitmentExpertsTextIsDisplayedOnThePage() {
        page.WeAreRecruitmentExpertsText.isDisplayed();
    }

    @Then("verify title of the services page is {string}")
    public void verifyTitleOfTheServicesPageIs(String title) {
        String actual = BrowserUtils.getDriver().getTitle();
        BrowserUtils.assertEquals(actual, title);
    }
}


