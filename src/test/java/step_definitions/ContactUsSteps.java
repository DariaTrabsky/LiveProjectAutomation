package step_definitions;

import io.cucumber.java.en.Then;
import pages.ContactPage;
import utils.BrowserUtils;

import java.util.List;

public class ContactUsSteps {
    ContactPage page;
    public ContactUsSteps(){
        page = new ContactPage();
    }

    @Then("verify the following input fields are displayed")
    public void verify_the_following_input_fields_are_displayed(List<String>inputFields) {
        for (String filed: inputFields){
            switch (filed.toLowerCase()){
                case "name":
                    BrowserUtils.isDisplayed(page.yourNameInputFiled);
                    BrowserUtils.clickWithJs(page.yourNameInputFiled);
                    break;
                case "phone number":
                    BrowserUtils.isDisplayed(page.phoneNumberInputFiled);
                    break;
                case "option to create a service type":
                    BrowserUtils.isDisplayed(page.serviceOption);
                    break;
                case "box to enter a message":
                    BrowserUtils.isDisplayed(page.yourMessageInputFiled);
                    break;
                case "button to send the request":
                    BrowserUtils.isDisplayed(page.submitBtn);
                    break;
                default:
                    System.out.println("Invalid input filed");

            }
        }
    }

}
