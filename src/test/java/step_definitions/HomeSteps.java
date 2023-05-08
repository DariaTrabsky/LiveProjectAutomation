package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
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

    @Then("Verify corresponding window has url as {string}")
    public void verifyCorrespondingWindowHasUrlAs(String URL) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.sleep(3000);
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
    }


    @And("I click on secondary navigation bar button {string}")
    public void iClickOnNavigationBarButton(String navbtn) {
            switch(navbtn.trim()){
                case "Home":
                    BrowserUtils.click(page.homeSecNavBarBtn);
                    break;
                case "About Us":
                    BrowserUtils.click(page.aboutUsSecNavBtn);
                    break;
                case "Services":
                    BrowserUtils.click(page.servicesSecNavBtn);
                    break;
                case "Clients":
                    BrowserUtils.click(page.clientsSecNavBtn);
                    break;
                case "Join Us":
                    BrowserUtils.click(page.joinUsSecNavBtn);
                    break;
                case "Contact Us":
                    BrowserUtils.click(page.contactUsSecNavBtn);
                    break;
                default:
                    System.out.println("Invalid Link");
                    Assert.fail();


            }

        }

    @When("I scroll down the page")
    public void iScrollDownThePage() {
        BrowserUtils.moveIntoView(page.scrollIntoView);
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
                    BrowserUtils.isDisplayed(page.facebookFtBtn);
                    break;
                case "Twitter":
                    BrowserUtils.isDisplayed(page.twitterFtBtn);
                    break;
                case "Instagram":
                    BrowserUtils.isDisplayed(page.instagramFtBtn);
                    break;
                case "LinkedIn":
                    BrowserUtils.isDisplayed(page.linkedinFtBtn);
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

    @And("verify {string} buttons are displayed on the main page")
    public void verifyButtonsAreDisplayedOnTheMainPage(String socialMedia) {
        switch (socialMedia) {
            case "facebook":
                BrowserUtils.isDisplayed(page.facebookBtn);
                break;
            case "twitter":
                BrowserUtils.isDisplayed(page.twitterBtn);
                break;
            case "instagram":
                BrowserUtils.isDisplayed(page.instagramBtn);
                break;
            case "linkedin":
                BrowserUtils.isDisplayed(page.linkedinBtn);
                break;
            default:
                Assert.fail("Unknown social media button");
        }
    }

    @Then("verify when media button is clicked user gets redirected to the {string} page")
    public void verifyWhenMediaButtonIsClickedUserGetsRedirectedToThePage(String expectedUrl) throws InterruptedException {
        switch (expectedUrl) {
            case "https://www.facebook.com/":
                BrowserUtils.click(page.facebookBtn);
                String actualUrlFacebook = BrowserUtils.getDriver().getCurrentUrl();
                Assert.assertEquals(expectedUrl, actualUrlFacebook);
                WebElement facebookTitle = BrowserUtils.getDriver().findElement(By.xpath("//title[contains(text(),'Facebook')]"));
                BrowserUtils.highlightElement(facebookTitle);
                break;
            case "https://twitter.com/":
                BrowserUtils.click(page.twitterBtn);
                String actualUrlTwitter = BrowserUtils.getDriver().getCurrentUrl();
                Assert.assertEquals(expectedUrl, actualUrlTwitter);
                WebElement twitterTitle = BrowserUtils.getDriver().findElement(By.xpath("//title[contains(text(),'Twitter')]"));
                BrowserUtils.highlightElement(twitterTitle);
                break;
            case "https://www.instagram.com/":
                BrowserUtils.click(page.instagramBtn);
                String actualUrlInstagram = BrowserUtils.getDriver().getCurrentUrl();
                Assert.assertEquals(expectedUrl, actualUrlInstagram);
                WebElement instagramTitle = BrowserUtils.getDriver().findElement(By.xpath("//title[contains(text(),'Instagram')]"));
                BrowserUtils.highlightElement(instagramTitle);

                break;
            case "https://www.linkedin.com/":
                BrowserUtils.click(page.linkedinBtn);
                String actualUrlLinkedin = BrowserUtils.getDriver().getCurrentUrl();
                Assert.assertEquals(expectedUrl, actualUrlLinkedin);
                WebElement linkedinTitle = BrowserUtils.getDriver().findElement(By.xpath("//title[contains(text(),'LinkedIn')]"));
                BrowserUtils.highlightElement(linkedinTitle);
                break;
            default:
                Assert.fail("Unknown social media button");
        }
    }

    @Then("verify email input field with a place holder is displayed")
    public void verifyEmailInputFieldWithAPlaceHolderIsDisplayed() {
        BrowserUtils.isDisplayed(page.emailPlaceholderFt);
    }
}

