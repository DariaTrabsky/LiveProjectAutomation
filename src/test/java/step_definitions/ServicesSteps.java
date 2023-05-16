package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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
            case "Others":
                BrowserUtils.clickWithJs(page.othersDivisionBtn);
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

    @Then("I click on mini navigation button {string}")
    public void iClickOnMiniNavigationButton(String button) {
        switch (button.trim()) {
            case "finance":
                BrowserUtils.clickWithJs(page.financeInitialLink);
                BrowserUtils.isDisplayed(page.financeInitialLink);
                break;
            case "information technology":
                BrowserUtils.clickWithJs(page.iTNaviBtn);
                BrowserUtils.isDisplayed(page.iTNaviBtn);
                break;
            case "healthcare":
                BrowserUtils.clickWithJs(page.healthCareBtn);
                BrowserUtils.isDisplayed(page.healthCareBtn);
                break;
            case "government projects":
                BrowserUtils.clickWithJs(page.governmentProjectsBtn);
                BrowserUtils.isDisplayed(page.governmentProjectsBtn);
                break;
            case "others":
                BrowserUtils.clickWithJs(page.othersBtn);
                BrowserUtils.isDisplayed(page.othersBtn);
                break;
            default:
                System.out.println("Invalid button");
        }
    }

    @When("I click on {string} division button")
    public void iClickOnDivisionButton(String link) {
        BrowserUtils.clickWithJs(page.financeDivisionBtn);
        BrowserUtils.switchToNewWindow();
        BrowserUtils.sleep(2000);

    }
    @When("I click on {string} navigation button")
    public void iClickOnNavigationButton(String textLinks) {
        switch (textLinks.trim()) {
            case "Finance":
                BrowserUtils.clickWithJs(page.financeNaviBtn);
                BrowserUtils.sleep(2000);
                break;
            case "Information Technology":
                BrowserUtils.clickWithJs(page.iTNaviBtn);
                BrowserUtils.sleep(2000);
                break;
            case "Healthcare":
                BrowserUtils.clickWithJs(page.healthCareBtn);
                BrowserUtils.sleep(2000);
                break;
            case "Government Projects":
                BrowserUtils.clickWithJs(page.governmentProjectsBtn);
                BrowserUtils.sleep(2000);
                break;
            case "Others":
                BrowserUtils.clickWithJs(page.othersBtn);
                BrowserUtils.sleep(2000);
                break;
            default:
                System.out.println("Invalid button");
        }
    }

    @Then("verify the following  are displayed and go to corresponding {string}")
    public void verifyTheFollowingAreDisplayedAndGoToCorresponding(String URL) {
        switch (URL.trim()) {
            case "https://tla-batch7.github.io/advancesystems-test-b7/division-finance.html":
                BrowserUtils.clickWithJs(page.financeNaviBtn);
                BrowserUtils.switchToNewWindow();
                BrowserUtils.sleep(3000);
                BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
                break;
            case "https://tla-batch7.github.io/advancesystems-test-b7/division-it.html":
                BrowserUtils.clickWithJs(page.iTNaviBtn);
                BrowserUtils.switchToNewWindow();
                BrowserUtils.sleep(3000);
                BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
                break;
            case "https://tla-batch7.github.io/advancesystems-test-b7/division-healthcare.html":
                BrowserUtils.clickWithJs(page.healthCareBtn);
                BrowserUtils.switchToNewWindow();
                BrowserUtils.sleep(3000);
                BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
                break;
            case "https://tla-batch7.github.io/advancesystems-test-b7/division-government.html":
                BrowserUtils.clickWithJs(page.governmentProjectsBtn);
                BrowserUtils.switchToNewWindow();
                BrowserUtils.sleep(3000);
                BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
                break;
            case "https://tla-batch7.github.io/advancesystems-test-b7/division-others.html":
                BrowserUtils.clickWithJs(page.othersBtn);
                BrowserUtils.switchToNewWindow();
                BrowserUtils.sleep(3000);
                BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
                break;
            default:
                System.out.println("Invalid Link");
                Assert.fail();
        }
    }

    @Then("verify header, main image, description, quote is displayed")
    public void verifyHeaderMainImageDescriptionQuoteIsDisplayed() {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.sleep(2000);
        BrowserUtils.isDisplayed(page.financeHeader);
        BrowserUtils.sleep(3000);
        BrowserUtils.isDisplayed(page.allDivisionImages);
        BrowserUtils.sleep(3000);
        BrowserUtils.isDisplayed(page.descriptionBtn);
        BrowserUtils.sleep(3000);
        BrowserUtils.isDisplayed(page.quote);


    }


    @When("I click on {string} buttons on main page")
    public void iClickOnButtonsOnMainPage(String division2) {
        switch (division2) {
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
            case "Others":
                BrowserUtils.clickWithJs(page.othersDivisionBtn);
                break;
            default:
                Assert.fail("Unknown division button");
        }
    }
}


