package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.AboutUsPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;
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

    @Then("verify main header is {string}")
    public void verify_main_header_is(String string) {

        String actual = BrowserUtils.getText(page.pageHeader);
        String expected = "Welcome to Advance Systems LLC.";
        BrowserUtils.assertEquals(expected, actual);

    }
    @Then("verify this section should contain name and title of the person.")
    public void verifyThisSectionShouldContainNameAndTitleOfThePerson() {

        BrowserUtils.isDisplayed(page.nameOfPerson);
        BrowserUtils.getText(page.nameOfPerson);

        BrowserUtils.isDisplayed(page.titleOfPerson);
        BrowserUtils.getText(page.titleOfPerson);
    }
    @Then("verify employee header is {string}")
    public void verifyEmployeeHeaderIs(String str) {

        String actual = BrowserUtils.getText(page.employeeSHeader);
        String expected = "Meet Our Experts";
        BrowserUtils.assertEquals(expected, actual);
    }
    @And("verify the following information is displayed:")
    public void verifyTheFollowingInformationIsDisplayed(List<String> employeeInfo) {

        for (String info : employeeInfo) {
            switch (info) {
                case "picture":
                    BrowserUtils.isDisplayed(page.founderPic);
                    break;
                case "title":
                    BrowserUtils.isDisplayed(page.founderTitle);
                    break;
                case "quote":
                    BrowserUtils.isDisplayed(page.founderQuoteText);
                    break;
                case "social media links":
                    for (WebElement element : page.socialMedia) {
                        BrowserUtils.isDisplayed(element);
                        break;
                    }
                default:
                    System.out.println("Invalid employee information");
            }
        }

    }

    @Then("following {string} media button should take to corresponding pages:")
    public void followingMediaButtonShouldTakeToCorrespondingPages(String social) {


        switch (social) {
            case "Facebook":
                BrowserUtils.click(page.facebookLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            case "twitter":
                BrowserUtils.click(page.twitterLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            case "Skype":
                BrowserUtils.click(page.skypeLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            case "Linkedin":
                BrowserUtils.click(page.linkedinLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            default:
                System.out.println("Invalid link");
        }

    }
    @Then("button {string} should take to corresponding pages")
    public void buttonShouldTakeToCorrespondingPages(String social) {

        //BrowserUtils.click(page.aboutUsNavBtn);

        switch (social) {
            case "Facebook":
                BrowserUtils.click(page.facebookLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            case "twitter":
                BrowserUtils.click(page.twitterLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            case "Skype":
                BrowserUtils.click(page.skypeLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            case "Linkedin":
                BrowserUtils.click(page.linkedinLink);
                BrowserUtils.getDriver().getTitle();
                BrowserUtils.switchToNewWindow();
                break;
            default:
                System.out.println("Invalid link");
        }
    }

    @Then("verify following headers with descriptions are displayed:")
    public void verifyFollowingHeadersWithDescriptionsAreDisplayed() {

        for (WebElement element : page.whyChooseUsSHeader) {
            System.out.println(BrowserUtils.getText(element));
        }
        int expected = 4;
        if (expected == page.whyChooseUsSHeader.size()) {
            System.out.println("Number of headers = " + page.whyChooseUsSHeader.size());

        }
    }
}


