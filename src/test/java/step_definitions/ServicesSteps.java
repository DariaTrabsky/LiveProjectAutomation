package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ServicesPage;
import utils.BrowserUtils;

import java.util.List;

public class ServicesSteps {
    ServicesPage page;
    HomePage homePage;

    public ServicesSteps() {
        page = new ServicesPage();
        homePage = new HomePage();
    }

    @Then("verify {string} is displayed")
    public void verify_is_displayed(String division) {
        switch (division) {
            case "Finance":
                BrowserUtils.isDisplayed(page.financeDivisionBtn);
                break;
            case "Information Technology":
                BrowserUtils.isDisplayed(page.iTDivisionBtn);
                break;
            case "Healthcare":
                BrowserUtils.isDisplayed(page.healthcareDivisionBtn);
                break;
            case "Government Projects":
                BrowserUtils.isDisplayed(page.governmentProjectsDivisionBtn);
                break;
            default:
                Assert.fail("Unknown division button");
        }
    }

    @Then("verify division is clicked user gets redirected to the {string} page")
    public void verify_division_is_clicked_user_gets_redirected_to_the_page(String pageTitle) {
        WebElement webElement = null;
        switch (pageTitle) {
            case "Advance Systems - Finance Division":
                webElement = page.financeDivisionBtn;
                break;

            case "Advance Systems - IT Division":
                webElement = page.iTDivisionBtn;
                break;

            case "Advance Systems - Healthcare Division":
                webElement = page.healthcareDivisionBtn;
                break;

            case "Advance Systems - Government Projects Division":
                webElement = page.governmentProjectsDivisionBtn;
                break;

            default:
                Assert.fail("Unknown division page title");
        }
        BrowserUtils.clickWithJs(webElement);
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(pageTitle, BrowserUtils.getDriver().getTitle());
    }


    @When("I click on {string} buttons")
    public void iClickOnButtons(String division) {
        switch (division) {
            case "Finance":
                BrowserUtils.clickWithJs(page.financeDivisionBtn);
                break;
            case "Information Technology":
                BrowserUtils.clickWithJs(page.iTDivisionBtn);
                break;
            case "Healthcare":
                BrowserUtils.clickWithJs(page.healthcareDivisionBtn);
                break;
            case "Government Projects":
                BrowserUtils.clickWithJs(page.governmentProjectsDivisionBtn);
                break;
            default:
                Assert.fail("Unknown division button");
        }
    }

    @Then("Verify the contacts are displayed")
    public void verifyTheContactsAreDisplayed() {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.isDisplayed(page.addressDivisionContact);
        BrowserUtils.click(homePage.moveToTopBtn);
        BrowserUtils.isDisplayed(page.callUsDivisionContact);
    }
}

