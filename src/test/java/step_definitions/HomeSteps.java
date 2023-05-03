package step_definitions;

import io.cucumber.java.en.Then;
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

}
