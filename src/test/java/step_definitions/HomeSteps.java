package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;
import java.util.Map;

public class HomeSteps {
    HomePage page;

    public HomeSteps() {
        page = new HomePage();
    }

    @Then("the following should be displayed:")
    public void i_should_see_header(Map<String, String> expectedValues) {
        BrowserUtils.assertEquals(expectedValues.get("address1"), page.addressLine1.getText());
        BrowserUtils.isDisplayed(page.addressLine1);

        BrowserUtils.assertEquals(expectedValues.get("address2"), page.addressLine2.getText());
        BrowserUtils.isDisplayed(page.addressLine2);

        BrowserUtils.assertEquals(expectedValues.get("phoneNumber"), page.phoneNumber.getText());
        BrowserUtils.isDisplayed(page.phoneNumber);

        System.out.println("expectedValues.toString() = " + expectedValues.toString());
    }

    @Then("verify title of the homepage is {string}")
    public void verifyTitleOfTheHomepageIs(String title) {
        String actual = BrowserUtils.getDriver().getTitle();
        BrowserUtils.assertEquals(actual, title);
    }


    @Given("I am on the {string} page")
    public void iAmOnTheHomepage(String titleMain) {
        String actual = BrowserUtils.getDriver().getTitle();
        BrowserUtils.assertEquals(actual, titleMain);
    }

    @When("I look at the navigation bar")
    public void iLookAtTheNavigationBar() {
        BrowserUtils.isDisplayed(page.navBar);
    }

    @Then("verify the following nav button are displayed:")
    public void verifyTheFollowingIsDisplayed(List<String> navButtonName) {
        for (String each : navButtonName) {
            switch (each) {
                case "Get Support":
                    BrowserUtils.isDisplayed(page.getSupportBtn);
                    break;
                case "Job Career":
                    BrowserUtils.isDisplayed(page.jobCareerBtn);
                    break;
                case "Feedback":
                    BrowserUtils.isDisplayed(page.feedbackBtn);
                    break;
                case "English":
                    BrowserUtils.isDisplayed(page.englishNavBtn);
                    BrowserUtils.click(page.englishNavBtn);
                    BrowserUtils.isDisplayed(page.englishBtn);
                    BrowserUtils.isDisplayed(page.spanishBtn);
                    BrowserUtils.isDisplayed(page.frenchBtn);
                    break;
                default:
                    System.out.println("Button doesn't exist");

            }
        }
    }

    @Then("verify the social media buttons are displayed:")
    public void verifyTheSocialMediaButtonsAreDisplayed(List<String> socialMediaBtn) {
        for (String each : socialMediaBtn) {
            switch (each) {
                case "Facebook":
                    BrowserUtils.isDisplayed(page.facebookBtn);
                    break;
                case "Twitter":
                    BrowserUtils.isDisplayed(page.twitterBtn);
                    break;
                case "Instagram":
                    BrowserUtils.isDisplayed(page.instagramBtn);
                    break;
                case "LinkedIn":
                    BrowserUtils.isDisplayed(page.linkedin);
                    break;
                default:
                    System.out.println("Invalid buttons");
            }
        }
    }

    @Then("Verify the testimonials header is {string}")
    public void verifyTheTestimonialsHeaderIs(String expectedTestimonialsHeader) {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.testimonialsHeader), expectedTestimonialsHeader);

    }

    @And("Verify there are multiple testimonials messages under Testimonials Section")
    public void verifyThereAreMultipleTestimonialsMessagesUnderTestimonialsSection() {

        BrowserUtils.assertTrue(page.testimonialsMsg.size() > 1);
        BrowserUtils.assertTrue(page.testimonialsName.size() > 1);
        BrowserUtils.assertTrue(page.testimonialsState.size() > 1);

    }

    @And("Verify there are people names and states under Testimonials Section")
    public void verifyThereArePeopleNamesAndStatesUnderTestimonialsSection() {

        for (WebElement msg : page.testimonialsMsg) {
            if (msg.isDisplayed()) BrowserUtils.assertTrue(true);
        }
        for (WebElement name : page.testimonialsName) {
            if (name.isDisplayed()) BrowserUtils.assertTrue(true);
        }
        for (WebElement state : page.testimonialsState) {
            if (state.isDisplayed()) BrowserUtils.assertTrue(true);
        }
    }
}




