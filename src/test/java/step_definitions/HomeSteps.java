package step_definitions;

import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;

public class HomeSteps {
    HomePage page;
    public HomeSteps() { page = new HomePage(); }
    @Then("the following should be displayed:")
    public void i_should_see_header(List<String> button) {
        for (String each : button) {
            switch (each) {
                case "10090 Main Street":
                    BrowserUtils.click(page.addressLine1);
                    break;
                case "Fairfax, VA, USA":
                    BrowserUtils.click(page.addressLine2);
                    break;
                case "+1 703-831-3227":
                    BrowserUtils.click(page.phoneNumber);
                    break;
            }
        }
    }

}
