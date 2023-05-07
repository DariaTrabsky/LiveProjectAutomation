package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;
import java.util.Map;


import static utils.BrowserUtils.getDriver;

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

    @Then("Verify corresponding window has url as {string}")
    public void verifyCorrespondingWindowHasUrlAs(String URL) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
    }


    @And("I click on secondary navigation bar button {string}")
    public void iClickOnNavigationBarButton(String navbtn) {
        BrowserUtils.sleep(3000);
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
}

