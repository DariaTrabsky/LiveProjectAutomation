package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.AboutUsPage;
import utils.BrowserUtils;

import java.util.Map;

public class AboutUsSteps {
    AboutUsPage page;

    public AboutUsSteps() {
        page = new AboutUsPage();
    }

    @When("Why Choose Us section loads")
    public void whyChooseUsSectionLoads() {
        BrowserUtils.waitForElementVisibility(page.aboutUsSection);
        BrowserUtils.click(page.aboutUsSection);
        BrowserUtils.isDisplayed(page.aboutUsSection);
    }

    @Then("this section should display the following headers with their descriptions:")
    public void thisSectionShouldDisplayTheFollowingHeadersWithTheirDescriptions(Map<String, String> services) {
        BrowserUtils.assertEquals(page.onTimeServicesText.getText(), services.get("On Time Services"));
        BrowserUtils.isDisplayed(page.onTimeServicesText);
        BrowserUtils.assertEquals(page.experiencedTeamText.getText(), services.get("Experienced Team"));
        BrowserUtils.isDisplayed(page.experiencedTeamText);
        BrowserUtils.assertEquals(page.goodTrackRecordsText.getText(), services.get("Good Track Records"));
        BrowserUtils.isDisplayed(page.goodTrackRecordsText);

    }

    @And("We are Recruitment Experts text is displayed on the page")
    public void weAreRecruitmentExpertsTextIsDisplayedOnThePage() {
    }
}

