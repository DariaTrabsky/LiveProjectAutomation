package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        BrowserUtils.assertEquals(actual,title);
    }


    @Then("verify read more button is displayed and takes user to the services page")
    public void verifyReadMoreButtonIsDisplayedAndTakesUserToTheServicesPage() {
        BrowserUtils.isDisplayed(page.homePageReadMoreButton);

        BrowserUtils.click(page.homePageReadMoreButton);
        String expected = "Services";
        String actual = BrowserUtils.getDriver().getTitle();

        BrowserUtils.assertTrue(actual.contains(expected));
        BrowserUtils.click(page.header);
    }

    @Then("verify header is displayed")
    public void verifyHeaderIsDisplayed() {
        BrowserUtils.isDisplayed(page.homePageFHeader);
    }

    @Then("verify description is displayed")
    public void verifyDescriptionIsDisplayed() {
        BrowserUtils.isDisplayed(page.homePageDescription);
    }

    @Then("verify Section content should refresh with new set of header and description")
    public void verifySectionContentShouldRefreshWithNewSetOfHeaderAndDescription() {

        String firstHeader = BrowserUtils.getText(page.homePageFHeader);

        BrowserUtils.waitForElementVisibility(page.homePageSHeader);
        String secondHeader = BrowserUtils.getText(page.homePageSHeader);

        Assert.assertNotEquals(firstHeader,secondHeader);

    }

}
